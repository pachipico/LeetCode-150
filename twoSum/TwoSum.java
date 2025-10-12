package twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class TwoSum {

    // 73ms 걸린 첫번쨰 풀이
    public int[] twoSum(int[] nums, int target) {

        int a;

        int b;


        for (int i = 0; i < nums.length; i++) {
            a = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                b = nums[j];

                if(a+b == target) return new int[]{i, j};
            }
        }
        return new int[]{0, 0};
    }

    // 44ms 걸린 두번째 풀이.
    public int[] twoSum2(int[] nums, int target) {
        int startIdx = 0;

        while(startIdx != nums.length - 1) {

            for (int i = startIdx + 1; i < nums.length; i++) {
                if(nums[startIdx] + nums[i] == target) {
                    return new int[]{startIdx, i};
                }
            }

            startIdx++;
        }
        return new int[]{0,0};
    }

    // 2ms 걸리는 모범답안. 2개의 정수가 정해지면 바로 종료하는 방법으로 불필요한 연산을 줄였다.
    public int[] twoSumBestPractice(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

}
