package com.company.lesson6.phonebook;

public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.addRecord(null);
        phonebook.addRecord(new Record("Alice", "090"));
        phonebook.addRecord(new Record("Alice", "099"));
        phonebook.addRecord(new Record("Lucia", "080"));

        System.out.println(phonebook.find("Alice"));
        System.out.println(phonebook.findAll("Alice"));
    }
}
