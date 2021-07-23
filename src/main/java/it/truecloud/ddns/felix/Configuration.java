package it.truecloud.ddns.felix;

public interface Configuration {
    /**
     * API endpoint. Ends with /.
     */
    String END_POINT = "/felix/api/";

    /**
     * API authentication end point.
     */
    String AUTHENTICATION_END_POINT = END_POINT + "authentication/";

    /**
     * Lifetime of JWT token: 8 hours.
     */
    Integer TIMEOUT = 1000 * 60 * 60 * 8; // Lifetime of JWT token: 8 hours

    /**
     * Authorization header's name in HTTP messages.
     */
    String AUTHORIZATION_HEADER = "Authorization";

    /**
     * The authorization header type. Its content starts with
     * this string.
     */
    String AUTHORIZATION_HEADER_TYPE = "Bearer";
}