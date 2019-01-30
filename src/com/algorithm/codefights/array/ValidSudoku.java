package com.algorithm.codefights.array;

public class ValidSudoku
{

    public static void main(String[] args)
    {
        ValidSudoku sudoku = new ValidSudoku();
        sudoku.isValidSudoku(new char[][] {
            {'.','.','.','.','5','.','.','1','.'},
            {'.','4','.','3','.','.','.','.','.'},
            {'.','.','.','.','.','3','.','.','1'},
            {'8','.','.','.','.','.','.','2','.'},
            {'.','.','2','.','7','.','.','.','.'},
            {'.','1','5','.','.','.','.','.','.'},
            {'.','.','.','.','.','2','.','.','.'},
            {'.','2','.','9','.','.','.','.','.'},
            {'.','.','4','.','.','.','.','.','.'}});
    }

    public boolean isValidSudoku(char[][] board)
    {

        if (dupRowEntry(board))
            return false;

        if (dupColEntry(board))
            return false;

        for (int i = 0; i < 9; i = i + 2)
        {
            if (dupCubEntry(board, i, i + 2, i, i + 2))
            {
                return false;
            }
            i++;
        }

        return true;
    }

    // Check row
    public boolean dupRowEntry(char[][] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            boolean[] rowDup = new boolean[10];

            for (int j = 0; j < arr[i].length; j++)
            {

                if (arr[i][j] >= '1' && arr[i][j] <= '9')
                {
                    if (rowDup[arr[i][j] - '0'])
                    {
                        return true;
                    }

                    rowDup[arr[i][j] - '0'] = true;
                }
            }

        }

        return false;
    }

    // Check column
    public boolean dupColEntry(char[][] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            boolean[] colDup = new boolean[10];

            for (int j = 0; j < arr.length; j++)
            {
                if (arr[j][i] >= '1' && arr[j][i] <= '9')
                {

                    if (colDup[arr[j][i] - '0'])
                    {
                        return true;
                    }

                    colDup[arr[j][i] - '0'] = true;
                }
            }

        }

        return false;
    }

    // Check cubes
    public boolean dupCubEntry(char[][] arr, int iStart, int iEnd, int jStart, int jEnd)
    {
        boolean[] cubDup = new boolean[10];

        for (int i = iStart; i <= iEnd; i++)
        {
            for (int j = jStart; j <= jEnd; j++)
            {
                if (arr[i][j] >= '1' && arr[i][j] <= '9')
                {
                    if (cubDup[arr[i][j] - '0'])
                    {
                        return true;
                    }
                    cubDup[arr[i][j] - '0'] = true;
                }

            }
        }

        return false;
    }

}
