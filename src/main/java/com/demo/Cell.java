package com.demo;

import java.util.Set;

public class Cell {

    private int i;
    private int j;
    private int val;
    private Set<Cell>connection;

    public Cell(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }
    public int i(){
        return this.i;
    }
    public int j(){
        return this.j;
    }
    public int value(){
        return this.val;
    }

    public Set<Cell> getConnection() {
        return connection;
    }

    public void setConnection(Set<Cell> connection) {
        this.connection = connection;
    }
}
