package fr.passwordmanager.controller;

import com.google.common.hash.Hashing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HashingAndComparator {

    public static void mainPasswordHashing(char[] mainPassword) {
        final String hashed = Hashing.sha256()
                .hashString(String.valueOf(String.valueOf(mainPassword)), StandardCharsets.UTF_8)
                .toString();
        File hashedFile = new File("general/src/hashed.dat");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(hashedFile));
            writer.write(hashed);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//TODO Déplacer passwordProcessing
}
