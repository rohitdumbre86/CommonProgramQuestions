package com.algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {
	public List<Integer> splitIntoFibonacci(String S) {

		Integer[] fiboSeq = new Integer[S.length()];
		fiboSeq[0] = S.charAt(0) - '0';

		for (int i = 1; i < S.length() - 1;) {
			int noOfDigits = (fiboSeq[i - 1] + "").length();
			if (fiboSeq[i] == null) {
				fiboSeq[i] = Integer.parseInt(S.substring(i, i + noOfDigits));
			}

			int nextValue = fiboSeq[i] + fiboSeq[i - 1];

			if (S.startsWith(nextValue + "", i + 1)) {
				fiboSeq[i + 1] = nextValue;
				i = i + 1;
			} else {
				fiboSeq[i - 1] = Integer.parseInt(fiboSeq[i - 1] + "" + fiboSeq[i]);
				fiboSeq[i] = null;
				i = i==1 ? 1 : i - 1;
			}

		}

		return Arrays.asList(fiboSeq);
	}

	public static void main(String[] args) {
		Fibonacci fibo = new Fibonacci();
		List<Integer> splitIntoFibonacci = fibo.splitIntoFibonacci("123456579");
	}
}
