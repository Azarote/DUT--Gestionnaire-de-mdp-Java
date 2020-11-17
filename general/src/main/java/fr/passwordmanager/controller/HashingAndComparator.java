package fr.passwordmanager.controller;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class HashingAndComparator {

    public static void mainPasswordHashing(char[] mainPassword)  {
        final String hashed = Hashing.sha256()
                .hashString(String.valueOf(String.valueOf(mainPassword)), StandardCharsets.UTF_8)
                .toString();

    }

}
