package com.algorithm.leetcode.greedy;

public class JumpGame {
	  public boolean canJump(int[] nums) {
	        
	        for (int i=0; i<nums.length;)
	        {
	            int currentJump = nums[i];
	            
	            if(currentJump == 0) return false;
	            else if(currentJump == 1) 
	            {
	                i++;
	                continue;
	            }
	            
	            int mI = i+1;
	            int cI = i+1;
	            
	            while(currentJump > 0  && cI < nums.length){
	                
	                if(nums[mI] < nums[cI]){
	                    mI = cI;
	                }
	                else {
	                    cI++;
	                }
	                
	                currentJump--;
	            }
	            
	            
	            i += mI;
	        }
	        
	        return true;
	    }

	public static void main(String[] args) {
		JumpGame jp  = new JumpGame();

	}

}
