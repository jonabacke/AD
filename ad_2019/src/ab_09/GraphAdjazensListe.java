package ab_09;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphAdjazensListe implements GraphInterface {

	private Node head;
 	HashMap<Integer, Node> liste;
 	
 	public GraphAdjazensListe() {
		// TODO Auto-generated constructor stub
 		liste = new HashMap<Integer, Node>();
	}
 	
	public void printGraph() {
		System.out.println(liste);
	}

	@Override
	public ArrayList<Integer> getNeighbours(int node) {
		// TODO Auto-generated method stub
		ArrayList<Integer> lis = new ArrayList<Integer>();
		liste.get(node).get_neighbours().keySet().forEach(ele -> {
			lis.add(liste.get(node).get_neighbours().get(ele).get_value());
		});
		return lis;
	}

	@Override
	public int getDistance(int node1, int node2) {
		// TODO Auto-generated method stub
		return liste.get(node1).get_distanc(node2);
	}

	@Override
	public void setHead(int head) {
		// TODO Auto-generated method stub
		this.head = getNodeOfValue(head);
	}

	@Override
	public void addNode(int value) {
		// TODO Auto-generated method stub
		Node node = new Node(value);
		this.liste.put(value, node);
		if (head == null) {
			head = node;
		}
	}
	
	private Node getNodeOfValue(int value) {
		return  liste.get(value);
	}

	@Override
	public int getHeadNode() {
		// TODO Auto-generated method stub
		return head.get_value();
	}

	@Override
	public void addWeight(int node1, int node2, int weight) {
		// TODO Auto-generated method stub
		this.liste.get(node1).set_distance(weight, node2);
	}

}
