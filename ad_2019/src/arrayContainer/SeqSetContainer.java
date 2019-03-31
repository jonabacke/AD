package arrayContainer;

import java.util.Arrays;

import adp01.ELEM;
import adp01.KEY;
import adp01.POS;
import adp01.SET;

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
		elemContainer = new SetContainer[maxsize+1]; //Dummy Element auf MaxSize
		elemContainer[0] = new SetContainer(1, 0, null);
		elemContainer[11] = new SetContainer(0, 0, null);
		freiListe = new int[maxsize+1];
		posFreiListe = 0;
	}

	@Override
	public SetPosContainer add(ELEM newElem) {
		SetPosContainer newPos = find(newElem.key);
		if (newPos.getValid()) {
			return newPos;
		}
		SetPosContainer neuePos = new SetPosContainer(0);
		
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
		if ((pos instanceof SetPosContainer) && !((SetPosContainer)pos).getValid()) {
			return;
		}
		
		if (listSize > 0 && ((SetPosContainer)pos).getZeiger() < maxsize) {
			//Das zu loeschende Element
			int aktuell = ((SetPosContainer)pos).getZeiger();
			//Das naechste ELement
			int next = elemContainer[aktuell].getNext();
			//Das vorherige ELement
			int prev = elemContainer[aktuell].getPrev();
			//Setzen der neuen Positionen
			if (elemContainer[next] != null) {
				elemContainer[next].setPrev(prev);
			}
			elemContainer[prev].setNext(next);
			elemContainer[aktuell] = null;
			//Hinzufuegen der neuen freien Position auf die Freiliste
			posFreiListe++;
			freiListe[posFreiListe] = aktuell;
			listSize--;
		}
	}

	@Override
	public void delete(KEY key) {
		delete(find(key));
	}

	@Override
	public SetPosContainer find(KEY key) {
		elemContainer[0] = new SetContainer(1, 0, new ELEM(key, null));
		
		int index = maxsize-1;
		boolean found = false;		
		while (!found) {
			if (elemContainer[index] != null) {
				found = elemContainer[index].getElem().equals(elemContainer[0].getElem());
				if (!found) {
					index = elemContainer[index].getPrev();
				}
			}
			else {
				index--;
			}
		}
		
		return new SetPosContainer(index);
	}

	@Override
	public ELEM retrieve(POS pos) {
		if ((pos instanceof SetPosContainer) && ((SetPosContainer)pos).getValid()) {
			SetContainer ergebnis = elemContainer[((SetPosContainer)pos).getZeiger()];
			if (ergebnis != null) {
				return ergebnis.getElem();
			}
		}
		return null;
	}

	@Override
	public void showall() {
		for (int i = 1; i < maxsize; i++) {
			if (elemContainer[i] != null) {
				System.out.println(elemContainer[i].getElem());
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
			s.add(t.retrieve(new SetPosContainer(i)));
		}
		
		return newList;
	}
	
}
