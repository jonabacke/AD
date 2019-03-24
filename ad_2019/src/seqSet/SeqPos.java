/**
 * 
 */
package seqSet;

import adp01.ELEM;
import adp01.POS;
import adp01.SET;

/**
 * Speichert einen Zeiger ab und
 * ob dieser gueltig ist.
 * 
 * Zeiger ist gueltig wenn er
 * groesser ist als 0
 * 
 * @author Fabian Erdmann
 * @version 21.03.2019
 *
 */
public class SeqPos implements POS {
	private boolean isValid;
	public int zeiger;
	
	/**
	 * Erstellt eine neue SeqPos und
	 * veraendert je nach uebergebener Pos die
	 * Gueltigkeit
	 * @param pos die Position die gespeichert werden soll
	 */
	public SeqPos(int pos) {
		zeiger = pos;
		if (zeiger > 0) {
			isValid = true;
			
		}
	}
	
	/**
	 * @param newZeiger neuer Zeiger
	 */
	public void setZeiger(int newZeiger) {
		zeiger = newZeiger;
		if (zeiger > 0) {
			isValid = true;
		}
		else {
			isValid = false;
		}
	}
	
	/**
	 * @return aktueller Zeiger
	 */
	public int getZeiger() {
		return zeiger;
	}
	
	@Override
	public boolean getValid() {
		return isValid;
	}
}
