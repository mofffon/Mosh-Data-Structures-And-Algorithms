package pl.lukaszjaskiewicz.graph;

import java.util.*;

public class Graph {

    private class Node{
        String label;

        public Node(String label){
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private final Map<String, Node> nodes = new HashMap<>();
    private final Map<Node, LinkedList<Node>> adjacencyList= new HashMap<>();

    public void addNode(String label){
        if(nodes.containsKey(label)){
            return;
        }

        Node newNode = new Node(label);
        nodes.putIfAbsent(label, newNode);
        adjacencyList.putIfAbsent(newNode, new LinkedList<>());
    }

    public void addEdge(String from, String to){

        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if(fromNode == null){
            throw new IllegalArgumentException("From node (" + from +") does not exist in the Graph");
        }

        if(toNode == null){
            throw new IllegalArgumentException("To node (" + to +") does not exist in the Graph");
        }

        if(!adjacencyList.get(fromNode).contains(toNode))
            adjacencyList.get(fromNode).add(toNode);
    }

    public void removeEdge(String from, String to){

        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if(fromNode == null){
            throw new IllegalArgumentException("From node (" + from +") does not exist in the Graph");
        }

        if(toNode == null){
            throw new IllegalArgumentException("To node (" + to +") does not exist in the Graph");
        }

        adjacencyList.get(fromNode).remove(toNode);
    }

    public void removeNode(String label) {
        Node node = nodes.get(label);
        if (node == null) {
            throw new IllegalArgumentException("Node (" + label + ") does not exist in Graph.");
        }

        for(LinkedList<Node> list : adjacencyList.values()){
            list.remove(node);
        }

        adjacencyList.remove(node);
        nodes.remove(label);
    }

    public String depthFirstTraversalRec(String label){
        Node node = nodes.get(label);

        if(node == null){
            return "[]";
        }

        List<Node> list = new ArrayList<>();
        depthFirstTraversalRec(node, new HashSet<>(), list);
        return Arrays.toString(list.toArray(new Node[0]));
    }

    private void depthFirstTraversalRec(Node node,  Set<Node> visited, List<Node> list){
        if(visited.contains(node)){
            return;
        }

        list.add(node);
        visited.add(node);

        for(var n: adjacencyList.get(node)){
            depthFirstTraversalRec(n, visited, list);
        }
    }

    public String depthFirstTraversalIterative(String label){
        Node node = nodes.get(label);
        if(node == null){
            return "[]";
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);
        Set<Node> visited = new HashSet<>();
        List<Node> list = new ArrayList<>();

        while(!stack.isEmpty()){
            Node current = stack.pop();
            if(!visited.contains(current)){
                list.add(current);
                visited.add(current);
                for(var n: adjacencyList.get(current)){
                    stack.push(n);
                }
            }
        }

        return Arrays.toString(list.toArray(new Node[0]));
    }

    public String breadthFirstTraversal(String label){
        Node node = nodes.get(label);
        if(node == null){
            return "[]";
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        Set<Node> visited = new HashSet<>();
        List<Node> list = new ArrayList<>();

        while(!queue.isEmpty()){
            var current = queue.remove();

            if(!visited.contains(current)){
                list.add(current);
                visited.add(current);

                queue.addAll(adjacencyList.get(current));
            }
        }

        return Arrays.toString(list.toArray(new Node[0]));
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        Node[] ns = nodes.values().toArray(new Node[0]);

        for(int i = 0; i < ns.length; i++){
            sb.append(ns[i]).append(" -> ").append(adjacencyList.get(ns[i])).append( i != ns.length - 1? "\n":"");
        }

        return sb.toString();
    }
}
