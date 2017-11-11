package org.thoth.crypto.symmetric;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class AesTest {


    @Test
    public void encrypt_and_decrypt_using_same_Aes_instance() throws Exception {
        // setup
        Aes aes
            = new Aes();

        String toEncrypt
            = "encrypt me";

        // run
        String encrypted
            = aes.encrypt(toEncrypt);

        String decrypted
            = aes.decrypt(encrypted);

        // assert
        Assert.assertEquals(toEncrypt, decrypted);
    }
}