package com.g.ds.sliding.window;

public class LongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(i++)] > 0);
                num--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
    public static void main(String args[]){
        LongestSubstringKDistinct longestSubstringKDistinct = new LongestSubstringKDistinct();

       int n = longestSubstringKDistinct.lengthOfLongestSubstringKDistinct("eceba",2);
       System.out.println("n="+n);
    }
}
