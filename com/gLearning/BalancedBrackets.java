package com.gLearning;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBrackets {

    // function to check if brackets are balanced
    static boolean BalancedBrackets(String expr)
    {
        Deque<Character> stack
                = new ArrayDeque<Character>();

        for (int i = 0; i < expr.length(); i++)
        {
            char ch = expr.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
            {

                stack.push(ch);
                continue;
            }
            if (stack.isEmpty())
                return false;
            char check;
            switch (ch) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }


        return (stack.isEmpty());
    }

    public static void main(String[] args)
    {
        String str = "[[{}]]";

        if (BalancedBrackets(str))
            System.out.println("The entered String has Balanced Brackets ");
        else
            System.out.println("The entered Strings do not contain Balanced Brackets");
    }
}
