package ab_09;

import java.util.HashSet;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> set = new HashSet<Integer>();
		Random rnd = new Random();
		do {
			set.add(rnd.nextInt(100));
		} while (set.size() < 10);
		Object[] array = new Object[4];
		array = set.toArray();
		
		
		
		GraphAdjazensMatrix matrix = new GraphAdjazensMatrix(10);
		set.forEach(ele -> matrix.addNode(ele));
		
		
		for (int i = 0; i < 20; ) {
			int k = rnd.nextInt(10);
			int j = rnd.nextInt(10);
			if (k != j) {
				matrix.addWeight((int) array[k], (int) array[j], rnd.nextInt(100));
				i++;
			} else {
				
			}
			
		}
		

		AlgorithmusVonDykstraMatrix dykstraMatrix = new AlgorithmusVonDykstraMatrix(matrix, matrix.getHeadNode());
		
		System.out.println("---------------");
		matrix.printGraph();
		
		Container[][] newMatrix = dykstraMatrix.makeWays(matrix.getHeadNode(), 0);

		for (int i = 0; i < newMatrix.length; i++) {
			for (int j = 0; j < newMatrix[i].length; j++) {
				if (newMatrix[i][j] == null) {
					System.out.print(0 + ", ");
				} else {
					System.out.print(newMatrix[i][j].getRandemenge() + ", ");					
				}
			}
			System.out.println();
		}
		
		
		
		
		
		
		GraphAdjazensListe liste = new GraphAdjazensListe();
		set.forEach(ele -> liste.addNode(ele));
		
		
		for (int i = 0; i < 20; i++) {
			liste.addWeight((int) array[rnd.nextInt(10)], (int) array[rnd.nextInt(10)], rnd.nextInt(100));
		}
		System.out.println("---------------");
		
		AlgorithmusVonDykstraListe dykListe = new AlgorithmusVonDykstraListe(liste, liste.getHead());
		GraphAdjazensListe newListe = new GraphAdjazensListe();
		newListe = dykListe.makeWays(liste.getHead(), 0);

		

	}

}
