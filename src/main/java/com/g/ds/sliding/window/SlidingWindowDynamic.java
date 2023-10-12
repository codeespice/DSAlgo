package com.g.ds.sliding.window;
//https://www.youtube.com/watch?v=nCcSwjFmfMM
public class SlidingWindowDynamic {
//Find the minimum subarray of sum =k
    int findMinSubArray(int[] arr,int sum){
        int calcSum =0;
        int size=Integer.MAX_VALUE;
        int j=0;
        int pos=0;

        for(int i=0;i<arr.length;i++){ // first pointer

            calcSum =calcSum+arr[i];

            while(calcSum>=sum){ //reducing pointer pos , increase pos from 0 to i

                size = Math.min(size,i-pos+1);//i-pos+1 because array is zero based index
                calcSum =calcSum-arr[pos++];

            }


        }
        return size;

    }
    public static void main(String args[]){
        int[] arr = {5,1,3,5,10,7,4,9,2,8};
        int sum =15;
        SlidingWindowDynamic slidingWindowDynamic= new SlidingWindowDynamic();
        int size = slidingWindowDynamic.findMinSubArray(arr,sum);
        System.out.println("minSize:"+size);
    }
}
