package com.g.ds.trivial;

public class FirstNonRepeatedCharacter {

    public char firstNonRepetedCharacter(String str)
    {
        int MAX_SIZE=256;
        int[] countArray = new int[MAX_SIZE];
        int[] posArray = new int[MAX_SIZE];
        int finalPosition=MAX_SIZE;
        int tempPosition=0;
        char finalChar=0;


        int charInt=0;
        for(int i=0;i<str.length();i++)
        {
            charInt = (int)str.charAt(i);
            if(countArray[charInt]==0)
            {

                posArray[charInt]=i;
            }

            countArray[charInt]++;

        }
        int temp=MAX_SIZE;
        for(int i=0;i<countArray.length;i++)
        {
            if(countArray[i]==1)
            {
                tempPosition = posArray[i];
                if(finalPosition>tempPosition)
                {
                    finalPosition=tempPosition;
                    finalChar=(char)i;
                }
            }
        }
        return finalChar;
    }
    public static void main(String args[])
    {
        String str ="aplae";
        FirstNonRepeatedCharacter nonRepeatedCharacter = new FirstNonRepeatedCharacter();
        System.out.println(nonRepeatedCharacter.firstNonRepetedCharacter(str));
    }
}
