package com.algorithm.java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Sort map by values
		String s = "bbAbq";
		Map<Character, Integer> sortByValue = new TreeMap<Character, Integer>();

		for (Character c : s.toCharArray()) {

			if (sortByValue.containsKey(c)) {
				sortByValue.computeIfPresent(c, (k, v) -> v + 1);
			} else {
				sortByValue.put(c, 1);
			}

		}

		List<Entry<Character, Integer>> sorted = sortByValue.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());

		String sortedString = "";
		for (Entry<Character, Integer> value : sorted) {
             
			int freq = value.getValue();
			while(freq > 0) {
				sortedString +=value.getKey();
				freq--;
			}
			
		}

	}
}
