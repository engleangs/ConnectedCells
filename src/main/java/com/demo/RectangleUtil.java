package com.demo;

public class RectangleUtil {
    public static void print(int[][]rect){
        for(int i =0;i<rect.length;i++){
            for(int j=0;j<rect[i].length;j++){
                System.out.print(rect[i][j]+ "\t");
            }
            System.out.println();
        }
    }
    public static boolean shouldConnected(int[][] rect, int i, int j, int k, int l) {
        return rect[i][j] == rect[k][l] && rect[i][j]==1;
    }
}
