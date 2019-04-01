package arrayContainer;

import adp01.POS;

public class SetPosContainer implements POS{
	private boolean isValid;
	public int zeiger;
	
	/**
	 * Erstellt eine neue SeqPos und
	 * veraendert je nach uebergebener Pos die
	 * Gueltigkeit
	 * @param pos die Position die gespeichert werden soll
	 */
	public SetPosContainer(int pos) {
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
