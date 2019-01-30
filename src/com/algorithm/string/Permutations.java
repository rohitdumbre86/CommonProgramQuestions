package com.algorithm.string;

import java.util.Arrays;
import java.util.List;

public class Permutations {
	
	public static void permutate(String original, String newString) {
		
		if(original.length()==0) {
			System.out.println(newString);
			return;
		}
		
		for(int i=0; i<original.length(); i++)
		{
		  String s1 = original.substring(0,i);
		  String s2 = original.substring(i+1);
		  
		  permutate(s1+s2, newString+original.charAt(i));
			
			
		}
		
		
	}

	public static void main(String[] args) {
		List<Long> longs = Arrays.asList(1l,2l,3l);
	    System.out.println(longs);
	    Permutations.permutate("ABCDE", "");
		

	}

}
