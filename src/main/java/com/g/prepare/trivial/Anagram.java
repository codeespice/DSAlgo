package com.g.prepare.trivial;

public class Anagram {



    public Anagram()
    {

    }
    //O[N^2]
    public boolean isAnagram(String firstString,String secondString){

        if(firstString==null ||  secondString==null)
        {
            return false;
        }
        char[] firstChars = firstString.toLowerCase().replaceAll("\\s","").toCharArray();
        char[] secondChars = secondString.toLowerCase().replaceAll("\\s","").toCharArray();
        if(firstChars.length!=secondChars.length)
        {
            return false;
        }
        boolean[] compare =  new boolean[firstChars.length];


        for(int i=0;i<firstChars.length;i++)
        {
            for(int j=0;j<secondChars.length;j++)
            {
                /*Compare the arrays, after comparison mark both the
                characters as '!'
                */
                if(firstChars[i]==secondChars[j])
                {
                    firstChars[i]='!';
                    secondChars[j]='!';

                }
            }

        }

        for(int i=0;i<firstChars.length;i++)
        {
            System.out.println(firstChars[i]);
            if(firstChars[i]!='!')
            {

                return false;
            }
        }
        return true;

    }

/*
1.Take first string
2.Get the characters and store the count of each character in 256 element array
3.Take the second string
4.Get the characters and reduce teh count of each character in 256 element array
5.If anagram all the 256 elements count should be 0 else not anagram

 */
    public boolean inAnagramSecond(String firstString,String secondString)
    {
        int MAX_SIZE=256;
        if(firstString==null ||  secondString==null)
        {
            return false;
        }
        char[] firstChars = firstString.toLowerCase().replaceAll("\\s","").toCharArray();
        char[] secondChars = secondString.toLowerCase().replaceAll("\\s","").toCharArray();
        if(firstChars.length!=secondChars.length)
        {
            return false;
        }
        int[] compare =  new int[MAX_SIZE];

        for(int i=0;i<firstChars.length;i++)
        {
            int val =(int) firstChars[i];
            compare[val]++;

        }
        for(int i=0;i<secondChars.length;i++)
        {
            int val =(int) firstChars[i];
            compare[val]--;

        }

        for(int i=0;i<MAX_SIZE;i++)
        {
            if(compare[i]>0)
            {
                return false;
            }
        }
        return true;

    }
    public static void main(String args[])
    {
        Anagram anagram = new Anagram();
        String firstString = " Mother In Law";
        String secondString = "Hitler Woman";
        System.out.println("Are Anagrams::"+anagram.inAnagramSecond(firstString,secondString));

    }
}
