package zad2;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class FullReport {
    private static final double EXCHANGE_RATE = 89.0;

    public static void generateReport(Employee[] employees, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("task2", locale);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);


        System.out.printf("%-15s %s%n", bundle.getString("fullname"), bundle.getString("salary"));

        for (Employee employee : employees) {
            double salary = employee.getSalary();
            if (locale.equals(Locale.ENGLISH)) {
                salary = salary / EXCHANGE_RATE;
            }
            String formattedSalary = numberFormat.format(salary);
            System.out.printf("%-15s %15s%n", employee.getFullname(), formattedSalary);
        }
    }
}