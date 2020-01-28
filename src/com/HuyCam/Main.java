package com.HuyCam;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(normalizeText("This is some \\\"really\\\" great. (Text)!?"));
    }

    public static String normalizeText(String text) {
        // remove all spaces
        text = text.replace(" ", "");
        // remove any punctuation
        String[] puncts = {".",":",";", "\'", "\"", "!", "?", "(", ")", "\\"};

        for (int i = 0; i < puncts.length; i++) {
            text = text.replace(puncts[i], "");
        }

        text = text.toUpperCase();
        return text;
    }
}
