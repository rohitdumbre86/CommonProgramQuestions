package com.algorithm.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskScheduler {

	public static int leastInterval(char[] tasks, int n) {

		Arrays.sort(tasks);

		++n;
 
		char[] scheduler = new char[tasks.length+n];
		int j = 0;
		int previousIndex = 0;
		for (int i = 1; i < tasks.length; i++) {
			if (tasks[i] == tasks[i - 1]) {
				scheduler[j] = tasks[i-1];
				j = j+n;
				scheduler[j] = tasks[i-1];
				j = j+n;
			} else {
				scheduler[j] = tasks[i-1];
				++previousIndex;
				scheduler[previousIndex] =  tasks[i];
				j = previousIndex;

			}

			i++;

		}
		
		int length = scheduler.length-1;
		
		while(length >=0 && scheduler[length]=='\0') {
			length--;
		}

		return length+1;
	}

	public static void main(String[] args) {
		System.out.println(TaskScheduler.leastInterval(new char[] {'A','C','A','B','B','B'}, 3));

	}

}
