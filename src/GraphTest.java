import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

class GraphTest {

    @org.junit.jupiter.api.Test
    void addRelationship() {
    Graph graph = new Graph();

    graph.addNode("A");
    graph.addNode("B");
    graph.addNode("C");
    graph.addNode("D");

    graph.addRelationship("A", "B", 10);
    graph.addRelationship("B","C", 25);
    graph.addRelationship("D", "A",30);
    graph.addRelationship("B","D",50);
    assertEquals(graph.prueba(),25);

    }

    @org.junit.jupiter.api.Test
    void floydAlgorithm() {
        Graph graph1 = new Graph();

        graph1.addNode("A");
        graph1.addNode("B");
        graph1.addNode("C");
        graph1.addNode("D");

        graph1.addRelationship("A", "B", 10);
        graph1.addRelationship("B","C", 25);
        graph1.addRelationship("D", "A",30);
        graph1.addRelationship("B","D",50);
        graph1.floydAlgorithm();

        assertEquals(graph1.prueba(),0);


    }

    @org.junit.jupiter.api.Test
    void graphCenter() {
        Graph graph1 = new Graph();

        graph1.addNode("A");
        graph1.addNode("B");
        graph1.addNode("C");
        graph1.addNode("D");

        graph1.addRelationship("A", "B", 10);
        graph1.addRelationship("B","C", 25);
        graph1.addRelationship("D", "A",30);
        graph1.addRelationship("B","D",50);
        graph1.floydAlgorithm();
        graph1.graphCenter();
        assertEquals(graph1.graphCenter(),0);
    }
}