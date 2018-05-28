package com.algorithm.leetcode.greedy;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that
 * the new number is the smallest possible.
 * 
 * <pre>
 *  Input: num = "1432219", k = 3
 *  Output: "1219"
 *  Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * </pre>
 * <p />
 * <p style="font-style:italic;font-variant;small-caps;font-size:80%">
 * Copyright &copy; Cerner Corporation May 24, 2018 All rights reserved.
 * </p>
 * 
 * @since X.X
 */
public class RemoveKDigits
{
    public static String removeKdigits(String num, int k)
    {
        int digits = num.length() - k;
        char[] stk = new char[num.length()];
        int top = 0;
        // k keeps track of how many characters we can remove
        // if the previous character in stk is larger than the current one
        // then removing it will get a smaller number
        // but we can only do so when k is larger than 0
        for (int i = 0; i < num.length(); ++i)
        {
            char c = num.charAt(i);
            while (top > 0 && stk[top - 1] > c && k > 0)
            {
                top -= 1;
                k -= 1;
            }
            stk[top++] = c;
        }
        // find the index of first non-zero digit
        int idx = 0;
        while (idx < digits && stk[idx] == '0')
            idx++;
        return idx == digits ? "0" : new String(stk, idx, digits - idx);
    }

    public static void main(String[] args)
    {
        String removeKdigits = RemoveKDigits.removeKdigits("1432219", 3);
        System.out.println("Smallest number is "+removeKdigits);
    }

}
