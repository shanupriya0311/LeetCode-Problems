class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean sign = !((dividend < 0) ^ (divisor < 0));

        long ans = 0;
        long n = Math.abs((long) dividend);
        long divisors = Math.abs((long) divisor);

        while (divisors <= n) {
            int count = 0;

            while (n >= (divisors << (count + 1))) {
                count++;
            }

            ans += (1L << count);
            n -= (divisors << count);
        }

        return sign ? (int) ans : (int) -ans;
    }
}