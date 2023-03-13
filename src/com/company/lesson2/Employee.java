package com.company.lesson2;

public class Employee {
    private String lastName;
    private String position;
    private String email;
    private String phoneNumber;
    private int age;

    public Employee(String lastName, String position, String email, String phoneNumber, int age) {
        this.lastName = lastName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }
}
