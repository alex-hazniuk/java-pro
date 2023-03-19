package com.company.lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Kate", "Alice", "Alice",
                "Kate", "Bohdan", "Alice", "Alice", "Alice", "John");
        System.out.println(countOccurrence(names, "Kate"));
        calcOccurrence(names);
        System.out.println(findOccurrence(names));

        String[] animals = {"Cat", "Dog", "Cow", "Goat"};
        System.out.println(toList(animals));

        List<Integer> numbers = List.of(3, 3, 3, 3, 2, 0, 2);
        System.out.println(findUnique(numbers));
    }

    /**
     * Create method countOccurrence, witch accepts list as entrance parameter
     * and a line. List is filled with words approximately 10-20,
     * witch could be repeatable many times. Count line occurrence
     * witch is passed as second parameter.
     */
    private static int countOccurrence(List<String> words, String line) {
        int occurrence = 0;
        if (words != null) {
            for (String word : words) {
                if (word != null && word.equals(line)) {
                    occurrence++;
                }
            }
        }
        return occurrence;
    }

    /**
     * Given array of some type with optional length as parameter.
     * Create method toList, that converts array to List with proper type and return it.
     * For instance:
     * Input: Array [1, 2, 3]
     * Output: List [1, 2, 3]
     */
    private static <T> List<T> toList(T[] values) {
        return values != null ? Arrays.asList(values) : Collections.emptyList();
    }

    /**
     * Given List of Integers, witch could be repeatable.
     * Create method findUnique, that returns a List with only unique Integers.
     */
    private static List<Integer> findUnique(List<Integer> numbers) {
        return createUniqueValuesList(numbers);
    }

    /**
     * Given list of strings with 20-30 words.
     * Words could be repeatable many tomes.
     * Create method calcOccurrence, witch counts word's occurrence.
     * Display result in console.
     * For instance:
     * bird: 2
     * fox: 1
     * cat: 1
     */
    private static void calcOccurrence(List<String> words) {
        for (String value : createUniqueValuesList(words)) {
            int occurrence = 0;
            for (String word : words) {
                if (value != null && value.equals(word)) {
                    occurrence++;
                }
            }
            System.out.println(value + ": " + occurrence);
        }
    }

    /**
     * Given list of strings with 10-20 words.
     * Words could be repeatable many tomes.
     * Create method findOccurrence, witch counts word's occurrence
     * and returns a List of structures that describes repetition.
     * For instance:
     * [
     * {name: "bird", occurrence: 2},
     * {name: "fox", occurrence: 1},
     * {name: "cat", occurrence: 1}
     * ]
     */
    private static List<String> findOccurrence(List<String> words) {
        List<String> occurrences = new ArrayList<>();
        for (String value : createUniqueValuesList(words)) {
            int count = 0;
            for (String word : words) {
                if (value != null && value.equals(word)) {
                    count++;
                }
            }
            occurrences.add("{name: \"" + value + "\", occurrence: " + count + "}");
        }
        return occurrences;
    }

    private static <T> List<T> createUniqueValuesList(List<T> values) {
        List<T> uniqueNumbers = new ArrayList<>();
        if (values != null) {
            for (T value : values) {
                if (!uniqueNumbers.contains(value)) {
                    uniqueNumbers.add(value);
                }
            }
        }
        return uniqueNumbers;
    }
}
