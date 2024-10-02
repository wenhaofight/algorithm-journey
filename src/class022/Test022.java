package class022;

public class Test022 {
}

class Solution {
    final static int MAX = 50001;
    final static int[] help = new int[MAX];

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return process(nums, 0, nums.length - 1);
    }

    private int process(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        return process(nums, left, mid) + process(nums, mid + 1, right) + merge(nums, left, mid, right);
    }

    private int merge(int[] nums, int left, int mid, int right) {
        int ans = 0;
        int p1 = left;
        int p2 = mid + 1;
        int index = left;
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && (long) nums[i] > (long) nums[j] * 2) {
                j++;
            }
            ans += j - mid - 1;
        }
        while (p1 <= mid && p2 <= right) {
            help[index++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid) {
            help[index++] = nums[p1++];
        }
        while (p2 <= right) {
            help[index++] = nums[p2++];
        }
        for (int i = left; i <= right; i++) {
            nums[i] = help[i];
        }
        return ans;
    }
}

