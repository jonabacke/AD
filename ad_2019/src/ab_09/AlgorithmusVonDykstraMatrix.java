package ab_09;

public class AlgorithmusVonDykstraMatrix {
	
	GraphAdjazensMatrix graphMatrix;
	int _head;
	Container[][] matrix;
	Container[][] newMatrix;
	
	public AlgorithmusVonDykstraMatrix(GraphAdjazensMatrix matrix, int head) {
		// TODO Auto-generated constructor stub
		this.graphMatrix = matrix;
		this._head = head;
		this.matrix = graphMatrix.getMatrix();
		this.newMatrix = new Container [this.matrix.length][this.matrix[0].length];
	}
	
	public Container[][] makeWays(int head, int last) {
		head = graphMatrix.getStelle(head, 0);
		int[] lows = new int[11];
		int low = 0;
		for (int i = 1; i < matrix.length; i++) {
			low = graphMatrix.getStelle(getLow(head), head);
				if (low != 9999999 && low != 0){
					if (newMatrix[low][head] == null) {
						Container container = new Container(matrix[low][head].getValue());
						container.setRandemenge(last + matrix[low][head].getRandemenge());
						container.setVorgänger(graphMatrix.getContainer(head));
						container.setGesetzt(true);
						newMatrix[low][head] = container;
						newMatrix[head][low] = container;
						graphMatrix.matrix[low][head].value = 0;
						graphMatrix.matrix[head][low].value = 0;
						lows[i] = low;
					} else {
						if ((matrix[low][head].getValue() + head) < newMatrix[low][head].getValue()) {
							newMatrix[low][head].setRandemenge(last + matrix[low][head].getValue());
							newMatrix[low][head].setVorgänger(graphMatrix.getContainer(head));
							newMatrix[low][head].setGesetzt(true);			
							newMatrix[head][low].setRandemenge(last + matrix[head][low].getValue());
							newMatrix[head][low].setVorgänger(graphMatrix.getContainer(head));
							newMatrix[head][low].setGesetzt(true);			
						}
					}
				}
		}
		for (int i = 0; i < lows.length; i++) {
			if (lows[i] != 0 && lows[i] != 9999999) {
				makeWays2(lows[i], newMatrix[lows[i]][head].getValue());	
			}
		}
		return newMatrix;
	}
	
	private Container[][] makeWays2(int head, int last) {
		int[] lows = new int[11];
		int low = 0;
		for (int i = 1; i < matrix.length; i++) {
			low = graphMatrix.getStelle(getLow(head), head);
				if (low != 9999999 && low != 0){
					if (newMatrix[low][head] == null) {
						Container container = new Container(matrix[low][head].getValue());
						container.setRandemenge(last + matrix[low][head].getRandemenge());
						container.setVorgänger(graphMatrix.getContainer(head));
						container.setGesetzt(true);
						newMatrix[low][head] = container;
						newMatrix[head][low] = container;
						graphMatrix.matrix[low][head].value = 0;
						graphMatrix.matrix[head][low].value = 0;
						lows[i] = low;
					} else {
						if ((matrix[low][head].getValue() + head) < newMatrix[low][head].getValue()) {
							newMatrix[low][head].setRandemenge(last + matrix[low][head].getValue());
							newMatrix[low][head].setVorgänger(graphMatrix.getContainer(head));
							newMatrix[low][head].setGesetzt(true);			
						}
					}
				}
		}
		for (int i = 0; i < lows.length; i++) {
			if (lows[i] != 0 && lows[i] != 9999999) {
				makeWays2(lows[i], newMatrix[lows[i]][head].getValue());	
			}
		}
		return newMatrix;
	}
	
	private int getLow(int head) {
		int low = 9999999;
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][head] != null && 
					matrix[i][head].getValue() != 0 && 
					matrix[i][head].getValue() < low) {
				if (newMatrix[i][head] == null) {
					low = matrix[i][head].getValue();
				} else {
					if (!newMatrix[i][head].getGesetzt()) {
						low = matrix[i][head].getValue();
					}
				}
				
			}
		}
		return low;
	}
	
	
	
	

}
