package com.greedy;

import java.util.Scanner;

public class Change {
	private static int getChange(int m) {

		int numberOfChange = 0;

		while (m >= 5) {
			int current = 0;
			if (m >= 10 && m / 10 < m / 5) {
				current = m / 10;
				m = m - current * 10;
			} else {
				current = m / 5;
				m = m - current * 5;
			}

			numberOfChange += current;
		}

		numberOfChange += m;

		return numberOfChange;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		System.out.println(getChange(m));

	}
}