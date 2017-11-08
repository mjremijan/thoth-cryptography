package org.thoth.crypto.symmetric;

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
public class Aes256StaticTest {

    static Path secretKeyFile;

    @BeforeClass
    public static void beforeClass() throws Exception {
        secretKeyFile
            = Paths.get("./src/test/resources/Aes256StaticTest.key").toAbsolutePath();
    }


    @Test
    public void encrypt_to_string_then_decrypt_using_same_Aes256_instance() {
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
            = aes.encryptToBase64(toEncrypt, Optional.empty());

        String decrypted
            = aes.decryptFromBase64(encryptedBytesAsBase64EncodedString, Optional.empty());

        // assert
        Assert.assertEquals(toEncrypt, decrypted);
    }
}
