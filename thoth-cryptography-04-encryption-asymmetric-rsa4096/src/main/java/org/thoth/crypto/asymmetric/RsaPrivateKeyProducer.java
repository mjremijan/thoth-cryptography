package org.thoth.crypto.asymmetric;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class RsaPrivateKeyProducer {

    /**
     * Regenerates a previous RSA {@code PrivateKey}.
     *
     * @param encodedByteArrayForPrivateKey The bytes this method will use to regenerate a previously created {@code PrivateKey}
     *
     * @return {@code PrivateKey}, never null
     * @throws RuntimeException All exceptions are caught and re-thrown as {@code RuntimeException}
     */
    public PrivateKey produce(byte[] encodedByteArrayForPrivateKey) {
        try {
            PrivateKey privateKey = KeyFactory.getInstance("RSA")
                .generatePrivate(new PKCS8EncodedKeySpec(encodedByteArrayForPrivateKey));

            return privateKey;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
