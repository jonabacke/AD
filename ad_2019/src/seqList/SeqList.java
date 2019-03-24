/**
 * 
 */
package seqList;

import adp01.ELEM;
import adp01.KEY;
import adp01.POS;
import adp01.SET;

/**
 * Aufgabenblatt 1 Aufgabe 2b
 * Speichert eine Menge an Elementen
 * mithilfe einer einfach verketteten
 * Liste ab.
 * @author Fabian Erdmann
 * @version 22.03.2019
 *
 */
public class SeqList implements SET {
	private Knoten<ELEM> head;
	private Knoten<ELEM> tail;
	private int listSize;
	
	public SeqList() {
		tail = new Knoten<ELEM>(null, null);
		head = new Knoten<ELEM>(tail, null);
		tail.setNext(head);
	}

	@Override
	public ListPos add(ELEM elem) {
		ListPos newPos = find(elem.key);
		if (newPos.getValid() && newPos.getZeiger().getNext() != tail) {
			return newPos;
		}
		listSize++;
		Knoten<ELEM> newKnoten = new Knoten<ELEM>(tail, elem);
		newPos.getZeiger().setNext(newKnoten);
		tail.setNext(newKnoten);
		
		return new ListPos(this, newKnoten);
	}

	@Override
	public void delete(POS pos) {
		 Knoten<ELEM> prevKnoten = ((ListPos)pos).getZeiger();
		 Knoten<ELEM> nextKnoten = ((ListPos)pos).getZeiger().getNext().getNext();
		 
		 prevKnoten.setNext(nextKnoten);
	}

	@Override
	public void delete(KEY key) {
		ListPos pos = find(key);
		if (pos.getValid() && pos.getZeiger() != tail) {
			delete(pos);
		}
	}

	@Override
	public ListPos find(KEY key) {
		tail.setElem(new ELEM(key, null));
		Knoten<ELEM> suchPos = head;
		
		while(!(suchPos.getNext().equals(tail))) {
			suchPos = suchPos.getNext();
		}
		
		tail.setElem(null);
		
		return new ListPos(this, suchPos);
	}

	@Override
	public ELEM retrieve(POS pos) {
		if (pos.getValid() && (pos instanceof ListPos)) {
			ListPos listPos = (ListPos)pos;
			return listPos.getZeiger().getNext().getElem();
		}
		return null;
	}

	@Override
	public void showall() {
		Knoten<ELEM> nextKnoten = head.getNext();
		while (nextKnoten != tail) {
			System.out.println(nextKnoten.getElem());
			nextKnoten = nextKnoten.getNext();
		}
	}

	@Override
	public int size() {
		return listSize;
	}

	@Override
	public SET unify(SET s, SET t) {
		return null;
	}

}
