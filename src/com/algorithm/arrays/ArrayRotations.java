package com.algorithm.arrays;

public class ArrayRotations
{
    
    public void rotate(int[] nums, int k) {
        if(k==nums.length) return ;
        
        k = k%(nums.length);
        
        for(int i=0; i<k; i++)
        {
           int endElement = nums[nums.length-1];
           for(int j=nums.length-1; j-1>=0; j--)
           {
              nums[j]=nums[j-1];  
           } 
           nums[0]=endElement;
        
        }
       
      }

    public static void main(String[] args)
    {
        ArrayRotations arry = new ArrayRotations();
        arry.rotate(new int[] {1,2,3,4,5}, 3);
        long value = 1<<31;
        System.out.println(Math.abs(value));
        System.out.println(1>>31-2);

    }

}
