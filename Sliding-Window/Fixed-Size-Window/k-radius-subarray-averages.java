//https://leetcode.com/problems/k-radius-subarray-averages/

class Solution {
    public int[] getAverages(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        int windowSize = 2 * k + 1;

        if (windowSize > n) {
            return ans;
        }

        if (k == 0) {
            return nums;
        }

        long sum = 0;

        // First window
        for (int i = 0; i < windowSize; i++) {
            sum += nums[i];
        }

        ans[k] = (int)(sum / windowSize);

        for (int center = k + 1; center + k < n; center++) {

            sum -= nums[center - k - 1];
            sum += nums[center + k];

            ans[center] = (int)(sum / windowSize);
        }

        return ans;
    }
}
