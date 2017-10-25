package org.thoth.security.hash.sha512;

import java.security.MessageDigest;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Mkyong1 {

    public String hash(String toHash, String salt) throws Exception {
        // https://www.mkyong.com/java/java-sha-hashing-example/

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt.getBytes("UTF-8"));
        md.update(toHash.getBytes("UTF-8"));

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}
