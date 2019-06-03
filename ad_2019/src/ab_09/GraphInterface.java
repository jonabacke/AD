package ab_09;

import java.util.ArrayList;

public interface GraphInterface {
	
	public void addNode(int value);
	public int getHeadNode();
	public ArrayList<Integer> getNeighbours(int node);
	public int getDistance(int node1, int node2);
	public void setHead(int head);
	public void addWeight(int node1, int node2, int weight);

}
