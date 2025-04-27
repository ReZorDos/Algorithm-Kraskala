package array_impl;

public class KruskalAlgorithm {
    private static final int MAX_SIZE = 100000;
    private static int[] p = new int[MAX_SIZE];
    private static int[] rk = new int[MAX_SIZE];
    private static int iterationCount;

    public static void initDSU() {
        for (int i = 0; i < MAX_SIZE; i++) {
            p[i] = i;
            rk[i] = 1;
        }
        iterationCount = 0;
    }

    public static int getRoot(int v) {
        iterationCount++;
        return (p[v] == v) ? v : (p[v] = getRoot(p[v]));
    }

    public static boolean merge(int a, int b) {
        iterationCount++;
        int ra = getRoot(a), rb = getRoot(b);
        if (ra == rb) return false;

        if (rk[ra] < rk[rb]) {
            p[ra] = rb;
        } else if (rk[rb] < rk[ra]) {
            p[rb] = ra;
        } else {
            p[ra] = rb; rk[rb]++;
        }
        return true;
    }

    public static int getIterationCount() {
        return iterationCount;
    }
}

