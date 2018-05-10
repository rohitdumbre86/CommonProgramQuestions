package com.algorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ShootingBalloons {
	
	 public static int findMinArrowShots(int[][] points) {
	        
         
	        int point = 0;
	        
	        int length = points.length-1;
	        
	        
	        Arrays.sort(points, new Comparator<int[]>(){
	            
	            @Override
	            public int compare(int[] o1, int[] o2){
	                
	                if(o1[1]==o2[1]) return 0;
	                else if(o1[1] > o2[1]) return 1;
	                return -1;
	                
	            }
	            
	        });
	        
	        int j = 0;
	        
	        while(j<=length)
	        {
	        	int[] minBallon = new int[2];
	            minBallon[0] = points[j][0];
	            minBallon[1] = points[j][1];
	         	
	        	if(minBallon[0]==Integer.MIN_VALUE && minBallon[1]==Integer.MIN_VALUE) break;
	        	
	        	point++;
	        	
	        	for(int i=0; i<=length;i++)
	        	{
	        		if(points[i][0] <= minBallon[1] && minBallon[1] <= points[i][1]) {
	        			points[i][0] = Integer.MIN_VALUE;
	        			points[i][1] = Integer.MIN_VALUE;
	        			j++;
	        		}
	        	}
	            
	        }
	        
	        return point;
	        
	    }
	    

	public static void main(String[] args) {
		int[][] balloons = {{0,9},{1,8},{7,8},{1,6},{9,16},{7,13},{7,10},{6,11},{6,9},{9,13}};
		System.out.println(ShootingBalloons.findMinArrowShots(balloons));
	}
}
