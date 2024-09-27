package Solutions.pack11_Graph;


public class EdgeWithBandwidth extends Edge {
    int latency;
    int bandwidth;
    Node node1;
    Node node2;

    public EdgeWithBandwidth(int latency, int bandwidth, Node node1, Node node2) {
        super(latency, node1, node2);
        this.latency = latency;   
        this.bandwidth = bandwidth; 
        this.node1 = node1; 
        this.node2 = node2;
    }
}