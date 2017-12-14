package org.thoth.crypto.asymmetric;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class RsaKeyPairProducer {

    /**
     * Generates a new RSA-4096 bit {@code KeyPair}.
     *
     * @return {@code KeyPair}, never null
     * @throws RuntimeException All exceptions are caught and re-thrown as {@code RuntimeException}
     */
    public KeyPair generate() {
        KeyPairGenerator keyGen;
        try {
            keyGen = KeyPairGenerator.getInstance("RSA");
            //keyGen.initialize(3072);
            keyGen.initialize(4096);
            return keyGen.generateKeyPair();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Regenerates a previous RSA-4096 bit {@code KeyPair}.
     *
     * @param encodedByteArrayForPrivateKey The bytes this method will use to regenerate a previously created {@code PrivateKey}
     * @param encodedByteArrayForPublicKey The bytes this method will use to regenerate a previously created {@code PublicKey}
     *
     * @return {@code KeyPair}, never null
     * @throws RuntimeException All exceptions are caught and re-thrown as {@code RuntimeException}
     */
    public KeyPair generate(byte[] encodedByteArrayForPrivateKey, byte[] encodedByteArrayForPublicKey) {
        try {
            PrivateKey privateKey = KeyFactory.getInstance("RSA")
                .generatePrivate(new PKCS8EncodedKeySpec(encodedByteArrayForPrivateKey));

            PublicKey publicKey = KeyFactory.getInstance("RSA")
                .generatePublic(new X509EncodedKeySpec(encodedByteArrayForPublicKey));

            return new KeyPair(publicKey, privateKey);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
