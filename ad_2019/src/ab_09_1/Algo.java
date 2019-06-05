package ab_09_1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Map.Entry;
import java.util.Set;

public class Algo {
	public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
	    source.setDistance(0);
	 
	    Set<Node> settledNodes = new HashSet<>();
	    Set<Node> unsettledNodes = new HashSet<>();
	 
	    unsettledNodes.add(source);
	 
	    while (unsettledNodes.size() != 0) {
	        Node currentNode = getLowestDistanceNode(unsettledNodes);
	        unsettledNodes.remove(currentNode);
	        for (Entry < Node, Integer> adjacencyPair: 
	          currentNode.getAdjacentNodes().entrySet()) {
	            Node adjacentNode = adjacencyPair.getKey();
	            Integer edgeWeight = adjacencyPair.getValue();
	            if (!settledNodes.contains(adjacentNode)) {
	                calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
	                unsettledNodes.add(adjacentNode);
	            }
	        }
	        settledNodes.add(currentNode);
	    }
	    return graph;
	}
	private static void calculateMinimumDistance(Node evaluationNode,
			  Integer edgeWeigh, Node sourceNode) {
			    Integer sourceDistance = sourceNode.getDistance();
			    if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
			        evaluationNode.setDistance(sourceDistance + edgeWeigh);
			        LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
			        shortestPath.add(sourceNode);
			        evaluationNode.setShortestPath(shortestPath);
			    }
			}
	
	private static Node getLowestDistanceNode(Set < Node > unsettledNodes) {
	    Node lowestDistanceNode = null;
	    int lowestDistance = Integer.MAX_VALUE;
	    for (Node node: unsettledNodes) {
	        int nodeDistance = node.getDistance();
	        if (nodeDistance < lowestDistance) {
	            lowestDistance = nodeDistance;
	            lowestDistanceNode = node;
	        }
	    }
	    return lowestDistanceNode;
	}
	public static void main(String[] args) {
		int k = 1000000;
		Node [] nodes = new Node[k];
		for (int i = 0; i < k; i++) {
			nodes[i] = new Node(i);
		}

		Random rnd = new Random();
		for (int i = 0; i < k * 2; ) {
			int m = rnd.nextInt(k);
			int n = rnd.nextInt(k);
			if (m != k) {
				nodes[n].addDestination(nodes[m], rnd.nextInt(10));
				i++;
			}
		}
		 
		Graph graph = new Graph();
		 
		for (int j = 0; j < nodes.length; j++) {
			graph.addNode(nodes[j]);
		}
		long anfang = System.nanoTime();
		graph = calculateShortestPathFromSource(graph, nodes[0]);
        long ende = System.nanoTime();
        System.out.println("Zeit in millisekunden: " + (ende - anfang));
		
		nodes[k / 4].getShortestPath().forEach( node -> {
			System.out.println("Name " + node.getName());
			System.out.println("distance " + node.getDistance());
		});

		System.out.println("Name " + nodes[k / 4].getName());
		System.out.println("distance " + nodes[k / 4].getDistance());
	}
}
