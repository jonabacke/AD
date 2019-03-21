package adp01;

public interface SET<T> {	
	public POS add(ELEM elem);
	public void delete(POS pos);
	public void delete(KEY key);
	public POS find(KEY key);
	public ELEM retrieve(POS pos);
	public void showall();
	public int size();
	public SET<T> unify(SET<T> s, SET<T> t);
}
