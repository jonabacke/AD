package ab_09_1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {
    private int name;
    
    private List<Node> shortestPath = new LinkedList<>();
     
    private Integer distance = Integer.MAX_VALUE;
     
    Map<Node, Integer> adjacentNodes = new HashMap<>();
 
    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }
  
    public Node(int name) {
        this.name = name;
    }
     
    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}
    
    public void setDistance(Integer distance) {
		this.distance = distance;
	}
    
    public void setName(int name) {
		this.name = name;
	}
    
    public void setShortestPath(List<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}
    
    public Map<Node, Integer> getAdjacentNodes() {
		return adjacentNodes;
	}
    
    public Integer getDistance() {
		return distance;
	}
    
    public int getName() {
		return name;
	}
    
    public List<Node> getShortestPath() {
		return shortestPath;
	}
}
