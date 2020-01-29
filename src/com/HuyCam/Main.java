package com.HuyCam;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String a = groupify("HITHERE", 3);
        System.out.println( encryptString("Hello There", 2, 4));
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

    public static String caesarify(String text, int key) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXRZ";
        String newAlphabet = shiftAlphabet(key);
        String newText = "";

        // for every character in the text, find the corresponding character of that char in the newAlphabet.
        for (int i = 0; i < text.length(); i++) {
            newText += newAlphabet.charAt(alphabet.indexOf(text.charAt(i)));
        }

        return newText;
    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String groupify(String text, int groupSize) {
        String groupStr = "";

        for (int i = 0; i < text.length(); i += groupSize) {
            if (i + groupSize >= text.length()) {
                groupStr += text.substring(i);

                //trainling x of the last group
                String xs = "";
                for (int j = 0; j < i + groupSize - text.length(); j++) {
                    xs += "x";
                }

                groupStr += xs;
            }
            else {
                groupStr += text.substring(i, i + groupSize) + " ";
            }
        }

        return groupStr;
    }

    public static String encryptString(String text, int shiftVal, int groupSize) {
        text = normalizeText(text);
        text = caesarify(text, shiftVal);
        text = groupify(text, groupSize);

        return text;
    }
}
