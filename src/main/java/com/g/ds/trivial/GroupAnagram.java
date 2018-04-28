package com.g.ds.trivial;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.*;
/*
Intuition

Two strings are anagrams if and only if their sorted strings are equal.


 */
public class GroupAnagram {
    public static void main(String[] args)
    {


        String[] strs = {"are","bat","ear","code","tab","era"};
        GroupAnagram groupAnagram = new GroupAnagram();
        List<List<String>> groupedAnagrams = groupAnagram.groupAnagramsByCount(strs);

        groupedAnagrams.forEach((g)->{

            g.forEach((str)->{
                System.out.print(str+",");
            });
            System.out.println("");
        });

    }
    public List<List<String>> groupAnagramsByCount(String[] strs)
    {
        List<List<String>> groupedAnagrams = groupAnagrams(strs);
        Collections.sort(groupedAnagrams, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o2.size()-o1.size();
            }
        });
        return groupedAnagrams;

    }
    public List<List<String>> groupAnagrams(String[] strs)
    {
        if(strs==null || strs.length==0 )
        {
        return new ArrayList<>();
        }
        HashMap<String,List<String>> anagramGroup= new HashMap<String,List<String>>();
        for(String str:strs)
        {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);

            if(!anagramGroup.containsKey(key))
            {
                anagramGroup.put(key,new ArrayList<>());
            }
            anagramGroup.get(key).add(str);




        }
        return new ArrayList(anagramGroup.values());
        
    }

}
