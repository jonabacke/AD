/**
 * 
 */
package ab_08;

import java.util.ArrayList;

/**
 * PM 2 Praktikumsaufgaben
 *
 * @author Fabian Erdmann, Jonathan Backes
 * @version 12.05.2019
 *
 */
public class BaumArray<T extends Comparable<T>> implements BaumInterface<T>{
	public ArrayList<KnotenArray<T>> arrayList;
	
	public BaumArray() {
		arrayList = new ArrayList<KnotenArray<T>>();
	}

	@Override
	public void insert(KnotenInterface<T> knoten) {
		if (knoten instanceof KnotenArray) {
			arrayList.add((KnotenArray<T>)knoten);
			for(int i = arrayList.size() / 2 - 1; i >= 0; i--) {
				heapify(arrayList.size(), i);
			}
		}
	}
	
	public void heapify(int n, int i) {
		int largest = i;
		int l = 2*i + 1;
		int r = 2*i + 2;
		
		if(l < n && arrayList.get(l).compareTo(arrayList.get(largest)) > 0) {
			largest = l;
		}
		
		if (r < n && arrayList.get(r).compareTo(arrayList.get(largest)) > 0) {
			largest = r;
		}
		
		if (largest != i) {
			KnotenArray<T> temp = arrayList.get(i);
			arrayList.add(i, arrayList.get(largest));
			arrayList.remove(i+1);
			arrayList.remove(largest);
			arrayList.add(largest, temp);
			
			heapify(n, largest);
		}
	}

}
 