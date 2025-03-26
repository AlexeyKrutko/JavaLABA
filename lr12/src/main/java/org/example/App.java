package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello Lesha" +
                "");
        // Создание объектов Tester
        Tester tester1 = new Tester("Ivan", "Petrovich");
        Tester tester2 = new Tester("Petr", "Ivanovich", 5);

        // Вызов перегруженных методов
        tester1.displayInfo();
        tester2.displayInfo(1);

        // Вызов статического метода
        Tester.printTesterCount(2);

        // Пример расчета зарплаты
        System.out.println("Salary of tester 1: $" + tester1.calculateSalary());
        System.out.println("Salary of tester 2 with bonus: $" + tester2.calculateSalary(500));
    }
}
