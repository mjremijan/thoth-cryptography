package org.thoth.crypto.symmetric;

import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import javax.crypto.SecretKey;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.thoth.crypto.io.ByteArrayReader;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Aes256Test2 {

    static Path secretKeyFile;

    @BeforeClass
    public static void beforeClass() throws Exception {
        secretKeyFile
            = Paths.get("./src/test/resources/Aes256StaticTest.key").toAbsolutePath();
    }


    @Test
    public void encrypt_and_decrypt_using_same_Aes256_instance() {
        // setup
        SecretKey secretKey
            = new Aes256SecretKeyProducer().generate(
                new ByteArrayReader(secretKeyFile).read()
            );

        Aes256 aes
            = new Aes256(secretKey);

        String toEncrypt
            = "encrypt me";

        // run
        String encryptedBytesAsBase64EncodedString
            = aes.encryptToBase64_2(toEncrypt, Optional.empty());

        String decrypted
            = aes.decryptFromBase64_2(encryptedBytesAsBase64EncodedString, Optional.empty());

        // assert
        Assert.assertEquals(toEncrypt, decrypted);
    }


    public void encrypt_and_decrypt_with_aad_using_same_Aes256_instance() {
        // setup
        SecretKey secretKey
            = new Aes256SecretKeyProducer().generate(
                new ByteArrayReader(secretKeyFile).read()
            );

        Aes256 aes
            = new Aes256(secretKey);

        String toEncrypt
            = "encrypt me aad";

        // run
        String encryptedBytesAsBase64EncodedString
            = aes.encryptToBase64_2(toEncrypt, Optional.of("JUnit AAD"));

        String decrypted
            = aes.decryptFromBase64_2(encryptedBytesAsBase64EncodedString, Optional.of("JUnit AAD"));

        // assert
        Assert.assertEquals(toEncrypt, decrypted);
    }


    @Test
    public void encrypt_and_decrypt_with_aad_using_different_Aes256_instance()
    throws Exception {
        // setup
        SecretKey secretKey
            = new Aes256SecretKeyProducer().generate(
                new ByteArrayReader(secretKeyFile).read()
            );

        Aes256 aesForEncrypt
            = new Aes256(secretKey);

        Aes256 aesForDecrypt
            = new Aes256(secretKey);

        String toEncrypt
            = "encrypt me aad";

        // run
        String encryptedBytesAsBase64EncodedString
            = aesForEncrypt.encryptToBase64(toEncrypt, Optional.empty());

        ByteArrayOutputStream baos
            = new ByteArrayOutputStream();
        baos.write(encryptedBytesAsBase64EncodedString.getBytes("UTF-8"));

        String decrypted
            = aesForDecrypt.decryptFromBase64(new String(baos.toByteArray(), "UTF-8"), Optional.empty());

        // assert
        Assert.assertEquals(toEncrypt, decrypted);
    }
}
