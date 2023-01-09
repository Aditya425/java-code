class Solution {
    int mod = 1000000007;
    int[] fact = new int[100001];
    private void precompute() {
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 2; i < fact.length; i++) {
            fact[i] = (i * fact[i - 1]) % mod;
        }
    }

    private long power(long a, long b, int m) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            long t = power(a, b / 2, m);
            return ((t * t) % m);
        } else {
            long t = power(a, (b - 1) / 2, m);
            t = (t * t) % m;
            t = (a * t) % m;
            return t;
        }
    }

    private int getAnagram(String word) {
        int[] freq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            freq[c - 'a']++;
        }

        long num = fact[word.length()] % mod;
        long den = 1;
        for (int i = 0;i < 26; i++) {
            if (freq[i] > 1) {
                den = (den * fact[freq[i]]) % mod;
            }
        }
        long invMod = power(den, mod - 2, mod);
        long ans = (num * invMod) % mod;
        return (int) ans;
    }

    public int countAnagrams(String s) {
        precompute();
        long ans = 1;
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            ans = (ans * getAnagram(words[i])) % mod;
        }
        return (int) ans ;
    }
}
