class Solution {
    public long continuousSubarrays(int[] nums) {
        PriorityQueue<int[]> maxpq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> minpq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
       long count = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            maxpq.offer(new int[]{nums[j], j});
            minpq.offer(new int[]{nums[j], j});
            while (maxpq.peek()[0] - minpq.peek()[0] > 2) {
                i++;
                while (maxpq.peek()[1] < i)
                    maxpq.poll();

                while (minpq.peek()[1] < i)
                    minpq.poll();
            }
            count += j - i + 1;
        }
        return count;
    }
}