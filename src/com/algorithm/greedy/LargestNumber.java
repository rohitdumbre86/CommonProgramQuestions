package com.algorithm.greedy;

import java.util.*;

public class LargestNumber {
	private static String largestNumber(String[] a) {
		// write your code here
		String result = "";

		int i = 0;
		while (i < a.length) {

			int index = i+1;
			while (index < a.length) {
				
				if(compareDigits(a[index], a[i])) {
					String temp = a[i];
					a[i] = a[index];
					a[index] = temp;
				}
				
				index++;

			}
			result += a[i];
			i++;
		}

		
		return result;
	}

	private static boolean compareDigits(String s1, String s2) {
	  
		int comb1 =Integer.parseInt(s1+s2);
		int comb2 = Integer.parseInt(s2+s1);
		
		return comb1 >= comb2;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] a = new String[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.next();
		}
		System.out.println(largestNumber(a));
	}
}
