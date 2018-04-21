package com.g.ds.trivial;

public class Palindrome {
    public boolean isPalindrome(String palindromeString)
    {
        int mid=0;
        if(palindromeString.length()%2==0)
        {
            mid=palindromeString.length()/2;
        }
        else
        {
            mid=palindromeString.length()/2+1;
        }
        int size = palindromeString.length()-1;

    for(int i=0;i<=mid-1;i++)
    {

        if(palindromeString.charAt(i)!=palindromeString.charAt(size-i))
        {
            return false;
        }
    }

        return true;
    }
    public static void main(String[] args)
    {
        Palindrome p = new Palindrome();
        System.out.println("isPlaindrome::"+p.isPalindrome("APURUPA"));
    }
}
