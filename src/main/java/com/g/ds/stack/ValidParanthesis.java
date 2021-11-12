package com.g.ds.stack;

import java.util.HashMap;
import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
 */
public class ValidParanthesis {

    public boolean isValid(String s) {

        Stack<Character> validator = new Stack<Character>();
        HashMap<Character,Character> characterHashMap = new HashMap<>();
        characterHashMap.put('(',')');
        characterHashMap.put('[', ']');
        characterHashMap.put('{', '}');
        for(int i=0;i<s.length();i++){
            Character c = validator.isEmpty()? 0 : validator.peek();
            if(!validator.isEmpty()  && characterHashMap.get(c)!=null && s.charAt(i)== characterHashMap.get(c)){
                    validator.pop();
            }else
            {
                validator.push(s.charAt(i));
            }

        }

        return validator.isEmpty();

    }

    public static void main(String args[]){
       String s =  "()[]{}";
        ValidParanthesis vp = new ValidParanthesis();
      boolean result =   vp.isValid(s);
      System.out.println("result is :"+result);

        s = "{[]}";
         result =   vp.isValid(s);
        System.out.println("Second result is :"+result);

        s = "([)]";
        result =   vp.isValid(s);
        System.out.println("Third result is :"+result);

    }
}
