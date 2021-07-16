package it.truecloud.ddns.felix.security.authentication;

import java.util.Objects;

/**
 * The class represents an authentication requests.
 */
public class AuthenticationRequest {
    /**
     * Username or email of the user that requires authentication.
     */
    private String username;
    /**
     * Password to verify.
     */
    private String password;

    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AuthenticationRequest() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        AuthenticationRequest authenticationRequest = (AuthenticationRequest) obj;
        return (authenticationRequest.username.equals(username) &&
            authenticationRequest.password.equals(password));
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}