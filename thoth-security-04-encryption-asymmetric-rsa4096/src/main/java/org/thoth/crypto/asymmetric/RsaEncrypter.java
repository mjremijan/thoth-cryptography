package org.thoth.crypto.asymmetric;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class RsaEncrypter {

    protected RsaCipher cipher;

    public RsaEncrypter(RsaCipher cipher) {
        this.cipher = cipher;
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
