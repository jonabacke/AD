package seqList;

import adp01.ELEM;
import adp01.POS;
import adp01.SET;

/**
 * Speichert die Position eines Knoten ab und
 * ob diese gueltig ist
 * @author Fabian Erdmann
 * @version 24.03.2019
 *
 */
public class ListPos implements POS {
	private SET set;
	private Knoten<ELEM> zeiger;
	
	/**
	 * @param set das dazugehörige Set
	 * @param knoten der Knoten der als Zeiger dienen soll
	 */
	public ListPos(SET set, Knoten<ELEM> knoten) {
		this.set = set;
		this.zeiger = knoten;
	}
	
	/**
	 * @param zeiger setzt einen neuen Zeiger mit diesem Wert
	 */
	public void setZeiger(Knoten<ELEM> zeiger) {
		this.zeiger = zeiger;
	}
	
	@Override
	public boolean getValid() {
		return zeiger != null;
	}
	
	/**
	 * @return aktueller Zeiger
	 */
	public Knoten<ELEM> getZeiger() {
		return zeiger;
	}
	
}
