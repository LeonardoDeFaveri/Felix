package it.truecloud.ddns.felix.security.authentication;

/**
 * The class represents the response of an authentication request.
 */
public class AuthenticationResponse {
    /**
     * JWT token.
     */
    private String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        AuthenticationResponse authenticationResponse = (AuthenticationResponse) obj;
        return (authenticationResponse.jwt.equals(jwt));
    }

    @Override
    public int hashCode() {
        return jwt.hashCode();
    }
}