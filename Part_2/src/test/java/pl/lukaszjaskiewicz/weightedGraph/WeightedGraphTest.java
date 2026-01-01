package pl.lukaszjaskiewicz.weightedGraph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class WeightedGraphTest {

    WeightedGraph graph;

    @BeforeEach
    void setUp(){
        graph = new WeightedGraph();
    }

    @Test
    void addNode_whenCalled_addsNodeToTheGraph() {

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        assertEquals("A connected to: []\nB connected to: []\nC connected to: []", graph.toString());
    }

    @Test
    void addEdge_whenCalled_addsEdgeToTheGraph() {

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 10);
        graph.addEdge("C", "B", 5);

        assertEquals("A connected to: [A -> B (3), A -> C (10)]\nB connected to: [B -> A (3), B -> C (5)]\nC connected to: [C -> A (10), C -> B (5)]", graph.toString());
    }

    @Test
    void getShortestPath_whenCalledOnTwoConnectedNodes_shouldFindTheShortestPath(){
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "D", 2);
        graph.addEdge("A", "C", 4);
        graph.addEdge("B", "E", 1);
        graph.addEdge("D", "E", 5);

        assertEquals("[A, B, E]", graph.getShortestPath("A", "E").toString());
    }
}