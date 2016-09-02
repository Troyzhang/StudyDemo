package com.troy.demo;

/**
 * Created by zhangyongyu on 16/9/2.
 *
 * @parse com.troy.demo
 */
public class demo3 {
    public static void maind(String[] args) {
        byte nDisks = 4;
        doTowers(nDisks, 'A', 'B', 'C');
    }

    public static void doTowers(int topN, char from, char inter, char to) {
        if(topN == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Disk " + topN + " from " + from + " to " + to);
            doTowers(topN - 1, inter, from, to);
        }

    }

    public static long fibonacci(long number) {
        return number != 0L && number != 1L?fibonacci(number - 1L) + fibonacci(number - 2L):number;
    }

    public static void main(String[] args) {
        for(int counter = 0; counter <= 10; ++counter) {
            System.out.printf("Fibonacci of %d is: %d\n", new Object[]{Integer.valueOf(counter), Long.valueOf(fibonacci((long)counter))});
        }

    }
}
