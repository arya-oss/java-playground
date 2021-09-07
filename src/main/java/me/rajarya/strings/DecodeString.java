package me.rajarya.strings;

import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/
 */
public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String expectedOutput = "accaccacc";
        try {
            String output = solve(s);
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String solve(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int len = s.length();
        int i = 0;
        while (i < len) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder freqS = new StringBuilder();
                while (Character.isDigit(s.charAt(i))) {
                    freqS.append(s.charAt(i++));
                }
                st.push(s.charAt(i++)); // push '['
                StringBuilder newS = new StringBuilder();
                newS.append('[');
                while (!st.isEmpty() && i < len) {
                    if (s.charAt(i) == '[') st.push(s.charAt(i));
                    else if (s.charAt(i) == ']') {
                        st.pop();
                    }
                    newS.append(s.charAt(i));
                    i++;
                }
                String word = solve(newS.toString());
                for (int j = 0; j < Integer.parseInt(freqS.toString()); j++) {
                    ans.append(word);
                }
                continue;
            } else if (c != '[' && c != ']') {
                ans.append(c);
            }
            i++;
        }
        return ans.toString();
    }
}
