package com.pepperonas.batchtexter;

import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    /**
     * If true the created text will only be shown in the console.
     * Set to false to generate the processable text file.
     */
    private static final boolean TEST_ONLY = true;

    public static void main(String[] args) {
        generateContent();
    }

    private static void generateContent() {
        System.out.println("Creating percentage asset");
        String content = createLine("img_m<rn>:<rc>MB/s", "<rn>", "<rc>", 1030);
        showInConsole(content);
        writeToFile("_resource_set.txt", content);
    }

    private static String createLine(String content, String replacementFileName, String replacementContent, int value) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= value; i++) {
            String line = content.replace(replacementFileName, String.valueOf(i)).replace(replacementContent, String.valueOf(i));
            result.append(line).append("\n");
        }
        result.append("\n");
        return result.toString();
    }

    private static String createLineDecimal(String content, String replacementFileName, String replacementContent, int value) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= value; i++) {
            String line = content.replace(replacementFileName, String.valueOf(i)).replace(replacementContent, String.valueOf((float) i / 10f));
            result.append(line).append("\n");
        }
        result.append("\n");
        return result.toString();
    }

    private static void writeToFile(String fileName, String text) {
        if (!TEST_ONLY) {
            try {
                PrintWriter writer = new PrintWriter(fileName, "UTF-8");
                writer.print(text);
                writer.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getCause());
            }
        }
    }

    private static void showInConsole(String content) {
        if (TEST_ONLY) {
            System.out.println(content);
        }
    }

}
