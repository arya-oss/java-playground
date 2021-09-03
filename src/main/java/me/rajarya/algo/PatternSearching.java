package me.rajarya.algo;

public class PatternSearching {
    public boolean checkPattern(String pattern, String text) {
        boolean flag = false;
        int[] lps = buildLPSArray(pattern);
        int i = 0, j = 0;
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++; j++;
            }
            if (j == pattern.length()) {
                flag = true;
                j = lps[j-1];
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return flag;
    }

    private int[] buildLPSArray(String text) {
        int[] lps = new int[text.length()];
        int len = 0;
        lps[0] = 0;
        int it = 1;
        while (it < text.length()) {
            if (text.charAt(it) == text.charAt(len)) {
                lps[it] = lps[it-1] + 1;
                it++;
                len++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[it++] = 0;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String text = "java datatypes are int, bool, double, float, long";
        String pattern = "bool";
        PatternSearching ps = new PatternSearching();
        System.out.println(ps.checkPattern(pattern, text));
    }
}
