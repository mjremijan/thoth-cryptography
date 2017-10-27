package org.thoth.security.symmetric.aes256;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class GenerateAES256SecretKey {

    public static void main(String[] args) throws Exception {
        {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            SecretKey secretKey = keyGen.generateKey();
            byte [] encoded = secretKey.getEncoded();
            System.out.printf("256%n");
            for (byte b : encoded) {
                System.out.printf("%d, ", b);
            }
            System.out.printf("%n");
        }
        {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();
            byte [] encoded = secretKey.getEncoded();
            System.out.printf("128%n");
            for (byte b : encoded) {
                System.out.printf("%d, ", b);
            }
            System.out.printf("%n");
        }
    }
}
