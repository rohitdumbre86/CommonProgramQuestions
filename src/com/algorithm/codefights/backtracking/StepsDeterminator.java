package com.algorithm.codefights.backtracking;

public class StepsDeterminator
{

    public int[][] climbingStairs(int n, int k)
    {

        // for (int i = 1; i <= k; i++)
        {
            int[] step = new int[n];
            stepSequencer(step, 0, n, 0, k, 1);

        }

        return null;
    }

    private void stepSequencer(int[] steps,
                               int currentSum,
                               int targetSum,
                               int currentIndex,
                               int maxValue,
                               int currValue)
    {
        
        if(currentIndex > steps.length) return;
        
        if (currentSum == targetSum)
        {
            int sum = 0;
            int j =0;
            while (sum < targetSum)
            {                
                System.out.print(steps[j] + ":");                
                sum += steps[j];
                j++;
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= maxValue; i++)
        {
            steps[currentIndex] = i;

            if (currentSum + i <= targetSum)
            {
                currentSum += i;
                stepSequencer(steps, currentSum, targetSum, currentIndex+1, maxValue, i);
            }
        }

    }

    public static void main(String[] args)
    {
        StepsDeterminator stepsDeterminator = new StepsDeterminator();
        stepsDeterminator.climbingStairs(7, 3);
    }

}
