package cloud.nativ.javaee.jwks;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import lombok.extern.slf4j.Slf4j;

/**
 * A simple test client to show how to obtain a JWK for a given Key ID using Auth0.
 */
@Slf4j
public class JwksAuth0TestClient {

    public static void main(String[] args) throws Exception {
        JwkProvider provider = new UrlJwkProvider("http://localhost:8080/");
        Jwk jwk = provider.get("testKeyID");
        LOGGER.info("Found JWK {}", jwk);
    }

}
