package seqList;

/**
 * Ein einzelner Knoten um Elemente zu speichern
 * Speichert den nächsten Knoten in der Reihe ab
 * und kann diesen wieder ausgeben.
 * @author Fabian Erdmann
 * @version 24.03.2019
 *
 * @param <T> der Typ des zu speichernden Elements
 */
public class Knoten<T> {
	private Knoten<T> next;
	private T elem;
	
	/**
	 * Erstellt einen neuen Knoten
	 * @param next der Folgende Knoten
	 * @param elem das zu speichernde Element
	 */
	public Knoten(Knoten<T> next, T elem) {
		this.next = next;
		this.elem = elem;
	}
	
	/**
	 * @param newNext aendert den naechsten Knoten auf diesen Wert
	 */
	public void setNext(Knoten<T> newNext) {
		next = newNext;
	}
	
	/**
	 * @param newElem aendert das Element auf diesen Wert
	 */
	public void setElem(T newElem) {
		elem = newElem;
	}
	
	/**
	 * @return der folgende Knoten
	 */
	public Knoten<T> getNext() {
		return next;
	}
	
	/**
	 * @return das abgespeicherte Element
	 */
	public T getElem() {
		return elem;
	}
}
