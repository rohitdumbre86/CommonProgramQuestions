package com.algorithm.backtrack;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.management.ImmutableDescriptor;

public class CombinationCreator {

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> combinations = new LinkedList<List<Integer>>();

		for (int i = 0; i < candidates.length; i++) {
			combinationCreator(combinations, new LinkedList<Integer>(), candidates, target,i);
		}

		return combinations;
	}

	private static void combinationCreator(List<List<Integer>> combinations, List<Integer> combination,
			int[] candidates, int target, int index) {

		for (int i = index; i < candidates.length; i++) {

			int currentValue = combination.stream().mapToInt(Integer::intValue).sum();

			if (currentValue + candidates[i] < target) {

				combination.add(candidates[i]);
				combinationCreator(combinations, combination, candidates, target, index);

				if (!combination.isEmpty()) {
					combination.remove(combination.size() - 1);
				}

			} else if (currentValue + candidates[i] == target) {
				combination.add(candidates[i]);
				if(!combinations.contains(combination)) {
					combinations.add(new LinkedList<Integer>(combination));
				}
				combination = new LinkedList<Integer>();
				break;
			}

		}

	}

	public static void main(String[] args) {
		List<List<Integer>> answers = CombinationCreator.combinationSum(new int[] {2,3,7}, 18);
		
		answers.forEach(list->{list.forEach(System.out::print);System.out.println();});

	}

}
