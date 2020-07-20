package com.datastructure.complexity;

/**
 * 斐波那契数 : 一个数等于前面两个树之和
 * 0 1 1 2 3 5 8 13 ...
 *
 * 需求:求第n个斐波那契数是什么?
 */
public class Demo01_Fibonacci_Number {

    public static void main(String[] args) {
        int n = 45;
        TimeTool.check("fib1", new TimeTool.Task() {
            @Override
            public void execute() {

                System.out.println(String.format("求第%d个数的斐波那契数为 : %d", n, fib1(n)));
            }
        });
        TimeTool.check("fib2", new TimeTool.Task() {
            @Override
            public void execute() {
                System.out.println(String.format("求第%d个数的斐波那契数为 : %d", n, fib2(n)));
            }
        });
        TimeTool.check("fib3", new TimeTool.Task() {
            @Override
            public void execute() {
                System.out.println(String.format("求第%d个数的斐波那契数为 : %d", n, fib3(n)));
            }
        });
    }

    /**
     * 算法一 : 采用递归
     *
     * @param n
     * @return
     */
    public static int fib1(int n) {
        if (n <= 1) return n;
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 算法二 : 采用循环
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        //第n个斐波那契数需要循环n-1次
        for (int i = 0; i < n-1; i++) {
            int sum = first + second;
            //换位
            first = second;
            second = sum;
        }
        return second;
    }

    /**
     * 方法三 变量优化
     */
    public static int fib3(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        //第n个斐波那契数需要循环n-1次
        while (n-- > 1) {
            second += first;
            first = second - first;
        }
        return second;
    }

    /**
     * 方法四 可以用数学里面的线性代数方程公式
     */
}
