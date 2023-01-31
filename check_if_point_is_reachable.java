class Solution {

    private long gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    private boolean isPowerOfTwo(long a) {
        double floor = Math.floor(Math.log(a) / Math.log(2));
        double ceil = Math.ceil(Math.log(a) / Math.log(2));
        return floor == ceil;
    }

    public boolean isReachable(int targetX, int targetY) {
        long gcd = gcd(targetX, targetY);
        return isPowerOfTwo(gcd);
    }
}
