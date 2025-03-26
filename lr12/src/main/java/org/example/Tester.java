package org.example;

public class Tester {
    private String name;
    private String surname;
    private int experienceInYears;
    private String englishLevel;
    private double salary;

    // Конструктор 1
    public Tester(String name, String surname) {
        this(name, surname, 0); // Вызов конструктора 2
    }

    // Конструктор 2
    public Tester(String name, String surname, int experienceInYears) {
        this(name, surname, experienceInYears, "Beginner"); // Вызов конструктора 3
    }

    // Конструктор 3
    public Tester(String name, String surname, int experienceInYears, String englishLevel) {
        this.name = name;
        this.surname = surname;
        this.experienceInYears = experienceInYears;
        this.englishLevel = englishLevel;
        this.salary = calculateSalary(); // Пример вызова метода для расчета зарплаты
    }

    // Перегруженные методы
    public void displayInfo() {
        System.out.println("Name: " + name + ", Surname: " + surname);
    }

    public void displayInfo(int format) {
        if (format == 1) {
            System.out.println("Full Name: " + name + " " + surname);
        } else {
            System.out.println("Surname: " + surname + ", Name: " + name);
        }
    }

    public double calculateSalary() {
        return experienceInYears * 1000; // Пример расчета зарплаты
    }

    public double calculateSalary(double bonus) {
        return calculateSalary() + bonus; // Перегруженный метод с бонусом
    }

    // Статический метод
    public static void printTesterCount(int count) {
        System.out.println("Number of testers: " + count);
    }
}