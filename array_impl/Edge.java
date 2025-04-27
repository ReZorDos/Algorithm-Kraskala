package array_impl;

public class Edge implements Comparable<Edge> {
    public int a, b, len;

    public Edge(int a, int b, int len) {
        this.a = a;
        this.b = b;
        this.len = len;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.len, other.len);
    }
}









