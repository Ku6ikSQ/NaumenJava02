package org.example;

import java.util.ArrayList;
import java.util.Random;

public final class RandomUtil {
    private static final Random random = new Random();

    public static void fill(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            nums[i] = random.nextInt(-1000, 1000);
    }

    public static void fill(ArrayList<Double> nums) {
        for (int i = 0; i < nums.size(); i++)
            nums.set(i, random.nextDouble(-1000, 1000));
    }
}
