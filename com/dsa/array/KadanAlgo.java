package com.dsa.array;

public class KadanAlgo {

    private int[] array; 

    KadanAlgo(int[] arr){
        this.array = arr;
    }

    private int start = 0;
    private int end = 0;

    public int getStartIndex() {
        return start;
    }

    public int getEndIndex() {
        return end;
    }

    public static int getMax(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    public int maxSubArray() {
        int sum = 0;
        int max = array[0];
        if(array.length==1) return max;
        for (int i = 0; i < array.length; i++) {
            sum +=array[i];
            max = getMax(sum,max);
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }
}
