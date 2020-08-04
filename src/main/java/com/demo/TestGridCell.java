package com.demo;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class TestGridCell {
    public static void main(String[] args) {
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
        Grid grid = new Grid(rect);
        List<Set<Cell>> paths = grid.getAllPath();
        Collections.sort(paths, (o1, o2) -> {
            Integer s1 = o1.size();
            Integer s2 = o2.size();
            return s2.compareTo(s1);
        });
        Set<Cell> path = paths.get(0);
        System.out.println("max connected length : " + path.size() + "");
        int[][]copy = new int[rect.length][rect[0].length];
        for(Cell cell:path){
            copy[cell.i()][cell.j()] = 1;
        }
        System.out.println("connected only rectangle :");
        RectangleUtil.print(copy);


    }
}
