package pl.lukaszjaskiewicz.weightedGraph;

import java.util.*;

public class WeightedGraph {

    private static class Node{
        String value;
        private final List<Edge> edges = new ArrayList<>();

        public Node(String value){
            this.value = value;
        }

        public void addEdge(Node to, int weight){
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges(){
            return edges;
        }

        @Override
        public String toString(){
            return value;
        }
    }

    private class NodeEntry {
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    private static class Edge{
        Node from;
        Node to;
        int weight;

        public Edge(Node from, Node to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString(){
            return from + " -> " + to + " (" + weight +")";
        }
    }

    private final Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label){
        if(nodes.containsKey(label)){
            return;
        }

        nodes.put(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight){

        Node fromNode = nodes.get(from);
        if(fromNode == null){
            return;
        }

        Node toNode = nodes.get(to);
        if(toNode == null){
            return;
        }

        List<Edge> fromEdges = fromNode.edges;
        List<Edge> toEdges = toNode.edges;

        var filteredFromEdges = fromEdges.stream().filter(edge -> edge.from == fromNode && edge.to == toNode).findAny().orElse(null);
        if(filteredFromEdges != null){
            return;
        }

        var filteredToEdges = toEdges.stream().filter(edge -> edge.from == toNode && edge.to == fromNode).findAny().orElse(null);
        if(filteredToEdges != null){
            return;
        }

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public boolean contains(String label){
        for(var key: nodes.keySet()){
            if(label.equals(key)){
                return true;
            }
        }

        return false;
    }

    public Path getShortestPath(String from, String to){
        Node fromNode = nodes.get(from);
        if (fromNode == null){
           throw new IllegalArgumentException("Node (" + from + ") does not exist in the graph.");
        }

        Node toNode = nodes.get(to);
        if(toNode == null){
            throw new IllegalArgumentException("Node (" + to + ") does not exist in the graph.");
        }

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));

        Map<Node, Integer> distances = new HashMap<>();

        for(var node: nodes.values()){
            distances.put(node, Integer.MAX_VALUE);
        }

        distances.replace(nodes.get(fromNode), 0);

        Set<Node> visited = new HashSet<>();

        Map<Node, Node> previous = new HashMap<>();

        queue.add(new NodeEntry(fromNode, 0));

        while(!queue.isEmpty()){
            var current = queue.remove().node;
            visited.add(current);

            for(var edge: current.getEdges()){
                if(!visited.contains(edge.to)){
                    var newDistance = distances.get(current) + edge.weight;
                    if(newDistance < distances.get(edge.to)){
                        distances.replace(edge.to, newDistance);
                        queue.add(new NodeEntry(edge.to, newDistance));
                        previous.put(edge.to, current);
                    }
                }
            }
        }

        Stack<Node> stack = new Stack<>();
        stack.push(toNode);

        var previousNode = previous.get(toNode);
        while(previousNode != null){
            stack.push(previousNode);
            previousNode = previous.get(previousNode);
        }

        var path = new Path();
        while(!stack.isEmpty()){
            path.add(stack.pop().value);
        }

        return path;
    }

    public boolean hasCycle(){
        Set<Node> visited = new HashSet<>();

        for(var node: nodes.values()){
            if(!visited.contains(node) && hasCycle(node, null, visited)){
                return true;
            }
        }

        return false;
    }

    private boolean hasCycle(Node root, Node parent, Set<Node> visited){
        visited.add(root);

        for(var edge: root.getEdges()){
            Node node = edge.to;

            if(node == parent){
                continue;
            }

            if(visited.contains(node) || hasCycle(node, root, visited)){
                return true;
            }
        }

        return false;
    }

    public WeightedGraph getMinimumSpanningTree(){

        if(nodes.isEmpty()){
            return new WeightedGraph();
        }

        WeightedGraph graph = new WeightedGraph();

        Set<Node> all = new HashSet<>(nodes.values());

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        Node root = nodes.values().iterator().next();
        queue.addAll(root.getEdges());

        if(queue.isEmpty()){
            return graph;
        }

        graph.addNode(root.value);
        all.remove(root);

        while(!all.isEmpty()){

            Edge edge = queue.remove();

            while(graph.contains(edge.to.value)){
                edge = queue.remove();
            }

            var nextNode = edge.to;

            graph.addNode(nextNode.value);
            graph.addEdge(root.value, nextNode.value, edge.weight);

            all.remove(nextNode);
            root = nextNode;

            queue.addAll(root.getEdges());

        }

        return graph;
    }

    @Override
    public String toString(){
        if(nodes.isEmpty()){
            return "[]";
        }

        StringBuilder sb = new StringBuilder();

        int counter = 0;

        for(Node node: nodes.values()){
            List<Edge> connectedTo = node.getEdges();
            sb.append(node.toString()).append(" connected to: ").append(connectedTo);
            counter++;
            if(counter < nodes.size()){
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
