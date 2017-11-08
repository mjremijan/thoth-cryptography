package org.thoth.crypto.main;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.crypto.SecretKey;
import org.thoth.crypto.io.ByteArrayWriter;
import org.thoth.crypto.symmetric.Aes256SecretKeyProducer;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class GenerateAes256SecretKeyAndSaveToFileMain {
    public static void main(String[] args) throws Exception {

        System.out.printf("Welcome to 'Generate AES-256 `SecretKey` and Save it to a File'%n%n");

        Path outputFile
            = Paths.get("aes256.key").toAbsolutePath();

        if (Files.exists(outputFile)) {
            throw new FileAlreadyExistsException(outputFile.toString());
        }

        System.out.printf("Create generator...%n");
        Aes256SecretKeyProducer generator
            = new Aes256SecretKeyProducer();

        System.out.printf("Generate key...%n");
        SecretKey key
            = generator.generate();

        System.out.printf("Create writer...%n");
        ByteArrayWriter writer
            = new ByteArrayWriter(outputFile);

        System.out.printf("Write key bytes to \"%s\"%n", outputFile.toString());
        writer.write(key.getEncoded());

        System.out.printf("%nGood bye!%n");
    }
}
