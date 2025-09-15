package majorityElement;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).findFirst().get().getKey();
    }

    public int bestPractice(int[] nums) {
        return me(nums, nums[0], 0);
    }

    int me(int[] arr, int val,int index){
        int count =0;
        for(int i =index;i<arr.length;i++){
            if(arr[i] == val)
                count++;
            else count--;
            if(count<0) return me(arr, arr[i], i);
        }
        return val;
    }
}
