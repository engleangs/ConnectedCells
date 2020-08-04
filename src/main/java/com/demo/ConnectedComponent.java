package com.demo;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponent {
    private boolean marked[];
    private int [] id;
    private int count;
    private List<List<Integer>> connectedPath = new ArrayList<>();
    public ConnectedComponent(Graph G){
        marked = new boolean[ G.V()];
        id = new int[G.V()];
        for(int v=0;v < G.V(); v++){
            if( !marked[ v ]) {
                dfs(G,v);
                count++;
            }
        }
    }

    private void addVertex(int count, int v){
        if( connectedPath.size() < count+1) {
            connectedPath.add(new ArrayList<>());
        }
         connectedPath.get( count).add( v);
    }

    private void dfs(Graph G, int v){
        id[v] = count;
        addVertex(count,v);
        marked[v] = true;
        for( int w : G.adj(v)){
            if( !marked[ w]) {
                dfs(G,w);
            }
        }
    }
    private int count(){
        return count;
    }
    private int id(int v){
        return this.id[v];
    }
    public List<List<Integer>>connectedPath(){
        return this.connectedPath;
    }

}
