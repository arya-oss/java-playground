package me.rajarya.algo.recursion;

public class TowerOfHanoi {

    public static void solve(int n, char fromPeg, char toPeg, char auxPeg) {
        if (n == 1) {
            System.out.println(String.format("Move disk 1 from %c to %c", fromPeg, toPeg));
        } else {
            solve(n-1, fromPeg, auxPeg, toPeg);
            System.out.println(String.format("Move disk %d from %c to %c", n, auxPeg, fromPeg));
            solve(n-1, auxPeg, toPeg, fromPeg);
        }
    }

    public static void main(String[] args) {
        solve(3, 'A', 'C', 'B');
    }
}
