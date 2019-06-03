package ab_09;

import java.util.ArrayList;

public class GraphAdjazensListe implements GraphInterface {

	private Node head;
 	private ArrayList<Node> liste;
 	
 	public GraphAdjazensListe() {
		// TODO Auto-generated constructor stub
 		liste = new ArrayList<Node>();
	}

	@Override
	public ArrayList<Integer> getNeighbours(int node) {
		// TODO Auto-generated method stub
		ArrayList<Integer> lis = new ArrayList<Integer>();
		liste.get(node).get_neighbours().forEach(elem -> {
			lis.add(elem.get_value());
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
		this.liste.add(value, node);
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
	public void addweight(int node1, int node2, int weight) {
		// TODO Auto-generated method stub
		this.liste.get(node1).set_distance(weight, node2);
	}

}
