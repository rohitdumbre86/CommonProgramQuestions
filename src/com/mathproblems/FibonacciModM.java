package com.mathproblems;

import java.util.Scanner;

public class FibonacciModM {

	private static long getFibonacciHugeNaive(long n, long m) {
		if (n <= 1)
			return n;

		long previous = 0;
		long current = 1;

		for (long i = 0; i < n - 1; ++i) {
			long tmp_previous = previous;
			previous = current;
			current = tmp_previous + current;
		}

		return current % m;
	}

	private static long getFibonacci(long n, long m) {

		if (n <= 1)
			return n;

		long previous = 0;
		long current = 1;
		long fiboCurrent = 1;

		if (n > m) {
			n = n % getModLen(m, n);
		}

		for (long i = 2; i <= n; i++) {
			fiboCurrent = current + previous;
			previous = current;
			current = fiboCurrent;
		}

		return fiboCurrent % m;
	}

	private static long getModLen(long m, long n) {

		long a = 0, b = 1, c = a + b;

		for (int i = 0; i < m * m; i++) {

			c = (a + b) % m;
			a = b;
			b = c;
			if (a == 0 && b == 1) {
				return i + 1;
			}

		}

		return 0L;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long m = scanner.nextLong();
		System.out.println(getFibonacci(n, m));
	}
}
