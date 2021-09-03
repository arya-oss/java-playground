package me.rajarya.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {
    public static void main(String[] args) {
        int N = 4;
        int[] start = {1, 3, 2, 5};
        int[] end = {2, 4, 3, 6};
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            pairs.add(new Pair(start[i], end[i]));
        }
        pairs.sort(Comparator.comparingInt(p -> p.end));
        int k = 0;
        int ans = 0;
        for (int i = 1; i < pairs.size(); i++) {
            if (pairs.get(i).start >= pairs.get(k).end) {
                i = k;
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static class Pair {
        int start;
        int end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
