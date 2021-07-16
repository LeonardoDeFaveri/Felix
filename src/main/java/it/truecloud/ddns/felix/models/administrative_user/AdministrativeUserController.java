package it.truecloud.ddns.felix.models.administrative_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.truecloud.ddns.felix.Configuration;
import it.truecloud.ddns.felix.security.AdministrativeUserDetailsService;
import it.truecloud.ddns.felix.security.JwtTokenUtil;
import it.truecloud.ddns.felix.security.authentication.AuthenticationRequest;
import it.truecloud.ddns.felix.security.authentication.AuthenticationResponse;

@RestController
public class AdministrativeUserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private AdministrativeUserDetailsService administrativeUserDetailsService;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    static final String BAD_CREDENTIALS_MSG = "Invalid username or password";

    /**
     * Checks user's credentials and if valid returns a JWT token as response.
     * @param authenticationRequest authentication request
     * @return JWT token if valid credentials has been provided
     * @throws Exception
     */
    @PostMapping(path = Configuration.AUTHENTICATION_END_POINT)
    public ResponseEntity<?> createAuthenticationToken
        (@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getUsername()
                )
            );
        } catch (BadCredentialsException exception) {
            throw new Exception(BAD_CREDENTIALS_MSG, exception);
            /*ResponseEntity output = ResponseEntity.ok(BAD_CREDENTIALS_MSG);
            return output;*/
        }

        final UserDetails userDetails = administrativeUserDetailsService.loadUserByUsername(
            authenticationRequest.getUsername()
        );
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
