package org.thoth.crypto.asymmetric;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.StringJoiner;
import javax.crypto.Cipher;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class RsaMain {

    private KeyPairGenerator keyGen;
    public static int keySize
        // = 3072
        = 4096;

    public static String ALGORITHM_NAME = "RSA";
    public static String MODE_OF_OPERATION = "ECB";
    public static String PADDING_SCHEME = "OAEPWithSHA-512AndMGF1Padding";

    public RsaMain() throws Exception {
        // Create and initialize the KeyPairGenerator
        System.out.printf("Create and initialize the KeyPairGenerator%n");
        this.keyGen = KeyPairGenerator.getInstance("RSA");
        this.keyGen.initialize(keySize);

        // Generate the KeyPair and get the public/private keys
        System.out.printf("Generate the KeyPair and get the public/private keys%n");
        KeyPair pair = this.keyGen.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        // Print the keys
        this.print("Private Key", privateKey);
        this.print("Public Key", publicKey);

        // Save the keys
        this.save("private.key", privateKey.getEncoded());
        this.save("public.key", publicKey.getEncoded());

        // Read the keys from file
        PrivateKey privateKey2 = KeyFactory.getInstance("RSA")
            .generatePrivate(new PKCS8EncodedKeySpec(read("private.key")));
        PublicKey publicKey2 = KeyFactory.getInstance("RSA")
            .generatePublic(new X509EncodedKeySpec(read("public.key")));

        // Print the keys
        this.print("Private Key 2", privateKey2);
        this.print("Public Key 2", publicKey2);

        // Encrypt
        byte[] encryptedBytes = null;
        {
            System.out.printf("Encrypting...%n");
            Cipher c = Cipher.getInstance(String.format("%s/%s/%s",ALGORITHM_NAME,MODE_OF_OPERATION,PADDING_SCHEME));
            c.init(Cipher.ENCRYPT_MODE, publicKey);
            encryptedBytes = c.doFinal("encrypt me".getBytes("UTF-8"));
        }

        // Decrypt
        byte[] decryptedBytes = null;
        {
            System.out.printf("Decrypting...%n");
            Cipher c = Cipher.getInstance(String.format("%s/%s/%s",ALGORITHM_NAME,MODE_OF_OPERATION,PADDING_SCHEME));
            c.init(Cipher.DECRYPT_MODE, privateKey2);
            decryptedBytes = c.doFinal(encryptedBytes);
        }

        // Success?
        String message
            = new String(decryptedBytes, "UTF-8");
        System.out.printf("Decrypted message: \"%s\"%n", message);

        // Done
        System.out.printf("Done!%n");
    }

    protected byte[] read(String filename) throws Exception {
        return Files.readAllBytes(new File(filename).toPath());
    }

    protected void save(String filename, byte[] bytes) throws Exception {
        try (
            FileOutputStream fos = new FileOutputStream(filename);) {
            fos.write(bytes);
            fos.flush();
        }
    }

    protected void print(String description, Key key) {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (byte b : key.getEncoded()) {
            sj.add(String.format("%d", b));
        }
        System.out.printf("%s %s%n", description, sj.toString());
    }

    public static void main(String[] args) throws Exception {
        new RsaMain();
    }
}
