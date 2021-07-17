package it.truecloud.ddns.felix.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import it.truecloud.ddns.felix.Configuration;
import it.truecloud.ddns.felix.security.AdministrativeUserDetailsService;
import it.truecloud.ddns.felix.security.JwtTokenUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private AdministrativeUserDetailsService administrativeUserDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authorizationHeader = request.getHeader(Configuration.AUTHORIZATION_HEADER);

        String username = null;
        String jwt = null;

        // These conditions are verified only if the user is trying to authenticate with bearer authentication
        if (authorizationHeader != null && authorizationHeader.startsWith(Configuration.AUTHORIZATION_HEADER_TYPE)) {
            // Takes the authorization header content without "Bearer " string
            jwt = authorizationHeader.substring(Configuration.AUTHORIZATION_HEADER_TYPE.length() + 1);

            try {
                username = jwtTokenUtil.extractUsername(jwt);
            } catch (SignatureException | MalformedJwtException | ExpiredJwtException exception) {
                username = null;
            }
        }

        // These conditions are verified only if the username has been succesfully extracted
        // by the jwt token
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails;
            try {
                userDetails = this.administrativeUserDetailsService.loadUserByUsername(username);
            } catch (UsernameNotFoundException exception) {
                userDetails = null;
            }

            if (userDetails != null && jwtTokenUtil.validateToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
                    new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}