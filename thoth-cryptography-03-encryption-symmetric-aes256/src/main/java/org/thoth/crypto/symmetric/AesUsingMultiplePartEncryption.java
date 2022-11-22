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
public class AesUsingMultiplePartEncryption extends Aes {


    public AesUsingMultiplePartEncryption(SecretKey secretKey) {
        super(secretKey);
    }
    

    /**
     * This method demonstrates how to perform a  multiple-part encryption
     * operation by using the {@link Cipher#update(byte[]) } and the 
     * {@link Cipher#doFinal() } methods to get all of the encrypted
     * bytes. This method <b>simulates</b> the operation by dividing the
     * {@link message} parameter into many strings and operating on those
     * strings individually. In reality you would probably never do this, but
     * it's an easy way to demonstrate to perform a  multiple-part encryption.
     * 
     * @param message The message to encrypt. This method will <b>simulate</b>
     * multiple-part encryption by <b>unnecessarily</b> dividing this string into many strings.
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
        
        // Chunk the message into many strings to simulate multiple-part encryption
        int chunkSize = 5;
        String[] chunks = message.split("(?<=\\G.{" + chunkSize + "})");
        
        // Add each chunk to a multiple-part encryption.
        // Don't forget to collect the encypted bytes
        // along the way!
        for (String chunk : chunks) {
            baos.write(
                c.update(chunk.getBytes("UTF-8"))
            );
        }
        
        // Finish multi-part encryption. Again,
        // Don't forget to collect the encypted bytes
        // along the way!
        baos.write(
            c.doFinal()
        );
        
        return baos;
    }
}
