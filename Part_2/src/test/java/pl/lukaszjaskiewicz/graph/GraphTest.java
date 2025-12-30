package pl.lukaszjaskiewicz.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    Graph graph;

    @BeforeEach
    void setUp(){
        graph = new Graph();
    }

    @Test
    void addNode_whenCalled_shouldAddNode() {

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        assertEquals("A -> []\nB -> []\nC -> []\nD -> []", graph.toString());
    }

    @Test
    void addEdge_whenCalledWithNonPresentLabel_shouldThrowIllegalArgumentException(){
        graph.addNode("A");
        graph.addNode("B");

        assertThrows(IllegalArgumentException.class, () -> graph.addEdge("A", "D"));
        assertThrows(IllegalArgumentException.class, () -> graph.addEdge("D", "B"));
    }

    @Test
    void addEdge_whenCalledWithLabelsPresentInGraph_shouldAddEdges() {

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");

        graph.addEdge("B", "A");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");

        graph.addEdge("C", "A");
        graph.addEdge("C", "B");
        graph.addEdge("C", "D");

        assertEquals("A -> [B, C, D]\nB -> [A, C, D]\nC -> [A, B, D]\nD -> []", graph.toString());

    }

    @Test
    void removeEdge_whenCalledOnGraphWithNonContainingLabels_shouldThrowIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> graph.removeEdge("A","B"));
    }

    @Test
    void removeEdge_whenCalledOnGraphWithContainingLabels_shouldRemoveNodes() {
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");

        graph.addEdge("B", "A");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");

        graph.addEdge("C", "A");
        graph.addEdge("C", "B");
        graph.addEdge("C", "D");

        graph.addEdge("D", "A");
        graph.addEdge("D", "B");
        graph.addEdge("D", "C");

        graph.removeEdge("A", "C");
        graph.removeEdge("B", "C");
        graph.removeEdge("D", "C");

        assertEquals("A -> [B, D]\nB -> [A, D]\nC -> [A, B, D]\nD -> [A, B]", graph.toString());
    }

    @Test
    void removeNode_whenCalledOnGraphNonContainingNodes_shouldThrowIllegalArgumentException(){
        graph.addNode("A");
        graph.addNode("B");

        graph.addEdge("A", "B");
        graph.addEdge("B", "A");

        assertThrows(IllegalArgumentException.class, () -> graph.removeNode("C"));
    }

    @Test
    void removeNode_whenCalledOnGraphContainingNodes_shouldRemoveNode() {

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");

        graph.addEdge("B", "A");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");

        graph.addEdge("C", "A");
        graph.addEdge("C", "B");
        graph.addEdge("C", "D");

        graph.addEdge("D", "A");
        graph.addEdge("D", "B");
        graph.addEdge("D", "C");

        graph.removeNode("A");
        graph.removeNode("D");

        assertEquals("B -> [C]\nC -> [B]", graph.toString());
    }

    @Test
    void depthFirstTraversalRec_whenCalled_shouldReturnStringWithItemsInOrder(){
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");

        assertEquals("[A, B, D, C]", graph.depthFirstTraversalRec("A"));
    }

    @Test
    void depthFirstTraversalIterative_whenCalled_shouldReturnStringWithItemsInOrder(){
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");

        assertEquals("[A, C, B, D]", graph.depthFirstTraversalIterative("A"));
    }

    @Test
    void breadthFirstTraversal_whenCalled_shouldReturnStringWithItemsInOrder(){
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");

        assertEquals("[A, B, C, D]", graph.breadthFirstTraversal("A"));
    }

}