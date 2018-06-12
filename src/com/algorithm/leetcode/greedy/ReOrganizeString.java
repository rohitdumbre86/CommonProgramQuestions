package com.algorithm.leetcode.greedy;

import java.util.PriorityQueue;

public class ReOrganizeString {

	public String reorganizeString(String S) {
		int N = S.length();
		int[] count = new int[26];

		for (char c : S.toCharArray()) {
			count[c - 'a']++;
			if (count[c - 'a'] > (N + 1) / 2)
				return "";

		}

		final PriorityQueue<MultiChar> queue = new PriorityQueue<MultiChar>(
				(a, b) -> a.count == b.count ? a.c - b.c : a.count - b.count);

		for (int i = 0; i < count.length; i++) {

			if (count[i] > 0) {
				queue.add(new MultiChar(count[i], (char) ('a' + i)));
			}

		}

		StringBuilder str = new StringBuilder();
		while (queue.size() >= 2) {
			MultiChar char1 = queue.poll();
			MultiChar char2 = queue.poll();

			str.append(char1.c);
			str.append(char2.c);

			if (--char1.count > 0)
				queue.add(char1);
			if (--char2.count > 0)
				queue.add(char2);

		}

		if (queue.size() > 0) {
			str.append(queue.poll().c);
		}

		return str.toString();
	}

	public class MultiChar {
		int count;
		char c;

		MultiChar(int count, char c) {
			this.c = c;
			this.count = count;
		}
	}

	public static void main(String[] args) {
		ReOrganizeString str = new ReOrganizeString();
		str.reorganizeString("aab");

	}

}
