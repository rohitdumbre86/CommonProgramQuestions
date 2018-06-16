package com.algorithm.leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

	public String frequencySort(final String words) {

		String[] alphanumeric = new String[255];

		for (final char c : words.toCharArray()) {

			String alphanum = alphanumeric[c];
			if (alphanum == null) {
				alphanumeric[c] = c + "";
			} else {
				alphanumeric[c] += c;
			}

		}

		PriorityQueue<String> queue = new PriorityQueue<String>((s1, s2) -> s2.length() - s1.length());

		for (String i : alphanumeric) {
			if (i != null) {
				queue.add(i);
			}
		}

		String word = "";
		while (!queue.isEmpty()) {
			word += queue.poll();
		}

		return word;
	}

	public static void main(String[] args) {
		SortCharactersByFrequency freq = new SortCharactersByFrequency();

		System.out.println(freq.frequencySort("his s he a ha he  ha ae"));

	}

}
