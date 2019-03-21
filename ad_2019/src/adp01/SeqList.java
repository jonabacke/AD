/**
 * 
 */
package adp01;

/**
 * ADP Praktikumsaufgabe 1
 * @author Fabian Erdmann
 *
 */
public class SeqList<T> implements SET {		
	private int maxsize = 10;
	private ELEM[] elem;
	private int listSize;
	
	public SeqList() {
		elem = new ELEM[maxsize + 1];
	}
	
	
	
	public POS add(ELEM elem) {
		listSize++;
		if (listSize > maxsize) {
			maxsize = maxsize * 2;
			
		}
		
		
		return null;
	}

	public void delete(POS pos) {
		// TODO Auto-generated method stub
		
	}

	public void delete(KEY key) {
		// TODO Auto-generated method stub
		
	}

	public POS find(KEY key) {
		// TODO Auto-generated method stub
		return null;
	}

	public ELEM retrieve(POS pos) {
		// TODO Auto-generated method stub
		return null;
	}

	public void showall() {
		// TODO Auto-generated method stub
		
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public SET unify(SET s, SET t) {
		// TODO Auto-generated method stub
		return null;
	}
}
