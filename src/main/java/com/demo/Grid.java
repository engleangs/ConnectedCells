package com.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grid {
    private int rect[][];
    private Cell cells[][];
    private List<Set<Cell>>allPath = new ArrayList<>();
    public Grid(int[][]rect){
        this.rect  = rect;
        this.cells = new Cell[rect.length][rect[0].length];
        traverseAndConnectTree();
    }

    public Set<Cell>connectedCells(int i,int j,Set<Cell>originConnection){
        if( i > 0){
            int top = i-1;
            originConnection = addConnected(i,j,top,j, originConnection);
        }
        if( i < rect.length -1){
            int bottom = i+1;
            originConnection =addConnected(i,j,bottom,j,originConnection);
        }
        if( j > 0){
            int left = j -1;
            originConnection =addConnected(i,j,i,left,originConnection);
        }
        if( j < rect[0].length -1){
            int right  = j +1;
           originConnection = addConnected(i,j, i, right,originConnection);
        }
        return originConnection;
    }
    private Set<Cell> addConnected(int i,int j,int k,int l,Set<Cell>con){
        Cell current = cells[i][j];
        Cell cell = connectedCell(i,j,k,l);
        if( cell !=null){
            if( cell.getConnection() !=null) {
                cell.getConnection().addAll(con);
                return cell.getConnection();
            }
            else {
                con.add(current);
                cell.setConnection(con);
                return con;
            }
        }
        return con;
    }
    public Cell connectedCell(int i,int j, int k,int l){
        if( RectangleUtil.shouldConnected(rect,i,j,k,l)) {
            return cells[k][l];
        }
        return null;
    }
    private void traverseAndConnectTree(){
        for(int i =0;i< rect.length;i++){
            for(int j=0;j<rect[i].length;j++){
                Cell cell = new Cell(i,j,rect[i][j]);
                this.cells[i][j] =cell;
                Set<Cell> connection = new HashSet<>();
                connection.add( cell);
                Set<Cell>newConnection = connectedCells(i,j,connection);
                cell.setConnection( newConnection);
                if( newConnection == connection){
                    allPath.add(connection);
                }
            }
        }
    }

    public List<Set<Cell>> getAllPath() {
        return allPath;
    }
}
