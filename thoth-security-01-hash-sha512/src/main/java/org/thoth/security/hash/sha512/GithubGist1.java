package org.thoth.security.hash.sha512;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class GithubGist1 {

    // https://gist.github.com/Vorksholk/2852771
    public String getSHA512(String toHash, String salt) throws Exception {

        MessageDigest md;
        String message = toHash;
        try {
            md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes("UTF-8"));
            md.update(message.getBytes("UTF-8"));
            byte[] mb = md.digest();
            String out = "";
            for (int i = 0; i < mb.length; i++) {
                byte temp = mb[i];
                String s = Integer.toHexString(new Byte(temp));
                while (s.length() < 2) {
                    s = "0" + s;
                }
                s = s.substring(s.length() - 2);
                out += s;
            }
            return (out);

        } catch (NoSuchAlgorithmException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return "error";
    }
}
