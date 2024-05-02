package com.g.ds.facebook.string;

public class RotationalCIpher {
    public RotationalCIpher(){

    }
    String rotationalCipher(String input, int rotationFactor) {
        int ordA = 'A';
        int orda = 'a';
        StringBuffer buffer = new StringBuffer();
        char[] charArray = input.toCharArray();
        char[] newCharArray = new char[charArray.length-1];
        for(char c : charArray){
            if (Character.isAlphabetic(c)){
                if(Character.isUpperCase(c)){
                   int temp = (c-ordA+rotationFactor)%26;
                   buffer.append((char)(ordA+temp));
                }
                else if (Character.isLowerCase(c)){
                    int temp = (c-orda+rotationFactor)%26;
                    buffer.append((char)(orda+temp));
                }
            }
            else if (Character.isDigit(c)){
               buffer.append ((Character.getNumericValue(c)+rotationFactor)%10);
            }
            else {
                buffer.append(c);
            }

        }

        // Write your code here
        return buffer.toString();
    }

    public static void main(String args[]){
        String s ="demime";
        RotationalCIpher cipher = new RotationalCIpher();
      String result =  cipher.rotationalCipher(s,3);
      System.out.println(result);
    }
}
