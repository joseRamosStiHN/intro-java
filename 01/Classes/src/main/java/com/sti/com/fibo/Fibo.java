package com.sti.com.fibo;

public class Fibo {
    long[] memo;

    public long fibonacciMemo(int n) {

        if(memo == null){
            memo = new long[n + 1];
            for(int i = 0; i <=n; i++){
                memo[i] = -1;
            }
        }
        if(n==0) return 0;
        if(n==1) return 1;

        // comprobar si ya se hizo el computo
        memo[n] = fibonacciMemo(n -1) + fibonacciMemo(n-2);
        System.out.println(memo[n]);
        return  memo[n];

    }
}
