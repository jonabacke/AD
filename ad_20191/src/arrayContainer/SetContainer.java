/**
 * 
 */
package arrayContainer;

import adp01.ELEM;

/**
 * Container um die einzelnen Elemente abzuspeichern
 * 
 * @author Fabian Erdmann
 * @version 24.03.2019
 *
 */
public class SetContainer {
	private int next;
	private int prev;
	private ELEM elem;
	
	/**
	 * @param next Index des naechsten Elements
	 * @param prev Index des vorherigen Elements
	 * @param elem Das abzuspeichernde Element
	 */
	public SetContainer(int next, int prev, ELEM elem) {
		this.next = next;
		this.prev = prev;
		this.elem = elem;
	}
	
	/**
	 * @param next aendert den Index des naechsten Elements auf diesen Wert
	 */
	public void setNext(int next) {
		this.next = next;
	}
	
	/**
	 * @param prev aendert den Index des vorherigen Elements auf diesen Wert
	 */
	public void setPrev(int prev) {
		this.prev = prev;
	}
	
	/**
	 * @param elem das neue Element, das gespeichert werden soll
	 */
	public void setElem(ELEM elem) {
		this.elem = elem;
	}

	/**
	 * @return Index des nächsten ELements
	 */
	public int getNext() {
		return next;
	}
	
	/**
	 * @return Index des vorherigen Elements
	 */
	public int getPrev() {
		return prev;
	}
	
	/**
	 * @return das Element
	 */
	public ELEM getElem() {
		return elem;
	}
}
