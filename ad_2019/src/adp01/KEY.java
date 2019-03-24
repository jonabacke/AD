/**
 * 
 */
package adp01;

/**
 * Liefert einen einzigartigen Key
 * @author Fabian Erdmann
 *
 */
public class KEY {
	public int key;
	private static int keysatz;
	
	/**
	 * Erstellt einen neuen KEY mit einem einzigartigen
	 * Schlüssel
	 */
	public KEY() {
		key = keysatz;
		keysatz++;
	}
	
	public KEY(int key) {
		this.key = key;
	}
}
