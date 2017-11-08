package org.thoth.security.hash;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Sha512 {

    public String hashToHex(String hashMe, String salt)
    throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bytes
            = digest(hashMe, salt);

        StringBuilder sp
            = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            sp.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sp.toString().toUpperCase();
    }

    public String hashToBase64(String hashMe, String salt)
    throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(
            digest(hashMe, salt)
        ).toUpperCase();
    }

    protected byte[] digest(String hashMe, String salt)
    throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md
            = MessageDigest.getInstance("SHA-512");

        md.update(hashMe.getBytes("UTF-8"));
        md.update(salt.getBytes("UTF-8"));
        

        return md.digest();
    }
}
