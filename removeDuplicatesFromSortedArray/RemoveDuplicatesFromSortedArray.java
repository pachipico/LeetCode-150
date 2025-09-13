package removeDuplicatesFromSortedArray;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        // 0ms 로 해결한 나의 답변
        int prev = nums[0];
        int place = 1;

        for (int i = 1; i < nums.length; i++) {
            if(prev != nums[i]) {
                prev =  nums[i];
                nums[place++] = nums[i];
            }
        }

        return place;
    }

    // 모범 답안. 변수 하나를 줄일 수 있었다..
    public int bestPractice(int[] nums) {
        int j=0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[j])
                nums[++j] = nums[i];
        }
        return j + 1;
    }

}
