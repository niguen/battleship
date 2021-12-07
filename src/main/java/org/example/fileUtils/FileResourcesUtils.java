package org.example.fileUtils;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class FileResourcesUtils {

    public static  char[] getArrayFromFile(String fileName) {

        StringBuilder builder = new StringBuilder();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName + ".txt");

        try{
            InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            for (String line; (line = reader.readLine()) != null;) {
                builder.append(line);
            }
        }catch (Exception ex){
            System.err.println("Error, while reading file");
        }


        String input = builder.toString();
        System.out.println(input);

        input = input.replaceAll("\n", "");
        input = input.replaceAll(" ", "");

        // Creating array of string length
        char[] ch = new char[input.length()];

        // Copy character by character into array
        for (int i = 0; i < input.length(); i++) {
            ch[i] = input.charAt(i);
        }
        return ch;

    }

}
