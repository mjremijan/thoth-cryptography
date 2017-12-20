package org.thoth.crypto.symmetric;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Aes256SecretKeyProducer {

    /**
     * Generates a new AES-256 bit {@code SecretKey}.
     *
     * @return {@code SecretKey}, never null
     * @throws RuntimeException All exceptions are caught and re-thrown as {@code RuntimeException}
     */
    public SecretKey produce() {
        KeyGenerator keyGen;
        try {
            keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            SecretKey secretKey = keyGen.generateKey();
            return secretKey;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    /**
     * Generates an AES-256 bit {@code SecretKey}.
     *
     * @param encodedByteArray The bytes this method will use to regenerate a previously created {@code SecretKey}
     *
     * @return {@code SecretKey}, never null
     * @throws RuntimeException All exceptions are caught and re-thrown as {@code RuntimeException}
     */
    public SecretKey produce(byte [] encodedByteArray) {
        try {
            return new SecretKeySpec(encodedByteArray, "AES");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
