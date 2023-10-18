package com.g.ds.sliding.window;

import java.util.HashMap;

public class FruitsInBasket {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        HashMap<Integer,Integer> m=new HashMap<>();
        int ans=0;
        int i=0;
        int j=0;

        while(i<n)
        {
            m.put(fruits[i], m.getOrDefault(fruits[i], 0) + 1);
            if(m.size()>2)
            {
                while(m.size()>2)
                {
                    m.put(fruits[j],m.get(fruits[j])-1);
                    if(m.get(fruits[j])==0)
                        m.remove(fruits[j]);
                    j++;

                }
            }
            ans=Math.max(ans,i-j+1);
            i++;

        }
        return ans;


    }
public static void main(String args[]){
        FruitsInBasket fruitsInBasket = new FruitsInBasket();
        int [] fruits = {1,2,3,2,2};

   int n=  fruitsInBasket.totalFruit(fruits);
        System.out.println("n="+n);
}

}
