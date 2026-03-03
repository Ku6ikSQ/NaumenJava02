package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        runTask1();
    }

    private static void runTask1() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("[Task1]: Введите размер массива: ");
            if (!scanner.hasNextInt()) {
                System.out.println("[Task1]: Ошибка: ожидалось целое число.");
                return;
            }

            var n = scanner.nextInt();
            var task = new Task1(n);
            var result = task.findAbsMin();
            System.out.println("[Task1]: Минимальное по модулю число: " + result);
        }
    }
}
