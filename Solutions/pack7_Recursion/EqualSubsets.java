package Solutions.pack7_Recursion;

import java.util.HashMap;
import java.util.Map;

public class EqualSubsets {
    public static boolean canPartition_Recur(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) {
            return false;
        }

        return dp2(nums, nums.length - 1, totalSum / 2);
    }
    private static boolean dp2(int[] nums, int index, int targetSum) {
        if (targetSum == 0) {
            return true;
        }
        if (index < 0 || targetSum < 0) {
            return false;
        }

        return dp2(nums, index - 1, targetSum - nums[index]) ||
               dp2(nums, index - 1, targetSum);
    }
    public static boolean canPartition_saveiz(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        Map<String, Boolean> save = new HashMap<>();
        return dp2(nums, nums.length - 1, totalSum / 2, save);
    }

    private static boolean dp2(int[] nums, int index, int targetSum, Map<String, Boolean> save) {
        if (targetSum == 0) {
            return true;
        }
        if (index < 0 || targetSum < 0) {
            return false;
        }

        String key = index + "-" + targetSum;
        if (save.containsKey(key)) {
            return save.get(key);
        }

        boolean result = dp2(nums, index - 1, targetSum - nums[index], save) ||
                         dp2(nums, index - 1, targetSum, save);
        save.put(key, result);
        return result;
    }

    public static boolean canPartition_DP(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int targetSum = totalSum / 2;
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = targetSum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[targetSum];
    }

}

