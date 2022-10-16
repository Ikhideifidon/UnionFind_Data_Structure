package com.Github.Ikhideifidon;

import java.util.Arrays;

public class QuickFind {
    // Instance Variables
    private final int[] id;                     // Component id
    private int connectedComponents;

    public QuickFind(int N) {
        if (N <= 0)
            throw new IllegalArgumentException("Number of sites cannot be less than or equal to zero.");
        connectedComponents = N;
        id = new int[N];
        // Make every site connect to itself
        for (int i = 0; i < N; i++)
            id[i] = i;

    }

    public int find(int p) {
        check(p);
        return id[p];
    }

    public void union(int p, int q) {
        // This union operation renames p.
        check(p);
        check(q);
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == p)
                id[i] = qRoot;
        }
        connectedComponents--;
    }

    public boolean isConnected(int p, int q) {
        System.out.println(Arrays.toString(id));
        check(p);
        check(q);
        return find(p) == find(q);
    }

    public int count() {
        return connectedComponents;
    }

    private void check(int v) {
        if (v < 0 || v >= id.length) {
            if (v < 0)
                throw new IllegalArgumentException(v + " cannot be less than zero.");
            else
                throw new ArrayIndexOutOfBoundsException(v + " cannot be equal to or greater than " + id.length);
        }
    }
}
