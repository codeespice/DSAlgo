package com.g.ds.sliding.window;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowStatic {
    //k=3  fixed size

    List<Integer> sumofKElements(int[] arr, int k){
        List<Integer> a = new ArrayList();
        int sum =0;
        int pos=0;

        for(int i=0;i<k;i++){
            sum = sum+arr[i];

        }
        a.add(sum);
        for(int i=1;i<arr.length-k;i++){

            sum = sum -arr[i-1];
            sum = sum +arr[i+k-1];
            a.add(sum);



        }
        return a;
    }
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,8,9};
        int k =3;
        SlidingWindowStatic slidingWindowStatic = new SlidingWindowStatic();
       List<Integer> list=  slidingWindowStatic.sumofKElements(arr,k);
       System.out.println(list);
    }
}
