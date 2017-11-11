package org.thoth.crypto.symmetric;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * NOTE:  Never use this!!
 * 
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Aes {

    static SecretKey key;

    public Aes() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        key = keyGen.generateKey();
    }

    /**
     * Encrypt a string with AES algorithm.
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
     * Decrypt a string with AES algorithm.
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
