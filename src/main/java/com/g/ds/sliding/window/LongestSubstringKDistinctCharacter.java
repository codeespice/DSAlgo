package com.g.ds.sliding.window;

import java.util.*;

public class LongestSubstringKDistinctCharacter {

   public int findLongestSubString(int k ,String str){

       int size=0;
       int maxSize =0;

       int pos =0;

        //Set<Character> set = new HashSet<>();
       Map<Character,Integer> map = new HashMap<>();
      //  String result= new String();
        for(int i=0;i<str.length();i++){
            Character c = str.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }else
            {
                map.put(c,map.get(c)+1);
            }
          //  set.add(c);

            if(map.keySet().size()<=k){
               // result = result+c;
                size=size+1;
            }
            else{
                maxSize =Math.max(maxSize,size);
                while(map.keySet().size()>k){
                    size=size-1;
                    if(map.get(str.charAt(pos))==1){
                        map.remove(str.charAt(pos))  ;


                    }else{
                        map.put(str.charAt(pos),map.get(str.charAt(pos))-1);

                    }
                   // map.remove(str.charAt(i))  ;
                    pos=pos+1;


                }
            }
        }

    return maxSize;
   }
    public static void main(String args[]){
        String s = "eceba";
        int k = 2;
        LongestSubstringKDistinctCharacter longestSubstringKDistinctCharacter= new LongestSubstringKDistinctCharacter();
    //   int size =  longestSubstringKDistinctCharacter.findLongestSubString(k,s);
       int secondSize = longestSubstringKDistinctCharacter.findLongestSubString(2,"aabbcc");
      // System.out.println("Size::"+size);
        System.out.println("SecondSize::"+secondSize);

    }
}
