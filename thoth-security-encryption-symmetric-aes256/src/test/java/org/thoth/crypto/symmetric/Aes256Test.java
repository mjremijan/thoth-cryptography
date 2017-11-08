package org.thoth.crypto.symmetric;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import javax.crypto.SecretKey;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.thoth.crypto.io.ByteArrayReader;
import org.thoth.crypto.io.ByteArrayWriter;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Aes256Test {

    static Path secretKeyFile;

    @BeforeClass
    public static void generateSecretKeyFile() throws Exception {

        Path targetDir = Paths.get("./target");
        if (!Files.exists(targetDir)) {
            Files.createDirectory(targetDir);
        }

        secretKeyFile
            = Paths.get("./target/aes256.key").toAbsolutePath();

        Aes256SecretKeyProducer generator
            = new Aes256SecretKeyProducer();

        SecretKey key
            = generator.generate();

        ByteArrayWriter writer
            = new ByteArrayWriter(secretKeyFile);

        writer.write(key.getEncoded());
    }


    @Test
    public void encrypt_using_secretkey_file() {
        // setup
        SecretKey secretKey
            = new Aes256SecretKeyProducer().generate(
                new ByteArrayReader(secretKeyFile).read()
            );

        Aes256 aes
            = new Aes256(secretKey);

        // run
        String encrypted
            = aes.encryptToBase64("encrypt me", Optional.empty());

        // assert
        Assert.assertEquals("XUtOXoPoc12BPlNz4ynMtexleI9TMscI2U8=", encrypted);
    }
}
