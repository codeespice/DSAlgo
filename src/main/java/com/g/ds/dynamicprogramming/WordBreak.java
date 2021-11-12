package com.g.ds.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Solution: Sequence Problem so you have to have two for loops ;
one for the main string and other for subset of the strings
Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false



 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> dict){
        boolean[] dp = new boolean[s.length()+1];

        //base case : empty String "" can be broken up into valid words
        dp[0] = true;

        //compute whether the string upto i can be broken into valid words
        for(int i=1;i<=s.length();i++){
            //at each position we look all the possible substrings that can be formed at the end
            for(int j=0;j<i;j++){
                //if substring between j and i is valid
                //and if everything between j can be split into valid words
                if(dp[j]  && dict.contains(s.substring(j,i))){
                    dp[i] =true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public static void main(String[] args){
        WordBreak wb = new WordBreak();
        Set<String> dictionary = new HashSet<>();
        dictionary.add("leet");
        dictionary.add("code");
        String s = "leetcode";
       boolean result = wb.wordBreak(s,dictionary);
       System.out.println("Result:"+result);
    }
}
