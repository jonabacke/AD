package ab_09;

import java.util.ArrayList;

public class GraphAdjazensMatrix implements GraphInterface {
	
	Container[][] matrix;
	Container head;
	
	public GraphAdjazensMatrix(int grad) {
		// TODO Auto-generated constructor stub
		matrix = new Container [grad + 1][grad + 1];
		printGraph();
	}
	
	public void printGraph() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == null) {
					System.out.print(0 + ", ");
				} else {
					System.out.print(matrix[i][j].getValue() + ", ");
				}
				
			}
			System.out.println();
		}
	}

	@Override
	public void addNode(int value) {
		// TODO Auto-generated method stub
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == null) {
				Container node = new Container(value);
				matrix[i][0] = node;
				matrix[0][i] = node;
				break;
			}
		}
	}
	// node1 -> node2
	public void addWeight(int node1, int node2, int weight) {
		for (int i = 1; i < matrix.length; i++) {
			if (node1 == matrix[i][0].getValue()) {
				for (int j = 1; j < matrix[i].length; j++) {
					if (matrix[0][j].getValue() == node2) {
						Container container = new Container(weight);
						matrix[i][j] = container;
						matrix[j][i] = container;
						if (head == null) {
							this.head = matrix[i][0];
						}
						break;
					}
				}
				break;
			}
		}
	}

	@Override
	public int getHeadNode() {
		// TODO Auto-generated method stub
		return this.head.value;
	}

	@Override
	public ArrayList<Integer> getNeighbours(int node) {
		// TODO Auto-generated method stub
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for (int i = 0; i < matrix[node].length; i++) {
			if (matrix[node][i].getValue() != 0) {
				liste.add(i);
			}
		}
		return liste;
	}

	@Override
	public int getDistance(int node1, int node2) {
		// TODO Auto-generated method stub
		return matrix[node1][node2].getValue();
	}

	@Override
	public void setHead(int head) {
		// TODO Auto-generated method stub
		this.head = new Container(head);
	}
	
	public Container getContainer(int con) {
		// TODO Auto-generated method stub
		return this.matrix[0][con];
	}
	
	public int getStelle(int container, int head) {
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][head] != null) {
				if (matrix[i][head].value == container && matrix[i][head] != null) {
					return i;
				}				
			}
		}
		return 0;
	}
	
	public Container[][] getMatrix() {
		return matrix;
	}

}
