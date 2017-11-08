package org.thoth.crypto.symmetric;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Aes {

    static SecretKey key;

    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        key = keyGen.generateKey();

        String encryptMe = "I should be encrypted";
        System.out.printf("encryptMe = \"%s\"%n", encryptMe);

        String encrypted = encrypt(encryptMe);
        System.out.printf("encrypted = \"%s\"%n", encrypted);

        String decrypted = decrypt(encrypted);
        System.out.printf("decrypted = \"%s\"%n", decrypted);
    }

    /**
     * Encrypt a string with Aes algorithm.
     *
     * @param data is a string
     * @return the encrypted string
     */
    public static String encrypt(String data) throws Exception {
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encVal);
    }

    /**
     * Decrypt a string with Aes algorithm.
     *
     * @param encryptedData is a string
     * @return the decrypted string
     */
    public static String decrypt(String encryptedData) throws Exception {
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        return new String(decValue, "UTF-8");
    }
}
