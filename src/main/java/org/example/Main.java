package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        runTask1();
//        runTask2();
//        runTask3();
        runTask4();
    }

    private static void runTask1() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("[Task1]: Введите размер массива: ");
            if (!scanner.hasNextInt()) {
                System.out.println("[Task1]: Ошибка: ожидалось целое число.");
                return;
            }

            int n = scanner.nextInt();
            var task = new Task1(n);
            var result = task.findAbsMin();
            System.out.println("[Task1]: Минимальное по модулю число: " + result);
        }
    }

    private static void runTask2() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("[Task2]: Введите размер списка: ");
            if (!scanner.hasNextInt()) {
                System.out.println("[Task2]: Ошибка: ожидалось целое число.");
                return;
            }

            int n = scanner.nextInt();
            var task = new Task2(n);

            System.out.println("[Task2]: До сортировки:");
            task.print();

            task.sort();

            System.out.println("[Task2]: После сортировки:");
            task.print();
        }
    }

    private static void runTask3() {
        var task = new Task3();
        System.out.format("[Task3]: Средняя ЗП по отделу: %.2f", task.getAverageSalaryByDepartment("Бухгалтерия"));
    }

    private static void runTask4() {
        System.out.println("[Task4]: Выполняется запрос к https://httpbin.org/user-agent ...");
        var task = new Task4();
        task.run();
    }
}