package com.g.ds.trivial;

public class ArrayProductOfAnotherNumbers {

    public static void main(String args[])
    {
        int[] a = {1,2,3,4,5};
        int[] r = new int[a.length];
        int x = 1;
        r[0] = 1;
        for (int i=1;i<a.length;i++){
            r[i]=r[i-1]*a[i-1];
        }
        for (int i=a.length-1;i>0;i--){
            x=x*a[i];
            r[i-1]=x*r[i-1];
        }
        for (int i=0;i<r.length;i++){
            System.out.println(r[i]);
        }
    }
}
