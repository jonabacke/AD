/**
 * 
 */
package adp01;

import java.util.Objects;

/**
 * @author Fabian Erdmann
 * Klasse zur Darstellung eines Elements, das String
 * Daten Speichern kann.
 * Jedes Element hat einen einzigartigen Key
 * 
 *
 */
public class ELEM {
	public KEY key;
	public String data;
	
	/**
	 * @param data Daten die in dem neuen ELement gespeichert werden sollen
	 */
	public ELEM(String data) {
		this(new KEY(), data);
	}
	
	/**
	 * 
	 * @param key der für das Element benutzt werden soll
	 * @param data die im Element gespeichert werden sollen
	 */
	public ELEM(KEY key, String data) {
		this.key = key;
		this.data = data;
	}
	
	@Override
	public String toString() {
		return data;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ((obj instanceof ELEM) && key.key == ((ELEM)obj).key.key) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(key);
	}
}