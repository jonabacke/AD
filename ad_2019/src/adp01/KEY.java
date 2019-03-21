/**
 * 
 */
package adp01;

/**
 * @author thund
 *
 */
public class KEY {
	private static int keysatz;
	
	public static int getKey() {
		keysatz++;
		return keysatz;
	}
}
