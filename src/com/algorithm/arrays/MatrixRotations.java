package com.algorithm.arrays;

/**
 * TODO Description.
 * <p />
 * <p style="font-style:italic;font-variant;small-caps;font-size:80%">
 * Copyright &copy; Cerner Corporation Jun 20, 2018 All rights reserved.
 * </p>
 * @author Rohit Dumbre
 */
public class MatrixRotations
{
    public static void rotateMatrix(int[][] arr)
    {
        for (int level = 0; level < arr.length / 2; level++)
        {
            for (int rotate = level; rotate < arr.length - 1 - level; rotate++)
            {
                int buffer = arr[arr.length - 1 - rotate][level];

                // Swap left with top
                int temp = buffer;
                buffer = arr[level][rotate];
                arr[level][rotate] = temp;

                // Swap top with bottom
                temp = buffer;
                buffer = arr[rotate][arr.length - 1 - level];
                arr[rotate][arr.length - 1 - level] = temp;

                // Swap bottom to left
                temp = buffer;
                buffer = arr[arr.length - 1 - level][arr.length - 1 - rotate];
                arr[arr.length - 1 - level][arr.length - 1 - rotate] = temp;

                // Swap left to right
                temp = buffer;
                buffer = arr[arr.length - 1 - rotate][level];
                arr[arr.length - 1 - rotate][level] = temp;
            }

        }
    }

    static int[] getLeft(int[][] arr, int level)
    {
        int[] buffer = new int[arr.length - level];

        for (int i = level, j = 0; i < arr.length - level; i++, j++)
        {
            buffer[j] = arr[i][level];
        }

        return buffer;
    }

    static void printMatrix(int[][] arr)
    {
        for (int[] row : arr)
        {

            for (int i : row)
            {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int[][] matrix =
                new int[][] {{1, 2, 3, 4}, 
                             {5, 6, 7, 8}, 
                             {9, 10, 11, 12}, 
                             {13, 14, 15, 16}};
        System.out.println("Before rotations");
        System.out.println();
        printMatrix(matrix);
        System.out.println("After rotations");
        rotateMatrix(matrix);
        printMatrix(matrix);
    }

}
