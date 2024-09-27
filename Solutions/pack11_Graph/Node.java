package Solutions.pack11_Graph;

import java.util.ArrayList;

public class Node {
    private int id;
    public ArrayList<Edge> edges;
    public ArrayList<EdgeWithBandwidth> edgesWithBandwidth;

    public Node(int id) {
        this.id = id;
        this.edges = new ArrayList<>();
        this.edgesWithBandwidth = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public void addEdgeWithBandwidth(EdgeWithBandwidth edge) {
        edgesWithBandwidth.add(edge);
    }

    public int getId() {
        return id;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public ArrayList<EdgeWithBandwidth> getEdgesWithBandwidth() {
        return edgesWithBandwidth;
    }

    @Override
    public String toString() {
        return "Node "+ id;
    }
}