package ab_09_1;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	
    private Set<Node> nodes = new HashSet<Node>();
    
    public void addNode(Node node) {
        nodes.add(node);
    }
 
    public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}
    
    public Set<Node> getNodes() {
		return nodes;
	}
}
