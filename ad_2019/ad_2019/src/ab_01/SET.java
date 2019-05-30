package ab_01;

public interface SET<ELEM> {
	public POS add(ELEM elem);
	public void delete(POS pos);
	public void delete(KEY key);
	public POS find(KEY key);
	public ELEM retrieve(POS pos);
	public void showAll();
	public int size();
	public SET<ELEM> unify(SET<ELEM> s, SET<ELEM> t);
}
