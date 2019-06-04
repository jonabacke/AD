package ab_09;

import java.util.HashMap;

public class AlgorithmusVonDykstraListe {
	
	GraphAdjazensListe liste;
	Node head;
	HashMap<Integer, Node> newListe;
	int i;
	
	public AlgorithmusVonDykstraListe(GraphAdjazensListe liste, Node head) {
		// TODO Auto-generated constructor stub
		this.liste = liste;
		this.head = head;
		newListe = new HashMap<Integer, Node>();
	}
	
	public GraphAdjazensListe makeWays(Node head, int headPosition, int last) {
		int [] keys = new int[11];
		i = 0;
		int[] lows = new int[11];
		liste.liste.get(head.get_value()).get_distance().keySet().forEach(key -> {
			keys[i] = key;
			i ++;
		});
		for (int i = 0; i < keys.length; i++) {
			liste.liste.get(head.get_value()).
			get_distanc(liste.liste.get(head.get_value()).get_neighbours().get(keys[i]).get_value());
		}
		
		
		return liste;
	}

}
