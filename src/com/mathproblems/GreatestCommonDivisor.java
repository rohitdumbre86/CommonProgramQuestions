package com.mathproblems;

public class GreatestCommonDivisor {
	
	
	/**
	 * Key lemma theorm
	 * 
	 *  a = a' + bq
	 *  then d is gcd if and only if d can divide a' and b.
	 *  
	 * @param a
	 * @param b
	 * @return
	 */
	public static long gcd(long a, long b)
	{
		if(b==0) return a;
		
		long aprime = a - b*(a/b);
		
		return gcd(b,aprime);
	}

	public static void main(String[] args) {
		
		long commonDivisor = gcd(357,234);
		System.out.println(commonDivisor);

	}

}
