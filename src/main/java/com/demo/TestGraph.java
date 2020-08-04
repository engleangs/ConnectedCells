package com.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.demo.RectangleUtil.shouldConnected;

public class TestGraph {
    public static int[] toCoordinate(int x, int[][] rect) {
        int i = x / rect.length;
        int j = x % (rect.length);
        int[] c = {i, j};
        return c;
    }

    public static int toIndex(int i, int j, int[][] rect) {
        return i * rect.length + j;
    }

    private static void addVertex(int[][] rect, int i, int j, int k, int l, List<Integer> vertices) {
        if (shouldConnected(rect, i, j, k, l)) {
            vertices.add(toIndex(k, l, rect));
        }
    }


    public static List<Integer> connectedVertices(int[][] rect, int i, int j) {
        List<Integer> vertices = new ArrayList<>();
        if (i > 0) {
            int top = i - 1;
            addVertex(rect, i, j, top, j, vertices);
        }
        if (i < rect.length - 1) {
            int bottom = i + 1;
            addVertex(rect, i, j, bottom, j, vertices);
        }
        if (j > 0) {
            int left = j - 1;
            addVertex(rect, i, j, i, left, vertices);
        }
        return vertices;
    }

    public static void main(String[] arg) {
        int[][] rect = {
                {
                        0, 0, 1, 1, 0
                },
                {
                        0, 0, 1, 0, 1
                },
                {
                        1, 0, 1, 1, 1
                },
                {
                        1, 0, 1, 1, 0
                },
                {
                        1, 0, 1, 1, 0
                }
        };
        System.out.println("origin rectangle :");
        RectangleUtil.print(rect);
        int vertext = rect.length * rect[0].length;
        Graph graph = new Graph(vertext);
        for (int i = 0; i < rect.length; i++) {
            for (int j = 0; j < rect[i].length; j++) {
                int v = toIndex(i, j, rect);
                List<Integer> vertices = connectedVertices(rect, i, j);
                for (int w : vertices) {
                    graph.addEdge(v, w);
                }
            }
        }
//        System.out.println("transformed graph :");
//        System.out.println(graph);
        ConnectedComponent cc = new ConnectedComponent(graph);
        List<List<Integer>> path = cc.connectedPath();
        Collections.sort(path, (o1, o2) -> {
            Integer s1 = o1.size();
            Integer s2 = o2.size();
            return s2.compareTo(s1);
        });

        List<Integer> greatestConnected = path.get(0);
        System.out.println("max connected length " + greatestConnected.size());
        int[][] copy = new int[rect.length][rect[0].length];
        for (int v : greatestConnected) {
            int[] c = toCoordinate(v, rect);
            int i = c[0], j = c[1];
            copy[i][j] = 1;
        }
        System.out.println("connected only rectangle :");
        RectangleUtil.print(copy);
    }
}
