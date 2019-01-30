package com.datastructures.bintree;

import java.util.HashMap;
import java.util.Map;

public class ComputePathSum5
{

    public static void main(String[] args)
    {
        final ComputePathSum5 compute = new ComputePathSum5();
        int total = compute.pathSum(new int[] {113,215,221,314,325,335});
        System.out.println(total);
    }

    public int pathSum(int[] nums)
    {

        // Initialize a multi map
        Map<Integer, Map<Integer, Integer>> numByPosByLvl =
                new HashMap<Integer, Map<Integer, Integer>>();

        int maxLevel = 0;
        for (int i = 0; i < nums.length; i++)
        {
            int hundredsP = nums[i] / 100;
            int tensP = (nums[i] % 100) / 10;
            int unitsP = (nums[i] % 100) % 10;

            if (i == nums.length - 1)
            {
                maxLevel = hundredsP;
            }

            if (numByPosByLvl.containsKey(hundredsP))
            {
                Map<Integer, Integer> numByPosition = numByPosByLvl.get(hundredsP);
                if (!numByPosition.containsKey(tensP))
                {
                    numByPosition.put(tensP, unitsP);
                }
            }
            else
            {
                Map<Integer, Integer> numByPosition = new HashMap<Integer, Integer>();
                numByPosition.put(tensP, unitsP);
                numByPosByLvl.put(hundredsP, numByPosition);
            }
        }

        // Iterate through map , such that add the root node value to child node.
        int finalValue = 0;
        for (int i = 1; i <= maxLevel; i++)
        {
            Map<Integer, Integer> numByPos = numByPosByLvl.get(i);
                
            Map<Integer, Integer> nextLevel = numByPosByLvl.get(i + 1);

            for (Map.Entry<Integer, Integer> numByPosSet : numByPos.entrySet())
            {
                int childPos = numByPosSet.getKey();
                int value = numByPosSet.getValue();

              
                // Get parent.

                if (nextLevel != null)
                {
                    int lChild = 2*(childPos-1)+1;
                    int rChild = 2*(childPos - 1) + 2;
                    
                   if(nextLevel.containsKey(lChild)) {
                       nextLevel.compute(lChild, (k,v)-> v+ value);
                   }
                   if(nextLevel.containsKey(rChild)) {
                       nextLevel.compute(rChild, (k,v)-> v+ value);
                   }
                   
                   if(!nextLevel.containsKey(rChild) && !nextLevel.containsKey(lChild)) {
                       finalValue += value;
                   }
                   
                }
                else {
                    finalValue += value;
                }

            }

        }

        return finalValue;
    }

}
