package io.github.hylexus.yassos.client.service;

import io.github.hylexus.yassos.client.exception.TokenValidateException;
import io.github.hylexus.yassos.client.model.SessionInfo;

/**
 * @author hylexus
 * Created At 2019-06-10 21:57
 */
public interface TokenValidator {
    /**
     * @param token ticket
     * @param url   the target url to access with this {@code token} (ticket)
     * @return current session info if
     * @throws TokenValidateException throw an exception if token validation fails.
     */
    SessionInfo validateToken(String token, String url) throws TokenValidateException;

    /**
     * @param token ticket
     * @return true if the token is expired successfully
     * @throws TokenValidateException throw an exception if the communication to SSO-server is abnormal or other abnormalities occur
     */
    boolean expireToken(String token) throws TokenValidateException;

}
