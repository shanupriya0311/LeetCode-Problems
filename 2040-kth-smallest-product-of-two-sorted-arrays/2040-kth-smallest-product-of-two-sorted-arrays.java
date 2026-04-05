class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10000000000L;
        long right = 10000000000L;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (count(nums1, nums2, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private long count(int[] nums1, int[] nums2, long mid) {
        long cnt = 0;

        for (int a : nums1) {
            if (a > 0) {
                int l = 0, r = nums2.length - 1;
                int pos = -1;

                while (l <= r) {
                    int m = (l + r) / 2;
                    if ((long)a * nums2[m] <= mid) {
                        pos = m;
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }

                cnt += (pos + 1);

            } else if (a < 0) {
                int l = 0, r = nums2.length - 1;
                int pos = nums2.length;

                while (l <= r) {
                    int m = (l + r) / 2;
                    if ((long)a * nums2[m] <= mid) {
                        pos = m;
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }

                cnt += (nums2.length - pos);

            } else { // a == 0
                if (mid >= 0) {
                    cnt += nums2.length;
                }
            }
        }

        return cnt;
    }
}