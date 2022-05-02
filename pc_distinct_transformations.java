import java.util.*;
import java.math.*;
 
 class Main {
 	 public static void main (String[] args) {
 	 Scanner sc=new Scanner(System.in);
 	     String s=sc.next();
 	     String t=sc.next();
 	     function(s, t);
 	 }
 	 	 // -----------------------------------------------------
 	 // This is a functional problem. Only this function has to be written.
 	 // This function takes as input 2 strings 
 	 // It should return the required output
 
 	 public static void function(String S, String T){
		Map<Character, Integer> mt = new HashMap<>();
		Map<Character, Integer> ms = new HashMap<>();
		Set<Character> tSet = new HashSet<>();
		for (char c : T.toCharArray()) {
			tSet.add(c);
		}
		for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);
			mt.put(c, mt.getOrDefault(c, 0) + 1);
		}

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			ms.put(c, ms.getOrDefault(c, 0) + 1);
		}
		int ans = 0;
		for (char c : tSet) {
			int cs = ms.get(c);
			int ct = mt.get(c);
			int n = cs;
			int r = cs - ct;
			if (n == 0) {
				continue;
			}
			int ncr = 0;
			if (r != 0) {
				ncr = factorial(n) / (factorial(n - r) * factorial(r));
			}
			ans += ncr;
		}

		System.out.println(ans == 0 ? 1 : ans + 1);
 	 }

	  static int factorial(int n) {
		  if (n == 0) {
			  return 1;
		  }

		  if (n == 1) {
			  return 1;
		  }
		  return n * factorial(n - 1);
	  }
 }
