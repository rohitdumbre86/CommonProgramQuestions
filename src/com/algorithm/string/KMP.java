package com.algorithm.string;

/**
 * TODO Description.
 *
 * @author Rohit Dumbre
 */
public class KMP
{

    public int[] createPrefixTable(char[] prefixes)
    {
        int[] prefixTable = new int[prefixes.length];

        int i = 0;
        int j = 1;

        while (j < prefixTable.length)
        {
            if (prefixes[i] == prefixes[j])
            {

                prefixTable[j] = i + 1;
                i++;
                j++;
            }
            else if (i != 0)
            {
                i = prefixTable[i - 1];
            }
            else
            {
                prefixTable[j] = 0;
                j++;
            }

        }

        return prefixTable;
    }

    public boolean isPatternMatching(char[] originalText, char[] pattern)
    {
        int[] prefixTable = createPrefixTable(pattern);

        int index = 0;
        for (int i = 0; i < originalText.length && index < pattern.length;)
        {
            if (pattern[index] == originalText[i])
            {
                i++;
                index++;
            }
            else if (index != 0)
            {
                index = prefixTable[index - 1];
            }
            else
            {
                i++;
            }
        }

        if (index == pattern.length)
        {
            return true;
        }

        return false;

    }

    public static void main(String[] args)
    {
        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";
        KMP kmp = new KMP();
        System.out.println(kmp.isPatternMatching(str.toCharArray(), subString.toCharArray()));
    }

}
