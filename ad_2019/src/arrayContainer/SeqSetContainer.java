/**
 * 
 */
package arrayContainer;

import java.util.Arrays;

import adp01.ELEM;
import adp01.KEY;
import adp01.POS;
import adp01.SET;
import seqSet.SeqPos;
import seqSet.SeqSet;

/**
 * Aufgabenblatt 1 Aufgabe 2a
 * Implementierung eines Sets mithilfe eines Arrays
 * 
 * 
 * @author Fabian Erdmann
 * @version 24.03.2019
 *
 */
public class SeqSetContainer implements SET{
	private SetContainer[] elemContainer;
	private int maxsize;
	private int listSize;
	
	public SeqSetContainer() {
		maxsize = 10;
		listSize = 0;
		elemContainer = new SetContainer[maxsize + 1];
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
			elemContainer = Arrays.copyOf(elemContainer, maxsize+1);
		}

		elemContainer[listSize] = new SetContainer(0, listSize-1, newElem);
		return new SeqPos(listSize);
	}

	@Override
	public void delete(POS pos) {
		if (!(pos instanceof SeqPos) && !((SeqPos)pos).getValid()) {
			return;
		}
		
		if (listSize > 0) {
			for (int i = ((SeqPos)pos).getZeiger(); i <= listSize-1; i++) {
				elemContainer[i] = elemContainer[i + 1];
				elemContainer[i].setNext(i+1);
				elemContainer[i].setPrev(i-1);
			}
			elemContainer[listSize] = null;
			listSize--;
		}
	}

	@Override
	public void delete(KEY key) {
		delete(find(key));
	}

	@Override
	public SeqPos find(KEY key) {
		elemContainer[0] = new SetContainer(0, 0, new ELEM(key, null));
		
		int index = listSize;
		while (!(elemContainer[index].getElem().equals(elemContainer[0].getElem()))) {
			index--;
		}
		
		return new SeqPos(index);
	}

	@Override
	public ELEM retrieve(POS pos) {
		if (pos instanceof SeqPos) {
			return elemContainer[((SeqPos)pos).getZeiger()].getElem();
		}
		return null;
	}

	@Override
	public void showall() {
		for(SetContainer single: elemContainer) {
			System.out.println(single.getElem());
		}
	}

	@Override
	public int size() {
		return listSize;
	}

	@Override
	public SET unify(SET s, SET t) {
		SeqSetContainer newList = new SeqSetContainer();
		
		for (int i = 0; i < s.size(); i++) {
			s.add(t.retrieve(new SeqPos(i)));
		}
		
		return newList;
	}
	
}
