package com.g.ds.facebook.hashtable;

import java.util.HashMap;
import java.util.Map;
//not accurate need refinement but the solution is inline
public class PairSum {
    int numberOfWays(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int a : arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int count=0;
        int individualCount=0;
        for(int key : map.keySet()){
            if(map.containsKey((k-key))){
                if(k-key == key){
                    individualCount = map.get(key);
                    count += (individualCount*(individualCount-1))/2;
                }else{
                    count += (map.get(key)*map.get((k-key)))/2;
                }

            }
        }

        return count;



    }
    public static void main(String args[]){
        PairSum ps = new PairSum();
        int[] arr = {1, 5, 3, 3, 3};
        int k = 6;
       int count = ps.numberOfWays(arr,6);
       System.out.println(count);
    }
}
