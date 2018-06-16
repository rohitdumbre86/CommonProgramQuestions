package com.algorithm.codefights.array;

public class FirstNonRepeating {

	static char firstNotRepeatingCharacter(String s) {

		boolean firstCompare = false;
		for (int i = 0; i < s.length();) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
                    s = s.substring(0,j)+s.substring(j+1);
                    firstCompare = true;
                    j--;
				}
			}
			
			if(firstCompare) {
				s = s.substring(i+1);
			}

		}

		return s.length()==0 ? '_' : s.charAt(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(FirstNonRepeating.firstNotRepeatingCharacter("abacabaabacaba"));

	}

}
