package array_impl;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File dir = new File("D://ProjectsJava//LabWork1_ASD//src//data"); 

        System.out.println("File                 Edges        Time              Iterations");

        for (File file : dir.listFiles()) {
            if (!file.isFile()) continue;

            List<Edge> edges = readEdges(file);
            Collections.sort(edges);
            KruskalAlgorithm.initDSU();

            long start = System.nanoTime();
            int mstWeight = runKruskal(edges);
            long time = (System.nanoTime() - start) / 1000;

            System.out.printf("%-20s | %-10d | %-15d | %-15d\n",
                    file.getName(),
                    edges.size(),
                    time,
                    KruskalAlgorithm.getIterationCount());
        }
    }

    private static List<Edge> readEdges(File file) throws IOException {
        List<Edge> edges = new ArrayList<>();
        for (String line : Files.readAllLines(file.toPath())) {
            String[] parts = line.trim().split("\\s+");
            if (parts.length == 3) {
                edges.add(new Edge(
                        Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2])
                ));
            }
        }
        return edges;
    }

    private static int runKruskal(List<Edge> edges) {
        int mstWeight = 0;
        for (Edge e : edges) {
            if (KruskalAlgorithm.merge(e.a, e.b)) {
                mstWeight += e.len;
            }
        }
        return mstWeight;
    }
}