package me.rajarya.algo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfStreams {

    private PriorityQueue<Integer> lPQ;
    private PriorityQueue<Integer> rPQ;
    private double m;

    private int signum(int x, int y) {
        if (x == y) return 0;
        if (x < y) return -1;
        return 1;
    }

    public MedianOfStreams() {
        lPQ = new PriorityQueue<>(Comparator.reverseOrder());
        rPQ = new PriorityQueue<>();
        m = 0.0;
    }

    public void addNum(int num) {
        int sg = signum(lPQ.size(), rPQ.size());
        if (sg == 1) {
            if (num < m) {
                rPQ.add(lPQ.poll());
                lPQ.add(num);
            } else {
                rPQ.add(num);
            }
            m = ((double) (lPQ.peek() + rPQ.peek()))/2;
        } else if (sg == 0) {
            if (num < m) {
                lPQ.add(num);
                m = lPQ.peek();
            } else {
                rPQ.add(num);
                m = rPQ.peek();
            }
        } else {
            if (num < m) {
                lPQ.add(num);
            } else {
                lPQ.add(rPQ.poll());
                rPQ.add(num);
            }
            m = ((double) (lPQ.peek() + rPQ.peek()))/2;
        }
    }

    public double getMedian() {
        return m;
    }
}
