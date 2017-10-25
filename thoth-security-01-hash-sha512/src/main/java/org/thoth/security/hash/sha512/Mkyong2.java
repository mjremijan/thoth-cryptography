package org.thoth.security.hash.sha512;

import java.security.MessageDigest;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Mkyong2 {

    public String hash(String toHash, String salt) throws Exception {
        // https://www.mkyong.com/java/java-sha-hashing-example/

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt.getBytes("UTF-8"));
        md.update(toHash.getBytes("UTF-8"));

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuilder hexString = new StringBuilder();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}

        return hexString.toString();
    }
}
