import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AESEncryptionExample 
{
    public static void main(String[] args) throws Exception {
        // Generate AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // You can choose 128, 192, or 256 bits
        SecretKey secretKey = keyGen.generateKey();

        // Initialize AES cipher
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Your plaintext message
        String plaintext = "DATA IS ";

        // Encrypt the message
        byte[] encryptedBytes = aesCipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));

        // Encode the encrypted bytes as Base64 for safe storage/transmission
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

        System.out.println("Encrypted text: " + encryptedText);
    }
}
