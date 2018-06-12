package com.algorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ShootingBalloons {

	public static int findMinArrowShots(int[][] points) {
		int noOfPoints = 0 ;
		if (points.length == 0)
			return 0;

		PriorityQueue<int[]> elements = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[1], b[1])
		);

		for (int i = 0; i < points.length; i++) {
			elements.add(points[i]);
		}
		
		
		int[] minPoint = elements.poll();
		noOfPoints++;
	   
		while(!elements.isEmpty()) {
			
			int[] arrays = elements.poll();
			
			if(arrays[0] <= minPoint[1] && arrays[1] >= minPoint[1]) {
				continue;
			}
			
			minPoint[0] = arrays[0];
			minPoint[1] = arrays[1];
			noOfPoints++;
		}
		
 
		return noOfPoints;
	}

	public static void main(String[] args) {
		int[][] balloons = { { 0, 9 }, { 1, 8 }, { 7, 8 }, { 1, 6 }, { 9, 16 }, { 7, 13 }, { 7, 10 }, { 6, 11 },
				{ 6, 9 }, { 9, 13 } };
	//	System.out.println(ShootingBalloons.findMinArrowShots(balloons));
		System.out.println(4<<(1/2));
		System.out.println(5<<4);
		System.out.println(64>>2);
		System.out.println(64>>>2);
	}
}
