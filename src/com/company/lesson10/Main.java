package com.company.lesson10;

public class Main {
    public static void main(String[] args) {
        FileData text = new FileData("text.txt", 2, "path/to/txt");
        FileData book = new FileData("book.txt", 150, "path/to/txt");
        FileData movie = new FileData("movie.flv", 1000, "path/to/flv");
        FileData cartoon = new FileData("cartoon.flv", 500, "path/to/flv");
        FileData music = new FileData("music.mp3", 150, "path/to/mp3");
        FileData app = new FileData("app.java", 200, "path/to/java");

        FileNavigator navigator = new FileNavigator();
        navigator.add("path/to/txt", text);
        navigator.add("path/to/txt", book);
        navigator.add("path/to/flv", movie);
        navigator.add("path/to/flv", cartoon);
        navigator.add("path/to/mp3", music);
        navigator.add("path/to/java", app);
        System.out.println(navigator.sortBySize());
        System.out.println(navigator.find("path/to/flv"));
        System.out.println(navigator.filterBySize(1000));
        System.out.println(navigator.remove("path/to/txt"));
        System.out.println(navigator.sortBySize());
    }
}
