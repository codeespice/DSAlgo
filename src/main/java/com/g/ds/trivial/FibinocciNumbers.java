package com.g.ds.trivial;

public class FibinocciNumbers {

    //Classic recursion Example
    /*
    Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
    We can observe that this implementation does a lot of repeated work
    (see the following recursion tree). So this is a bad implementation for nth Fibonacci number.
          fib(5)
                     /
               fib(4)                fib(3)
             /                      /
         fib(3)      fib(2)         fib(2)    fib(1)
        /             /           /
  fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
  /
fib(1) fib(0)
     */
    static class FibinocciRecursion
    {
        public int fibinocci(int n)
        {
            if(n<=1)
            {
                return n;
            }

            return fibinocci(n-1)+fibinocci(n-2);
        }

    }


    //Fibiocci dynamic Programming
    /*
    We can avoid the repeated work done is the method 1 by storing the Fibonacci numbers calculated so far.
    but we are allocating memory for every element that we are calculating
     */
    static class FibinocciDynamicProgramming {

        public int fibinocci(int n)
        {
            int[] fib = new int[n+2];

            fib[0]=0;
            fib[1]=1;
            for(int i=2;i<=n;i++)
            {
                fib[i]=fib[i-1]+fib[i-2];
            }

            for(int i=0;i<fib.length;i++)
            {
                System.out.println(i+" :  "+fib[i]);
            }
           return fib[n];
        }

    }

    public static void main(String[] args)
    {
        FibinocciRecursion fr = new FibinocciRecursion();
        System.out.println("Recursion:"+ fr.fibinocci(9));

        FibinocciDynamicProgramming fd = new FibinocciDynamicProgramming();
        System.out.println("Dynamic Programming:"+ fd.fibinocci(4));

    }
}
