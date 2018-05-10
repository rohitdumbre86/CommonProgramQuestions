package com.algorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {
	
	public static int[][] reconstructQueue(int[][] people) {
        // This is a copied solution 
        Arrays.sort(people,new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2){
               return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
           }
        });
        
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            if(cur[1]>=res.size())
                res.add(cur);
            else
                res.add(cur[1],cur);       
        }
        
        return res.toArray(new int[people.length][]);
        
    }
	
	public static void main(String[] args) {
		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		
		people  = QueueReconstructionByHeight.reconstructQueue(people);

		for(int i=0; i<people.length; i++)
		{
			System.out.print(" ["+people[i][0]+","+people[i][1]+"] ");
		}
	}

}
