package org.example;

import java.util.ArrayList;
import java.util.Collections;

public final class Task2 {
    private final ArrayList<Double> nums;

    public Task2(int n) {
        nums = new ArrayList<>(n);
        RandomUtil.fill(nums, n);
    }

    public void sort() {
        quickSort(nums, 0, nums.size() - 1);
    }

    private void quickSort(ArrayList<Double> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private int partition(ArrayList<Double> list, int low, int high) {
        double pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivot) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);
        return i + 1;
    }

    public void print() {
        for (double num : nums)
            System.out.print(num + " ");
        System.out.println();
    }
}