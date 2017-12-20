package org.thoth.crypto.asymmetric;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class RsaPublicKeyProducer {

    /**
     * Regenerates a previous RSA {@code PublicKey}.
     *
     * @param encodedByteArrayForPublicKey The bytes this method
     * will use to regenerate a previously created {@code PublicKey}
     *
     * @return {@code PublicKey}, never null
     * @throws RuntimeException All exceptions are caught
     * and re-thrown as {@code RuntimeException}
     */
    public PublicKey produce(byte[] encodedByteArrayForPublicKey) {
        try {
            PublicKey publicKey = KeyFactory.getInstance("RSA")
                .generatePublic(new X509EncodedKeySpec(encodedByteArrayForPublicKey));

            return publicKey;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
