package org.thoth.crypto.asymmetric;

import java.security.PublicKey;
import javax.crypto.Cipher;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class RsaEncrypter {

    protected RsaCipher cipher;

    public RsaEncrypter(PublicKey key) {
        this.cipher = new RsaCipher(Cipher.ENCRYPT_MODE, key);
    }

    public byte[] encrypt(String message) {
        try {
            return cipher
                    .update(message.getBytes("UTF-8"))
                    .doFinal()
            ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
