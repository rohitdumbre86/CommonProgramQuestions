package com.algorithm.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Calculates the loot.
 * 
 * @author Rohit Dumbre
 * @since X.X
 */
public class FractionalKnapsack
{
    private static double getOptimalValue(int capacity, int[] values, int[] weights)
    {
        double value = 0;

        KnapSack[] sacks = new KnapSack[values.length];

        for (int i = 0; i < values.length; i++)
        {
            sacks[i] = new KnapSack(values[i], weights[i]);
        }

        Arrays.sort(sacks, (KnapSack frac1, KnapSack frac2) -> {

            double fraction1 = frac1.fraction;
            double fraction2 = frac2.fraction;

            if (fraction1 == fraction2)
                return 0;
            else if (fraction1 > fraction2)
                return -1;
            return 1;

        }

        );
        
        int currentWeight = 0;
        
        for (int i = 0; i < values.length; i++)
        {
           if(currentWeight + sacks[i].weight <= capacity)
           {
              currentWeight += sacks[i].weight;
              value += sacks[i].value;
           }
           else
           {
               int remain = capacity - currentWeight;
               value += remain*(sacks[i].fraction);
           }

        }

        return value;
    }

    /**
     * Knapsack containing weight and value.
     * 
     * @author Rohit Dumbre
     * @since X.X
     */
    public static class KnapSack
    {
        int    value;
        int    weight;
        double fraction;

        public KnapSack(int value, int weight)
        {

            this.value = value;
            this.weight = weight;
            this.fraction = (double)value / (double)weight;
        }

    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++)
        {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
