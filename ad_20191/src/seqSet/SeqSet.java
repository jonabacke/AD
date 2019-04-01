/**
 * 
 */
package seqSet;

import java.util.Arrays;

import adp01.ELEM;
import adp01.KEY;
import adp01.POS;
import adp01.SET;

/**
 * ADP Praktikumsaufgabe 1 Aufgabe 2a
 * 
 * Speichert ein Set an Elementen mithilfe
 * eines einfachen Arrays ab.
 * 
 * Es werden keine Duplikate zugelassen.
 * 
 * @author Fabian Erdmann
 *
 */
public class SeqSet implements SET {		
	private int maxsize = 10;
	private ELEM[] elem;
	private int listSize;
	
	public SeqSet() {
		elem = new ELEM[maxsize + 1];
		listSize = 0;
	}
	
	@Override
	public SeqPos add(ELEM newElem) {
		SeqPos newPos = find(newElem.key);
		if (newPos.getValid()) {
			return newPos;
		}
		
		listSize++;
		if (listSize > maxsize) {
			maxsize = maxsize * 2;
			elem = Arrays.copyOf(elem, maxsize+1);
		}
		
		elem[listSize] = newElem;
		return new SeqPos(listSize);
	}
	
	@Override
	public void delete(POS pos) {
		if (!(pos instanceof SeqPos) && !((SeqPos)pos).getValid()) {
			return;
		}
		if (listSize > 0) {
			for (int i = ((SeqPos)pos).getZeiger(); i <= listSize-1; i++) {
				elem[i] = elem[i + 1];
			}
			elem[listSize] = null;
			listSize--;
		}
	}

	@Override
	public void delete(KEY key) {
		delete(find(key));
	}

	@Override
	public SeqPos find(KEY key) {
		elem[0] = new ELEM(key, null);
		
		int i = listSize;
		while (!elem[i].equals(elem[0])) {
			i--;
		}
		
		return new SeqPos(i);
	}

	@Override
	public ELEM retrieve(POS pos) {
		if (pos instanceof SeqPos) {
			return elem[((SeqPos)pos).getZeiger()];
		}
		return null;
	}

	@Override
	public void showall() {
		for(ELEM single: elem) {
			System.out.println(single);
		}
	}

	@Override
	public int size() {
		return listSize;
	}
	
	@Override
	public SeqSet unify(SET s, SET t) {
		SeqSet newList = new SeqSet();
		
		for (int i = 0; i < s.size(); i++) {
			s.add(t.retrieve(new SeqPos(i)));
		}
		
		return newList;
	}
}
