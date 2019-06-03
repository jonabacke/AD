package ab_09;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphAdjazensMatrix matrix = new GraphAdjazensMatrix(5);
		matrix.addNode(1);
		matrix.addNode(2);
		matrix.addNode(3);
		matrix.addNode(4);
		matrix.addNode(5);
		matrix.addWeight(1, 3, 12);
		matrix.addWeight(1, 4, 60);
		matrix.addWeight(2, 1, 10);
		matrix.addWeight(3, 2, 20);
		matrix.addWeight(3, 4, 32);
		matrix.addWeight(5, 1, 7);
		System.out.println("---------------");
		matrix.printGraph();
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(2, 4);
		
		GraphAdjazensListe liste = new GraphAdjazensListe();
		liste.addNode(1);
		liste.addNode(2);
		liste.addNode(3);
		liste.addNode(4);
		liste.addNode(5);
		liste.addWeight(1, 3, 12);
		liste.addWeight(1, 4, 60);
		liste.addWeight(2, 1, 10);
		liste.addWeight(3, 2, 20);
		liste.addWeight(3, 4, 32);
		liste.addWeight(5, 1, 7);
		System.out.println("---------------");
		
		liste.printGraph();
		

	}

}
