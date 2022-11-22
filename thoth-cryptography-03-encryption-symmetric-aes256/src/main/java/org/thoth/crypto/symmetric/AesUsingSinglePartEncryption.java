package org.thoth.crypto.symmetric;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class AesUsingSinglePartEncryption extends Aes {


    public AesUsingSinglePartEncryption(SecretKey secretKey) {
        super(secretKey);
    }
    

    /**
     * This method demonstrates how to perform a  single-part encryption
     * operation by using the {@link Cipher#doFinal(byte[]) } method to 
     * get all of the encrypted bytes.
     * 
     * @param message The message to encrypt.
     * @param c The {@link Cipher} used to get the encrypted bytes.
     * @return
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws IOException 
     */
    @Override
    ByteArrayOutputStream getEncryptedBytes(String message, Cipher c) throws BadPaddingException, IllegalBlockSizeException, IOException {
        // Create output array to hold all the encrypted bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
         
        // Perform single-part encryption.
        baos.write(
            c.doFinal(message.getBytes("UTF-8"))
        );
        
        return baos;
    }
}
