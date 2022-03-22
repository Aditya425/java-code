// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str = br.readLine();
            String[] s = br.readLine().split(" ");

            int[] C = new int[n];
            for (int i = 0; i < n; i++) {
                C[i] = Integer.parseInt(s[i]);
            }

            int ans = new Solution().solve(n, str, C);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int solve(int n, String str, int C[]) {
        int cost = 0;
        
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            char ci = str.charAt(i);
            char ci1 = str.charAt(i + 1);
            char cj = str.charAt(j);
            char cj1 = str.charAt(j - 1);
            
            if (ci == cj && ci1 == cj1) {
                continue;
            }
            
            if (ci == cj1 && ci1 == cj) {
                continue;
            }
            
            int firstCost = 0, secondCost = 0;
            if (ci != cj) {
                firstCost += Math.min(C[i], C[j]);
            }
            
            if (ci1 != cj1) {
                firstCost += Math.min(C[i + 1], C[j - 1]);
            }
            
            if (ci != cj1) {
                secondCost += Math.min(C[i], C[j - 1]);
            }
            
            if (ci1 != cj) {
                secondCost += Math.min(C[i + 1], C[j]);
            }
            
            cost += Math.min(firstCost, secondCost);
        }
        
        return cost;
    }
}
