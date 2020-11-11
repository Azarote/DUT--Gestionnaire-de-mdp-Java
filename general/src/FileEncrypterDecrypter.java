import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class FileEncrypterDecrypter {
   public static void encryptDecrypt(String key, int cipherMode, File in, File out){
       try{
           FileInputStream fis = new FileInputStream(in);
           FileOutputStream fos = new FileOutputStream(out);

           DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());

           SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
           SecretKey secretKey = skf.generateSecret(desKeySpec);

           Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

           if (cipherMode == Cipher.ENCRYPT_MODE){
               cipher.init(Cipher.ENCRYPT_MODE,secretKey, SecureRandom.getInstance("SHA1PRNG"));
               CipherInputStream cis = new CipherInputStream(fis,cipher);
               write(cis,fos);
           }
           else if(cipherMode == Cipher.DECRYPT_MODE){
               cipher.init(Cipher.DECRYPT_MODE,secretKey, SecureRandom.getInstance("SHA1PRNG"));
               CipherOutputStream cos = new CipherOutputStream(fos,cipher);
               write(fis,cos);
           }

       } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | InvalidKeySpecException | IOException e) {
           e.printStackTrace();
       }

   }
   private  static void write(InputStream in, OutputStream out) throws IOException {
           byte[] buffer = new byte[64];
           int numOfBytesRead;
           while ((numOfBytesRead = in.read(buffer)) != -1) {
               out.write(buffer, 0, numOfBytesRead);
           }
           out.close();
           in.close();
   }

    public static void main(String[] args) {
        File test = new File("general/src/data.dat");
        File encrypt = new File("general/src/dataencrypt.dat");
        encryptDecrypt("12345678",Cipher.ENCRYPT_MODE,test,encrypt);
    }
}
