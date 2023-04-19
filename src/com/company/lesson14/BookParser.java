package com.company.lesson14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BookParser {
    private static final int MIN_LENGTH = 2;
    private static final int NUMBER_POPULAR_WORDS = 10;
    private static final int OCCURRENCES_NUMBER = 1;
    private final Map<String, Integer> statistic = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    private String name;

    public BookParser() {
        System.out.println("Enter book name");
        name = scanner.nextLine();
    }

    public void createReportFile() {
        String parsedBook = getReport();
        File report = new File(name + "_statistic.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(report))) {
            writer.write(parsedBook);
            System.out.println(parsedBook);
        } catch (IOException e) {
            throw new WriteDataToFileException("Can't write data to file", e);
        }
    }

    private void getDataFromFile() {
        File book = new File("src\\" + name);
        try (BufferedReader reader = new BufferedReader(new FileReader(book))) {
            String line = reader.readLine();
            while (line != null) {
                for (String word : line.split("[^A-Za-zА]")) {
                    statistic.compute(word.toLowerCase(), (k, v) -> v == null ? 1 : v + 1);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Book \"" + name + "\" not found. Enter valid book name!");
            name = scanner.nextLine();
            getDataFromFile();
        }
    }

    private List<String> findMostPopularWords() {
        getDataFromFile();
        return statistic.entrySet().stream()
                .filter(entry -> entry.getKey().length() > MIN_LENGTH)
                .sorted(Collections.reverseOrder(Comparator.comparingInt(Map.Entry::getValue)))
                .limit(NUMBER_POPULAR_WORDS)
                .map(Map.Entry::getKey)
                .toList();
    }

    private long countUniqueWords() {
        return statistic.entrySet().stream()
                .filter(entry -> entry.getValue() == OCCURRENCES_NUMBER)
                .map(Map.Entry::getKey)
                .count();
    }

    private String getReport() {
        StringBuilder builder = new StringBuilder();
        for (String word : findMostPopularWords()) {
            builder.append(word)
                    .append(":")
                    .append(word.length())
                    .append(System.lineSeparator());
        }
        builder.append("Number unique words: ")
                .append(countUniqueWords());
        return builder.toString();
    }
}
