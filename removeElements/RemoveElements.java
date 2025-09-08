package removeElements;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class RemoveElements {

    public int removeElement(int[] nums, int val) {

        // 첫번째 해답, 4ms 가 걸렸음
        // int[] res = Arrays.stream(nums).boxed().filter(v -> v != val).mapToInt(v -> {
        //     System.out.print(v);
        //     return v;
        // }).toArray();
        // int place = 0;

        // System.out.println("\n--------");
        // for (int i = 0; i < res.length; i++) {
        //     nums[i] = res[place++];
        //     System.out.print(nums[i]);
        // }
        // return res.length;


        // 큐를 이용해 1ms가 걸리는 것을 보고 큐를 한번 사용해봄, 1ms가 걸림
        //Queue<Integer> queue = new PriorityQueue<>();
        // for (int i = 0; i < nums.length; i++) {
        //     queue.offer(nums[i]);
        // }

        // int place = 0;
        // while (!queue.isEmpty()) {
        //     Integer poll = queue.poll();
        //     if(poll != val) {
        //         nums[place++] = poll;
        //     }
        // }

        // return place;


        // 0ms 가 가능한 것을 보고 최대한 간단한 방법으로 해결해봄
        int place = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!= val) {
                nums[place++] = nums[i];
            }
        }

        return place;
    }

}
