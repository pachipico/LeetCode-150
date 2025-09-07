package mergedSortedArray;


import java.util.Arrays;

public class MergedSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums1.length; i++) {
            if(i >= m) nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
    }

}
