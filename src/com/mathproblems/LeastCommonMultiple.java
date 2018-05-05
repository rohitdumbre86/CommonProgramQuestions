package com.mathproblems;

import java.util.Scanner;

public class LeastCommonMultiple {
	
	private static long lcm_improved(int a, int b) {
	    return (a*b)/gcd(a,b);
	  }

   private static int gcd(int a, int b) {
	    if(b==0) return a;
	    
	   int aprime = a - b*(a/b);
		return gcd(b,aprime);
	}

	public static void main(String args[]) {
	    Scanner scanner = new Scanner(System.in);
	    int a = scanner.nextInt();
	    int b = scanner.nextInt();

	    System.out.println(lcm_improved(a, b));
	  }

}
