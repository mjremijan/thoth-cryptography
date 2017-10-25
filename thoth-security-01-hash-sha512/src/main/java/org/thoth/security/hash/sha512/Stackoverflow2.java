package org.thoth.security.hash.sha512;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Stackoverflow2 {

    // https://stackoverflow.com/questions/33085493/hash-a-password-with-sha-512-in-java
    public String get_SHA_512_SecurePassword_asHex(String passwordToHash, String salt) throws Exception {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(passwordToHash.getBytes("UTF-8"));
            md.update(salt.getBytes("UTF-8"));
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public String get_SHA_512_SecurePassword_asBase64(String passwordToHash, String salt) throws Exception {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(passwordToHash.getBytes("UTF-8"));
            md.update(salt.getBytes("UTF-8"));
            byte[] bytes = md.digest();
            generatedPassword = Base64.getEncoder().encodeToString(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
