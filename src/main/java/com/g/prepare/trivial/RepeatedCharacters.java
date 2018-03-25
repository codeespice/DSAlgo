package com.g.prepare.trivial;

public class RepeatedCharacters {

    int MAX_SIZE =256;
    int finalPos=MAX_SIZE;
    int tempPos=0;
    char finalchar=0;
    public void repeatedCharactersinString(String repeatedString)
    {

        int[] hash =new int[MAX_SIZE];
        int[] pos = new int[MAX_SIZE];


        for(int i=0;i<repeatedString.length();i++)
        {
            int code = (int)repeatedString.charAt(i);
            if(hash[code]==0)
            {
                hash[code]++;
                pos[code]=i;
            }
            else
            {
                hash[code]++;
                System.out.println("found repeated char::"+(char)101);
            }

        }

        for(int i=0;i<MAX_SIZE;i++)
        {
            if(hash[i]>1)
            {
                tempPos= pos[i];
                if(finalPos>tempPos)
                {
                    finalchar =(char) i;
                    finalPos=tempPos;
                }
            }
        }

        System.out.println("Final Char :"+finalchar+ " final Psoition:"+finalPos);

    }

    public static void main(String args[])
    {
        String str = "geeksforgeeks";
        RepeatedCharacters rs = new RepeatedCharacters();
       rs.repeatedCharactersinString(str);

    }



}
