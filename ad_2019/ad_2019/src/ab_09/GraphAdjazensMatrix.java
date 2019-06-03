package ab_09;

import java.util.ArrayList;

public class GraphAdjazensMatrix implements GraphInterface {
	
	private int[][] matrix;
	int head = 1;
	
	public GraphAdjazensMatrix(int grad) {
		// TODO Auto-generated constructor stub
		matrix = new int [grad + 1][grad + 1];
		printMatrix();
	}
	
	public void printMatrix() {
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}
	}

	@Override
	public void addNode(int value) {
		// TODO Auto-generated method stub
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				matrix[i][0] = value;
				matrix[0][i] = value;
				break;
			}
		}
	}
	// node1 -> node2
	public void addweight(int node1, int node2, int weight) {
		for (int i = 1; i < matrix.length; i++) {
			if (node1 == matrix[i][0]) {
				for (int j = 1; j < matrix[i].length; j++) {
					if (matrix[0][j] == node2) {
						matrix[i][j] = weight;
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
		return matrix[1][1];
	}

	@Override
	public ArrayList<Integer> getNeighbours(int node) {
		// TODO Auto-generated method stub
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for (int i = 0; i < matrix[node].length; i++) {
			if (matrix[node][i] != 0) {
				liste.add(i);
			}
		}
		return liste;
	}

	@Override
	public int getDistance(int node1, int node2) {
		// TODO Auto-generated method stub
		return matrix[node1][node2];
	}

	@Override
	public void setHead(int head) {
		// TODO Auto-generated method stub
		this.head = head;
	}

}
