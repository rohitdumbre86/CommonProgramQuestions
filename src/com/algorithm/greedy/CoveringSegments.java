package com.algorithm.greedy;

import java.util.*;

public class CoveringSegments {

	private static int[] optimalPoints(Segment[] segments) {

		int n = segments.length - 1;
		List<Integer> points = new ArrayList<Integer>();


		while (n >= 0) {
			Segment minSegment = getMinRightSegment(segments, n);
			
			if(minSegment==null) break;
			
			points.add(minSegment.end);

			int j = 0;
			while (j < n) {
				
				if (segments[j]!=null && segments[j].start <= minSegment.end && minSegment.end <= segments[j].end) {
					
					segments[j] = segments[n];
					segments[n] = null;

				} else {
					j = j + 1;
				}
			}
			


		}
		
		int[] arrays = new int[points.size()];

		for(int i=0; i<points.size(); i++)
		{
			arrays[i] = points.get(i);
		}
		
		return arrays;
	}

	private static Segment getMinRightSegment(Segment[] segments, int n) {
		
		Segment minRight = segments[0];

		for (Segment segment : segments) {
			if (segment != null) {
				
				minRight = segment.end <= minRight.end ? segment : minRight;

			}
		}

		return minRight;
	}

	private static class Segment {
		int start, end;

		Segment(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Segment[] segments = new Segment[n];
		for (int i = 0; i < n; i++) {
			int start, end;
			start = scanner.nextInt();
			end = scanner.nextInt();
			segments[i] = new Segment(start, end);
		}
		int[] points = optimalPoints(segments);
		System.out.println(points.length);
		for (int point : points) {
			System.out.print(point + " ");
		}
	}
}
