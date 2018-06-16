package com.algorithm.codefights.array;

public class FirstDuplicate {

	static int firstDuplicate(int[] a) {

		int minIndex = Integer.MAX_VALUE;
		int maxValue = Integer.MAX_VALUE;

		for (int i = 0; i <= a.length - 1; i++) {

			int index = Math.abs(a[i]);
			if (index == a.length) {
				if (maxValue == Integer.MAX_VALUE) {
					maxValue = a[i];
					continue;
				}
				minIndex = Math.min(minIndex, i);
				continue;
			}

			int value = a[index];
			if (value < 0) {
				minIndex = Math.min(minIndex, i);
			} else {
				a[index] = -1 * a[index];
			}
		}

		if (minIndex == Integer.MAX_VALUE)
			return -1;

		return Math.abs(a[minIndex]);
	}

	public static void main(String[] args) {
		System.out.println(FirstDuplicate.firstDuplicate(new int[] { 2, 1, 3, 5, 3, 2 }));
		System.out.println(FirstDuplicate.firstDuplicate(new int[] { 2, 5, 3, 5, 1 }));
		System.out.println(FirstDuplicate.firstDuplicate(new int[] { 1 }));
		System.out.println(FirstDuplicate.firstDuplicate(new int[] { 2, 2 }));
		System.out.println(FirstDuplicate.firstDuplicate(new int[] { 2, 4, 4, 5, 1 }));
		System.out.println(FirstDuplicate.firstDuplicate(new int[] { 2, 4, 3, 5, 1 }));
		System.out.println(FirstDuplicate.firstDuplicate(new int[] { 2, 1, 3 }));

	}

}
