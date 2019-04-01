package ab_01;

import java.lang.reflect.Array;

public class arraySet<ELEM> implements SET<ELEM> {
	
	private ELEM [] arr;
	private int size;
	Class<ELEM> klasse;
	
	@SuppressWarnings("unchecked")
	public arraySet(Class<ELEM> klasse) {
		// TODO Auto-generated constructor stub
		this.arr = (ELEM[]) Array.newInstance(klasse, 15);
		this.size = 0;
		this.klasse = klasse;
	}
	
	@SuppressWarnings("unchecked")
	public arraySet(int size, Class<ELEM> klasse) {
		// TODO Auto-generated constructor stub
		this.arr = (ELEM[]) Array.newInstance(null, size);
		this.size = 0;
		this.klasse = klasse;
	}

	@Override
	public POS add(ELEM elem) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.size; i++) {
			if (this.arr[i] == elem) {
				System.out.println("Element bereits in dem Set vorhanden");
				return null;
			}
		}
		POS pos = new POS();
		for (int i = 0; i < this.arr.length; i++) {
			if (this.arr[i] == null) {
				this.arr[i] = elem;
				this.size ++;
				pos.setInteger(i);
				return pos;
			}
		}
		if (pos.getInteger() == -1) {
			@SuppressWarnings("unchecked")
			ELEM[] arr2 = (ELEM[]) Array.newInstance(this.klasse, this.size * 2); 
			for (int i = 0; i < arr.length; i++) {
				arr2[i] = this.arr[i];
			}
			this.arr = arr2;
			for (int i = 0; i < this.arr.length; i++) {
				if (this.arr[i] == null) {
					this.arr[i] = elem;
					pos.setInteger(i);
					this.size ++;
					return pos;
				}
			}
		}
		return null;
	}

	@Override
	public void delete(POS pos) {
		// TODO Auto-generated method stub
		this.arr[pos.getInteger()] = null;
		for (int i = pos.getInteger(); i < this.size; i++) {
			this.arr[i] = this.arr[i+1];
		}
		this.size --;
	}

	@Override
	public void delete(KEY key) {
		// TODO Auto-generated method stub
		POS pos = new POS();
		pos.setInteger(key.getInteger());
		delete(pos);
	}

	@Override
	public POS find(KEY key) {
		// TODO Auto-generated method stub
		POS pos = new POS();
		pos.setInteger(key.getInteger());
		return pos;
	}

	@Override
	public ELEM retrieve(POS pos) {
		// TODO Auto-generated method stub
		return this.arr[pos.getInteger()];
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.size; i++) {
			System.out.println(this.arr[i].toString());	
		}
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size();
	}

	@Override
	public SET<ELEM> unify(SET<ELEM> s, SET<ELEM> t) {
		// TODO Auto-generated method stub
		SET<ELEM> set = new arraySet<ELEM>(s.size() + t.size(), this.klasse);
		POS pos = new POS();
		pos.setInteger(0);
		while (s.retrieve(pos) != null) {
			set.add(s.retrieve(pos));
			pos.setInteger(pos.getInteger() + 1);
		}
		pos.setInteger(0);
		while (t.retrieve(pos) != null) {
			set.add(t.retrieve(pos));
			pos.setInteger(pos.getInteger() + 1);
		}
		return set;
	}

}
