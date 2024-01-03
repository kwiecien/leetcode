public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = left;
        int initialResult = 100001;
        int result = initialResult;
        int sum = 0;
        while (left < nums.length || right < nums.length) {
            if (sum < target && right < nums.length) {
                sum += nums[right++];
            } else {
                sum -= nums[left++];
            }
            if (sum >= target) {
                result = Math.min(result, right - left);
            }
        }
        return result == initialResult ? 0 : result;
    }
}
