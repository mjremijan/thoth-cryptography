package org.thoth.crypto.asymmetric;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.thoth.crypto.io.ByteArrayReader;
import org.thoth.crypto.io.ByteArrayWriter;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class RsaTest {

    static Path privateKeyFile;
    static Path publicKeyFile;

    @BeforeClass
    public static void beforeClass() throws Exception {

        // Create the target directory if it doesn't exist
        Path target = Paths.get("./target");
        if (!Files.exists(target)) {
            Files.createDirectory(target);
        }

        // Store the PrivateKey and PublicKey bytes in the ./target
        // diretory. Do this so it will be ignore by source control.
        // We don't want this file committed.
        privateKeyFile
            = Paths.get("./target/RsaPrivate.key").toAbsolutePath();
        publicKeyFile
            = Paths.get("./target/RsaPublic.key").toAbsolutePath();

        try {
            // Create KeyPair for RSA
            KeyPair keyPair
                = new RsaKeyPairProducer().produce();

            // Store the PrivateKey bytes. This is what
            // you want to keep absolutely safe
            {
                ByteArrayWriter writer = new ByteArrayWriter(privateKeyFile);
                writer.write(keyPair.getPrivate().getEncoded());
            }

            // Store the PublicKey bytes.  This you
            // can freely distribute so others can
            // encrypt messages which you can then
            // decrypt with the PrivateKey you keep safe.
            {
                ByteArrayWriter writer = new ByteArrayWriter(publicKeyFile);
                writer.write(keyPair.getPublic().getEncoded());
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    @Test
    public void encrypt_and_decrypt() throws Exception {
        // setup
        PrivateKey privateKey
            = new RsaPrivateKeyProducer().produce(
                new ByteArrayReader(privateKeyFile).read()
            );

        PublicKey publicKey
            = new RsaPublicKeyProducer().produce(
                new ByteArrayReader(publicKeyFile).read()
            );

        RsaDecrypter decrypter
            = new RsaDecrypter(privateKey);

        RsaEncrypter encrypter
            = new RsaEncrypter(publicKey);

        String toEncrypt
            = "encrypt me";

        // run
        byte[] encryptedBytes
            = encrypter.encrypt(toEncrypt);
        System.out.printf("Encrypted %s%n", new String(encryptedBytes,"UTF-8"));

        String decrypted
            = decrypter.decrypt(encryptedBytes);

        // assert
        Assert.assertEquals(toEncrypt, decrypted);
    }

}
