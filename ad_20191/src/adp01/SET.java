package adp01;

/**
 *	Interface für ein Set aus Elementen
 * @author Fabian Erdmann
 * @version 24.03.2019
 */
public interface SET {
	/**
	 * Fügt ein Element an eine Position im Set ein.
	 * Es werden keine doppelten Elemente akzeptiert.
	 * @param elem Element das Hinzugefügt werden soll
	 * @return Die Positin an der das Element hinzugefügt wurde
	 */
	public POS add(ELEM elem);
	
	/**
	 * @param pos die Position des zu Löschenden Elements
	 */
	public void delete(POS pos);
	
	/**
	 * 
	 * @param key der Key des zu löschenden Elements
	 */
	public void delete(KEY key);
	
	/**
	 * Sucht ein Element innerhalb des Sets
	 * @param key der Schlüssel des zu suchenden Elements
	 * @return die Position, an der das Element gefunden wurde
	 * 		(0 wenn Objekt nicht gefunden wurde)
	 */
	public POS find(KEY key);
	
	/**
	 * Gibt ein Element aus
	 * @param pos die Position des Elements
	 * @return das gesuchte Element
	 */
	public ELEM retrieve(POS pos);
	
	/**
	 * Gibt alle im Set enthaltenen Elemente auf der Konsole aus
	 */
	public void showall();
	
	/**
	 * 
	 * @return die groesse des Sets
	 */
	public int size();
	
	/**
	 * Vereint 2 Mengen von Sets zu einem ohne Duplikate
	 * @param s Die erste Menge
	 * @param t die zweite Menge
	 * @return das Ergebnis der Vereinigung
	 */
	public SET unify(SET s, SET t);
}
