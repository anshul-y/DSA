package com.dsa.algo.dynamic_programing;

import com.dsa.Answer;

public class FibonnaciNumber {
    public static void main(String[] args) {
        int fibNum = fib(6);
        Answer.print(fibNum, "Fibonacci Number(Bottom-top)");
        fibNum = fibRecur(6);
        Answer.print(fibNum, "Fibonacci Number(Recursion)");
        fibNum = fib(6, new int[6+1]);
        Answer.print(fibNum, "Fibonacci Number(Top-bottom)");
    }

    /**
     * Recursion method
     */
    private static int fibRecur(int fibNum) {
        if(fibNum<=0){
            return 0;
        }else if(fibNum==1) {
            return 1;
        }
        return fib(fibNum-1)+fib(fibNum-2);
    }

    /**
     * Bottom-up approach
     * Tabulation method
     */
    private static int fib(int n) {
        int[] fibNums = new int[n + 1];
        fibNums[0] = 0;
        fibNums[1] = 1;
        for (int i = 2; i < fibNums.length; i++) {
            fibNums[i] = fibNums[i - 1] + fibNums[i - 2];
        }
        return fibNums[n];
    }

    /**
     * Top-bottom approach
     * Memoization method
     */
    private static int fib(int n, int[] memo) {
        if (memo[n] == 0) {
            if (n < 2) {
                memo[n] = n;
            } else {
                memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
            }

        }
        return memo[n];
    }

}
