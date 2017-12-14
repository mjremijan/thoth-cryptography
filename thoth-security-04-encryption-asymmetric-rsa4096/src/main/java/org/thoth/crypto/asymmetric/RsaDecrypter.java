package org.thoth.crypto.asymmetric;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class RsaDecrypter {

    protected RsaCipher cipher;

    public RsaDecrypter(RsaCipher cipher) {
        this.cipher = cipher;
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
