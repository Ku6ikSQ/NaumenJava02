package org.example;

import java.util.Scanner;

public final class Task1 {
    private final int[] nums;

    public Task1(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Размер массива должен быть положительным");
        nums = new int[n];
        RandomUtil.fill(nums);
    }

    public int findAbsMin() {
        int min = nums[0];
        for (int num : nums)
            if (Math.abs(num) < Math.abs(min))
                min = num;
        return min;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите размер массива: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: ожидалось целое число.");
                return;
            }

            var n = scanner.nextInt();
            var task = new Task1(n);
            var result = task.findAbsMin();
            System.out.println("Минимальное по модулю число: " + result);
        }
    }
}