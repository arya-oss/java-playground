package me.rajarya.ds.stack;

import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        String input = "{}[]([{}])";
        boolean isBalanced = solve(input);
        System.out.println(isBalanced);
    }

    private static boolean solve(String input) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '{' || input.charAt(i) == '(' || input.charAt(i) == '[') {
                st.push(input.charAt(i));
            } else {
                if (st.isEmpty()) return false;
                char top = st.peek();
                if (input.charAt(i) == '}' && top != '{') return false;
                if (input.charAt(i) == ')' && top != '(') return false;
                if (input.charAt(i) == ']' && top != '[') return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
