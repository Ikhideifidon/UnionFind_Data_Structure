package com.Github.Ikhideifidon;

public class QuickUnion {
    // Instance Variables
    private final int[] id;
    private int connectedComponents;

    public QuickUnion(int N) {
        if (N <= 0)
            throw new IllegalArgumentException("Number of sites cannot be less than or equal to zero.");
        id = new int[N];
        connectedComponents = N;
        // Connect each site to itself.
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int find(int p) {
        check(p);
        while(p != id[p])
            p = id[p];
        return p;
    }

    public void union(int p, int q) {
        // This union implementation renames p.
        check(p);
        check(q);
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;

        id[pRoot] = qRoot;
        connectedComponents--;
    }

    public boolean isConnected(int p, int q) {
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
                throw new IllegalArgumentException(v + " cannot be less tha zero.");
            else
                throw new ArrayIndexOutOfBoundsException(v + " cannot be equal to or greater than " + id.length);
        }
    }
}
