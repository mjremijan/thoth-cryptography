package org.thoth.security.hash;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

/**
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Sha {

    public String hashToHex(String hashMe, Optional<String> salt)
    throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bytes
            = hash(hashMe, salt);

        StringBuilder sp
            = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            sp.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sp.toString().toUpperCase();
    }

    public String hashToBase64(String hashMe, Optional<String> salt)
    throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(
            hash(hashMe, salt)
        ).toUpperCase();
    }

    public byte[] hash(String hashMe, Optional<String> salt)
    throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md
            = MessageDigest.getInstance("SHA-512");

        md.update(hashMe.getBytes("UTF-8"));
        salt.ifPresent(s -> {
            try { md.update(s.getBytes("UTF-8")); } catch (Exception e) {throw new RuntimeException(e);}
        });

        return md.digest();
    }
}
