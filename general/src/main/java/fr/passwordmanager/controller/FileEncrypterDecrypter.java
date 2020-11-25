package fr.passwordmanager.controller;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * <p>Classe qui chiffre et dechiffre les données</p>
 *
 * @author Matteo DUFOUR
 * @author Matteo MUNOZ
 */
public class FileEncrypterDecrypter {
    /**
     * <p>Méthode qui chiffre les données</p>
     *
     * @param secretKey La clé secrète
     * @param fileInputPath Le fichier d'entrée
     * @param fileOutPath Le fichier de sortie
     */
    public static void encryptFile(String secretKey, String fileInputPath, String fileOutPath) {
        try {
            var key = new SecretKeySpec(secretKey.getBytes(), "AES");
            var cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            var fileInput = new File(fileInputPath);
            var inputStream = new FileInputStream(fileInput);
            var inputBytes = new byte[(int) fileInput.length()];
            inputStream.read(inputBytes);

            var outputBytes = cipher.doFinal(inputBytes);

            var fileEncryptOut = new File(fileOutPath);
            var outputStream = new FileOutputStream(fileEncryptOut);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();
        } catch (IOException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Méthode qui déchiffre les données</p>
     *
     * @param secretKey La clé secrète
     * @param fileInputPath Le fichier d'entrée
     * @param fileOutPath Le fichier de sortie
     */
    public static void decryptedFile(String secretKey, String fileInputPath, String fileOutPath){
        try {
            var key = new SecretKeySpec(secretKey.getBytes(), "AES");
            var cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);

            var fileInput = new File(fileInputPath);
            var inputStream = new FileInputStream(fileInput);
            var inputBytes = new byte[(int) fileInput.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            var fileEncryptOut = new File(fileOutPath);
            var outputStream = new FileOutputStream(fileEncryptOut);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();
    } catch (NoSuchAlgorithmException | BadPaddingException | InvalidKeyException | NoSuchPaddingException | IOException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }
}
