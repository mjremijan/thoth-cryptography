package org.thoth.crypto.asymmetric;

import java.security.PrivateKey;
import javax.crypto.Cipher;
import org.thoth.crypto.asymmetric.RsaCipher;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class RsaDecrypter {

    protected RsaCipher cipher;

    public RsaDecrypter(PrivateKey key) {
        this.cipher = new RsaCipher(Cipher.DECRYPT_MODE, key);
    }

    public String decrypt(byte[] message) {
        try {
            return new String(
                cipher.update(message).doFinal()
                , "UTF-8"
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
