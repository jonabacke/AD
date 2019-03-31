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
	private int freiListe[];
	private int posFreiListe;
	private int maxsize;
	private int listSize;
	
	public SeqSetContainer() {
		maxsize = 10 + 1; //1 Stopperelement auf 0
		listSize = 0;
		elemContainer = new SetContainer[maxsize];
		elemContainer[0] = new SetContainer(1, 0, null);
		freiListe = new int[maxsize];
		posFreiListe = 0;
	}

	@Override
	public SeqPos add(ELEM newElem) {
		SeqPos newPos = find(newElem.key);
		if (newPos.getValid()) {
			return newPos;
		}
		SeqPos neuePos = new SeqPos(0);
		
		listSize++;
		//Wenn Platz in der Liste speichere dort
		if (listSize < maxsize) {
			elemContainer[listSize] = new SetContainer(listSize + 1, listSize - 1, newElem);
			neuePos.setZeiger(listSize);
		}
		//Wenn zwischen den Positionen ein Platz frei ist speichere dort
		else if (freiListe[posFreiListe] != 0) {
			elemContainer[freiListe[posFreiListe]] = new SetContainer(freiListe[posFreiListe] + 1, freiListe[posFreiListe] - 1, newElem);
			neuePos.setZeiger(freiListe[posFreiListe]);
			if (posFreiListe > 0) {
				posFreiListe--;
			}
			listSize--;
		}
		//Wenn ueberhaupt kein Platz ist, erstelle ein neues Array mit doppelter groesse
		else {
			maxsize = maxsize * 2;
			elemContainer = Arrays.copyOf(elemContainer, maxsize);
			elemContainer[listSize] = new SetContainer(listSize + 1, listSize - 1, newElem);
			neuePos.setZeiger(listSize);
		}
		return neuePos;
	}

	@Override
	public void delete(POS pos) {
		if (!(pos instanceof SeqPos) && !((SeqPos)pos).getValid()) {
			return;
		}
		
		if (listSize > 0) {
			//Das zu loeschende Element
			int aktuell = ((SeqPos)pos).getZeiger();
			//Das naechste ELement
			int next = elemContainer[aktuell].getNext();
			//Das vorherige ELement
			int prev = elemContainer[aktuell].getPrev();
			//Setzen der neuen Positionen
			elemContainer[next].setPrev(prev);
			elemContainer[prev].setNext(next);
			elemContainer[aktuell] = null;
			//Hinzufuegen der neuen freien Position auf die Freiliste
			posFreiListe++;
			freiListe[posFreiListe] = aktuell;
		}
	}

	@Override
	public void delete(KEY key) {
		delete(find(key));
	}

	@Override
	public SeqPos find(KEY key) {
		elemContainer[0] = new SetContainer(1, 0, new ELEM(key, null));
		
		int index = listSize;
		while (!(elemContainer[index].getElem().equals(elemContainer[0].getElem()))) {
			index = elemContainer[index].getPrev();
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
			if (single != null) {
				System.out.println(single.getElem());
			}
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
