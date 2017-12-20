package org.thoth.crypto.asymmetric;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class RsaKeyPairProducer {

    /**
     * Generates a new RSA-4096 bit {@code KeyPair}.
     *
     * @return {@code KeyPair}, never null
     * @throws RuntimeException All exceptions are caught
     * and re-thrown as {@code RuntimeException}
     */
    public KeyPair produce() {
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
}
