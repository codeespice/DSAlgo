package com.g.ds.facebook.string;

import java.util.HashMap;
import java.util.Map;

public class MinimumLengthSubstring {
    public static int minLengthSubstring(String s, String t) {
        // Check if the input strings are valid.
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return -1;
        }

        // Create a map to store the character counts in the target string.
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Initialize the start and end pointers of the sliding window.
        int start = 0;
        int end = 0;

        // Initialize the minimum length of the substring.
        int minLength = Integer.MAX_VALUE;

        // Initialize the number of characters in the sliding window that match the target string.
        int matchingChars = 0;

        // Iterate over the source string.
        while (end < s.length()) {
            // Add the current character to the sliding window.
            char c = s.charAt(end);
            if (charCountMap.containsKey(c)) {
                matchingChars++;
            }

            // While the number of matching characters is equal to the length of the target string,
            // shrink the sliding window from the left.
            while (matchingChars == t.length()) {
                // Update the minimum length of the substring.
                minLength = Math.min(minLength, end - start + 1);

                // Remove the character at the start of the sliding window.
                char startChar = s.charAt(start);
                if (charCountMap.containsKey(startChar)) {
                    matchingChars--;
                }

                // Move the start pointer to the right.
                start++;
            }

            // Move the end pointer to the right.
            end++;
        }

        // Return the minimum length of the substring.
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        String s = "dcbefebce";
        String t = "fd";

        int minLength = minLengthSubstring(s, t);

        System.out.println("The minimum length of the substring is: " + minLength);
    }
}
