package com.Github.Ikhideifidon;

public class WeightedQuickUnionWithPathCompression {
    // Instance Variables
    private final int[] id;
    private final int[] size;                       // Size of component for roots
    private int connectedComponents;

    public WeightedQuickUnionWithPathCompression(int N) {
        if (N <= 0)
            throw new IllegalArgumentException("Number of sites cannot be less than or equal to zero.");
        connectedComponents = N;
        id = new int[N];
        size = new int[N];
        // Make all sites connect to itself
        // Initialize all sites in size to be 1
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        check(p);
        int root = p;
        while (root != id[root])
            root = id[root];

        while (p != root) {
            // Connect all the sites on the path of p to the root directly to the root.
            int next = id[p];
            id[p] = root;
            p = next;
        }

        return  root;
    }

    public void union(int p, int q) {
        check(p);
        check(q);
        int i = find(p);
        int j = find(q);
        if (i == j)
            return;

        // Make smaller root point to the larger one.
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
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

    // The size of the component p belongs to
    public int sizeOfComponent(int p) {
        check(p);
        return size[find(p)];
    }

    private void check(int v) {
        if (v < 0 || v >= id.length) {
            if (v < 0)
                throw new IllegalArgumentException("'v' cannot be less than zero.");
            else
                throw new ArrayIndexOutOfBoundsException(v + " cannot be equal to or greater than " + id.length);
        }
    }
}
