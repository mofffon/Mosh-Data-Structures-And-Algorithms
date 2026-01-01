package pl.lukaszjaskiewicz.weightedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Path {
    private List<String> nodes = new ArrayList<>();

    public void add(String node){
        nodes.add(node);
    }

    @Override
    public String toString(){
        return nodes.toString();
    }
}
