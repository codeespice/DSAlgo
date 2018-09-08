package com.g.ds.trivial;

import java.util.HashMap;
import java.util.Map;

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
static class FibinocciRecursive
    {
        Map<Integer,Integer> map = new HashMap<>();
        public int fibinocciRecursive(int number)
        {
            return fibR(number);
        }
        public int fibR(int n)
        {
            if(map.containsKey(n))
            {
                System.out.println("map is used for number::"+n);
                return map.get(n);
            }
            if(n<=0)
            {
                return 0;
            }
            if(n==1)
            {
                return 1;
            }
            int val = fibR(n-1)+fibR(n-2);
            if(!map.containsKey(n))
            {
                map.put(n,val);
            }
            return val;
        }
    }
    public static void main(String[] args)
    {
        FibinocciRecursion fr = new FibinocciRecursion();
        System.out.println("Recursion:"+ fr.fibinocci(9));

        FibinocciDynamicProgramming fd = new FibinocciDynamicProgramming();
        System.out.println("Dynamic Programming:"+ fd.fibinocci(4));
        FibinocciRecursive fm = new FibinocciRecursive();
        System.out.println("Recursive Programming:"+ fm.fibinocciRecursive(4));



    }
}
