package Solutions.pack11_Graph;

import java.util.HashSet;
import java.util.PriorityQueue;

public class NetworkOptimizer {

    public int optimizeNetwork(int N, int M, int[][] input) {
        int totalLatency = 0;

        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i + 1);
        }

        for (int i = 0; i < input.length; i++) {
            int node1Id = input[i][0];
            int node2Id = input[i][1];
            int latency = input[i][2];
            Edge edge = new Edge(latency, nodes[node1Id - 1], nodes[node2Id - 1]);
            nodes[node1Id - 1].addEdge(edge);
            nodes[node2Id - 1].addEdge(edge);
        }


        PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> visited = new HashSet<>();

        Node starNode = nodes[0];
        visited.add(starNode);

        pq.addAll(starNode.edges);

        while (!pq.isEmpty()) {
            Edge edge = pq.poll(); 

            Node nextNode = edge.node2; 
            if (visited.contains(nextNode)) {
                nextNode = edge.node1; 
            }

            if (!visited.contains(nextNode)) {
                visited.add(nextNode);
                totalLatency += edge.latency; 

                for (Edge nextEdge : nextNode.edges) {
                    if (!visited.contains(nextEdge.node1) || !visited.contains(nextEdge.node2)) {
                        pq.add(nextEdge);
                    }
                }
            }
        }

        return totalLatency;
    }

    // Overload 
    public int optimizeNetwork(int N, int M, int T, int[][] input) {
        int totalLatency = 0;

        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i + 1);
        }

        for (int i = 0; i < input.length; i++) {
            int node1Id = input[i][0];
            int node2Id = input[i][1];
            int latency = input[i][2];
            int bandwidth = input[i][3];
            EdgeWithBandwidth edge = new EdgeWithBandwidth(latency, bandwidth, nodes[node1Id - 1], nodes[node2Id - 1]);
            nodes[node1Id - 1].addEdgeWithBandwidth(edge);
            nodes[node2Id - 1].addEdgeWithBandwidth(edge);
        }

        PriorityQueue<EdgeWithBandwidth> pq = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> visited = new HashSet<>();

        Node starNode = nodes[0];
        visited.add(starNode);

        for (EdgeWithBandwidth edge : starNode.edgesWithBandwidth) {
            if (edge.bandwidth >= T) {
                pq.add(edge);
            }
        }

        while (!pq.isEmpty()) {
            EdgeWithBandwidth edge = pq.poll(); 

            Node nextNode = edge.node2;
            if (visited.contains(nextNode)) {
                nextNode = edge.node1;
            }

            if (!visited.contains(nextNode) && edge.bandwidth >= T) {
                visited.add(nextNode);
                totalLatency += edge.latency;

                for (EdgeWithBandwidth nextEdge : nextNode.edgesWithBandwidth) {
                    if ((!visited.contains(nextEdge.node1) || !visited.contains(nextEdge.node2)) && nextEdge.bandwidth >= T) {
                        pq.add(nextEdge);
                    }
                }
            }
        }

        return totalLatency;
    }

}
