package com.jasonkp.converterkp.service;

import java.util.HashMap;
import java.util.Map;

public class WordToNumber {

    private static final Map<String, Integer> wordToValue = new HashMap<>();

    static {
        wordToValue.put("zero", 0);
        wordToValue.put("one", 1);
        wordToValue.put("two", 2);
        wordToValue.put("three", 3);
        wordToValue.put("four", 4);
        wordToValue.put("five", 5);
        wordToValue.put("six", 6);
        wordToValue.put("seven", 7);
        wordToValue.put("eight", 8);
        wordToValue.put("nine", 9);
        wordToValue.put("ten", 10);
        wordToValue.put("eleven", 11);
        wordToValue.put("twelve", 12);
        wordToValue.put("thirteen", 13);
        wordToValue.put("fourteen", 14);
        wordToValue.put("fifteen", 15);
        wordToValue.put("sixteen", 16);
        wordToValue.put("seventeen", 17);
        wordToValue.put("eighteen", 18);
        wordToValue.put("nineteen", 19);
        wordToValue.put("twenty", 20);
        wordToValue.put("thirty", 30);
        wordToValue.put("forty", 40);
        wordToValue.put("fifty", 50);
        wordToValue.put("sixty", 60);
        wordToValue.put("seventy", 70);
        wordToValue.put("eighty", 80);
        wordToValue.put("ninety", 90);
        wordToValue.put("hundred", 100);
        wordToValue.put("thousand", 1000);
        wordToValue.put("million", 1000000);
    }

    public static int convertWordToNumber(String wordPhrase) {
        int total = 0;
        int currentNumber = 0;
        String[] words = wordPhrase.toLowerCase().split("\\s+|-"); // Split by space or hyphen

        for (String word : words) {
            if (wordToValue.containsKey(word)) {
                int value = wordToValue.get(word);
                if (value >= 100) { // Handle multipliers like hundred, thousand
                    currentNumber *= value;
                    if (value >= 1000) { // Add to total if it's a large multiplier
                        total += currentNumber;
                        currentNumber = 0;
                    }
                } else {
                    currentNumber += value;
                }
            }
        }
        total += currentNumber; // Add any remaining current number
        return total;
    }
}