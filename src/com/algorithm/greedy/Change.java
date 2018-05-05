package com.algorithm.greedy;

import java.util.Scanner;

/**
 * Greedy algorithm for finding money change.
 * 
 * @author Rohit Dumbre
 * @since X.X
 */
public class Change
{
    private static int getChange(int m)
    {

        int noOfChanges = 0;
        while (m >= 5)
        {
            if (m>=10 && m / 10 < m / 5)
            {
              noOfChanges += m/10;
              m = m - 10*(m/10);
            }
            else {
              noOfChanges += m/5;
              m = m - 5*(m/5);
            }
        }

        return noOfChanges + m;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
