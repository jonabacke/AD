package ab_09;

import java.util.HashMap;

public class AlgorithmusVonDykstraListe {
	
	GraphAdjazensListe liste;
	Node head;
	HashMap<Integer, Node> newListe;
	int j;
	int [] keys = new int[11];
	
	public AlgorithmusVonDykstraListe(GraphAdjazensListe liste, Node head) {
		// TODO Auto-generated constructor stub
		this.liste = liste;
		this.head = head;
		newListe = new HashMap<Integer, Node>();
	}
	
	public GraphAdjazensListe makeWays(Node head, int last) {
		for (int i = 0; i < keys.length; i++) {
			keys[i] = 0;
		}
		j = 0;
		int[] lows = new int[11];
		liste.liste.get(head.get_value()).get_distance().keySet().forEach(key -> {
			keys[j] = key;
			j ++;
		});
		keys = sort(keys, head);
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != 0 && liste.liste.get(keys[i]).getGesetzt() == false) {
				liste.liste.get(keys[i]).setRandWert(head.get_distanc(keys[i]) + last);
				liste.liste.get(keys[i]).setGesetzt(true);
				liste.liste.get(keys[i]).setVorgängerNode(head);
			}
		}

		for (int i = 0; i < keys.length; i++) {
			if (keys[i] != 0) {
				makeWays(liste.liste.get(keys[i]), head.get_distanc(keys[i]) + last);
			}
		}
		
		
		return liste;
	}
	
	public int[] sort(int [] keys, Node node) {
        if (keys == null || keys.length==0){
            return null;
        }
        for (int i = keys.length - 1; i >= 0; i--) {
        	if (keys[i] != 0) {
        		quicksortMedian(0, i, node);
        		break;
			}
		}
				
		return keys;
	}
	
	private void quicksortMedian(int low, int high, Node node) {
        int i = low, j = high, median = low + (high-low)/2;
        int pivot;
        if(i < j && i > median) {  
        	pivot = node.get_distanc(keys[i]);
        	}

        if(j < i && j > median) { 
        	pivot = node.get_distanc(keys[j]);
        	}
        else {
        	pivot = node.get_distanc(keys[median]);
        	}

        while (i <= j) {
            while (node.get_distanc(keys[i]) < pivot) {
                i++;
            }
            while (node.get_distanc(keys[j]) > pivot) {
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (low < j)
        	quicksortMedian(low, j, node);
        if (i < high)
        	quicksortMedian(i, high, node);
    }


    private void exchange(int i, int j) {
        int temp = keys[i];
        keys[i] = keys[j];
        keys[j] = temp;
    }
}
