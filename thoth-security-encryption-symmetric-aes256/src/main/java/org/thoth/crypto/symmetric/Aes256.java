package org.thoth.crypto.symmetric;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Optional;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class Aes256 {

    // Use 128 if you don't have the Java Cryptography Extension (JCE) Unlimited Strength installed
    public static int AES_KEY_SIZE = 256;
    public static int IV_SIZE = 96;
    public static int TAG_BIT_LENGTH = 128;
    public static String ALGO_TRANSFORMATION_STRING = "AES/GCM/PKCS5Padding";

    protected SecretKey secretKey;
    protected SecureRandom secureRandom;

    public Aes256(SecretKey secretKey) {
        this.secretKey = secretKey;
        this.secureRandom = new SecureRandom();
    }


    public String encryptToBase64(String message, Optional<String> aad) {
        try {
            // Transformation specifies algortihm, mode of operation and padding
            Cipher c = Cipher.getInstance(ALGO_TRANSFORMATION_STRING);

            // Generate IV
            byte iv[] = new byte[IV_SIZE];
            secureRandom.nextBytes(iv); // SecureRandom initialized using self-seeding

            // Initialize GCM Parameters
            GCMParameterSpec spec = new GCMParameterSpec(TAG_BIT_LENGTH, iv);

            // Init for encryption
            c.init(Cipher.ENCRYPT_MODE, secretKey, spec, secureRandom);

            // Add AAD tag data if present
            aad.ifPresent(t -> {
                try {
                    c.updateAAD(t.getBytes("UTF-8"));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            // Add message to encrypt
            c.update(message.getBytes("UTF-8"));

            // Encrypt
            byte[] encryptedBytes
                = c.doFinal();


            // Concatinate IV and encrypted bytes.  The IV is needed later
            // in order to to decrypt.  The IV value does not need to be
            // kept secret, so it's OK to encode it in the return value
            //
            // Create a new byte[] the combined length of IV and encryptedBytes
            byte[] ivPlusEncryptedBytes = new byte[iv.length + encryptedBytes.length];
            // Copy IV bytes into the new array
            System.arraycopy(iv, 0, ivPlusEncryptedBytes, 0, iv.length);
            // Copy encryptedBytes into the new array
            System.arraycopy(encryptedBytes, 0, ivPlusEncryptedBytes, iv.length, encryptedBytes.length);

            // Encode
            byte[] encodedBytes
                = Base64.getEncoder().encode(ivPlusEncryptedBytes);

            // Return
            return new String(encodedBytes, "UTF-8");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public String decryptFromBase64(String base64EncodedEncryptedMessage, Optional<String> aad) {

        try {
            // Decode
            byte [] ivPlusEncryptedBytes
                = Base64.getDecoder().decode(base64EncodedEncryptedMessage);

            // Get IV
            byte iv[] = new byte[IV_SIZE];
            System.arraycopy(ivPlusEncryptedBytes, 0, iv, 0, IV_SIZE);

            // Initialize GCM Parameters
            GCMParameterSpec spec = new GCMParameterSpec(TAG_BIT_LENGTH, iv);

            // Transformation specifies algortihm, mode of operation and padding
            Cipher c = Cipher.getInstance(ALGO_TRANSFORMATION_STRING);

            // Get encrypted bytes
            byte [] encryptedBytes = new byte[ivPlusEncryptedBytes.length - IV_SIZE];
            System.arraycopy(ivPlusEncryptedBytes, IV_SIZE, encryptedBytes, 0, encryptedBytes.length);

            // Init for decryption
            c.init(Cipher.DECRYPT_MODE, secretKey, spec, secureRandom);

            // Add AAD tag data if present
            aad.ifPresent(t -> {
                try {
                    c.updateAAD(t.getBytes("UTF-8"));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            // Add message to decrypt
            c.update(encryptedBytes);

            // Decrypt
            byte[] decryptedBytes
                = c.doFinal();

            // Return
            return new String(decryptedBytes, "UTF-8");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
