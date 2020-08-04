package com.demo;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    private int V;
    private int E;
    private Set<Integer>[]adj;
    public int V(){
        return this.V;
    }
    public int E(){
        return this.E;
    }

    public Graph(int V){
        this.V = V;
        E= 0;
        this.adj = new Set[V];
        for(int v=0;v<V;v++){
            adj[v] = new HashSet<>();
        }

    }

    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer>adj(int v) {
        return this.adj[v];
    }

    @Override
    public String toString() {
        StringBuilder sb  = new StringBuilder();
        for(int v = 0;v<this.V;v++){

            sb.append( v +" -> \n");
            sb.append("\t");
            for(int w : this.adj(v)) {
                sb.append(w +"\t");
            }
            sb.append("\n");
        }
        return sb.toString();

    }
}
