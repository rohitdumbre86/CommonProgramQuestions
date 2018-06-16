package com.algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSumTriplets {
	public static List<List<Integer>> threeSum(int[] nums) {

		Set<List<Integer>> triplets = new HashSet<List<Integer>>();

		Arrays.sort(nums);

		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			int x = nums[i];
			int l = i + 1;
			int r = n - 1;

			while (l < r) {
				int sum = nums[l] + nums[r] + x;
				if (sum == 0) {
					triplets.add(Arrays.asList(nums[i], nums[l], nums[r]));
					l++;
					r--;
				} else if (sum < 0) {
					l++;
				} else if (sum > 0) {
					r--;
				}
			}
		}

		List<List<Integer>> results = new ArrayList<List<Integer>>();

		for (List<Integer> triplet : triplets) {
			results.add(triplet);
		}

		return results;

	}

	public static void main(String[] args) {
		List<List<Integer>> sums = FindSumTriplets.threeSum(new int[] {-2,0,1,1,2});
		
		for(final List<Integer> sum : sums) {
			sum.forEach(x->System.out.print(x+","));
			System.out.println();
		}

	}

}
