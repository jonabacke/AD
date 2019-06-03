package ab_09;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphAdjazensMatrix matrix = new GraphAdjazensMatrix(5);
		matrix.addNode(1);
		matrix.addNode(2);
		matrix.addNode(3);
		matrix.addNode(4);
		matrix.addNode(5);
		matrix.addweight(1, 3, 12);
		matrix.addweight(1, 4, 60);
		matrix.addweight(2, 1, 10);
		matrix.addweight(3, 2, 20);
		matrix.addweight(3, 4, 32);
		matrix.addweight(5, 1, 7);
		System.out.println("---------------");
		matrix.printMatrix();
		
		GraphAdjazensListe liste = new GraphAdjazensListe();
		

	}

}
