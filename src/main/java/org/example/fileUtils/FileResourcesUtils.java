package org.example.fileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Class to load files from the resource directory.
 */
public class FileResourcesUtils {

    /**
     * This method is used to load the field for each player from the resource directory.
     * The name of the player is used to identify the field: When the name is Bob, Bob's
     * field-file should be saved as Bob.txt
     *
     * @param fileName The name of the player
     * @return An Array that represents a battleship playing field
     */
    public static  char[] getArrayFromFile(String fileName) {

        StringBuilder builder = new StringBuilder();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName + ".txt");

        try{
            assert is != null;
            InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            for (String line; (line = reader.readLine()) != null;) {
                builder.append(line);
            }
        }catch (Exception ex){
            throw new IllegalArgumentException("Error while loading file " + fileName + ".txt");
        }


        String input = builder.toString();

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
