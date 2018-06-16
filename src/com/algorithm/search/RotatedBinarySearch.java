package com.algorithm.search;

public class RotatedBinarySearch {

	public static int search(int[] array, int key) {

		int low = 0;
		int high = array.length - 1;
		while (low < high) {

			int mid = low + (high - low) / 2;

			if (array[mid] == key)
				return mid;

			// Low is less than mid then it means that pivot must the first sorted half.
			if (array[low] <= array[mid]) {

				if (key >= array[low] && array[mid] > key) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			// The pivot must be in the other sorted half.
			} else {
				if (key > array[mid] && key <= array[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}

			}

		}

		return array[low]==key ? low : -1;
	}

	public static void main(String[] args) {

		for (int i = 0; i <= 10; i++) {
			System.out.println("index = "+RotatedBinarySearch.search(new int[] { 4, 5, 6, 7, 8, 9, 10, 11, 0, 1, 2, 3}, i));
		}

	}

}
