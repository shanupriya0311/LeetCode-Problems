
class Solution {
    // Method to determine if the target is in rotated sorted array or not
    public boolean search(int[] nums, int target) {
        // Initialize the left and right bound
        int left = 0, right = nums.length - 1;

        // Iterate over the array
        while (left <= right) {
            // Get the mid value
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }
        }
        return false;
    }
}
