package com.Github.Ikhideifidon;

public class Main {
    public static void main(String[] args) {
        quickFind();
    }
    public static void quickFind() {
        int N = 10;
        int[][] links =
                {
                        {4, 3}, {3, 8}, {6, 5}, {9, 4}, {2, 1}, {8, 9},
                        {5, 0}, {7, 2}, {6, 1}
                };
        WeightedQuickUnionWithPathCompression qf = new WeightedQuickUnionWithPathCompression(N);
        for (int[] link : links)
            qf.union(link[0], link[1]);
        System.out.println(qf.isConnected(-4, 7));
        System.out.println(qf.count());
    }


}