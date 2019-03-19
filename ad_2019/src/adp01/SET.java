package adp01;

public interface SET<p> {
	public POS add(ELEM elem);
	public void delete(POS pos);
	public void delete(int key);
	public POS find(int key);
	public ELEM retrieve(POS pos);
	public void showall();
	public int size();
	public SET<p> unify(SET<p> s, SET<p> t);
}
