package ab_01;

public class ArraySet<ELEM> implements SET<ELEM> {
	
	private Container<ELEM> [] arr;
	private int size;
	
	@SuppressWarnings("unchecked")
	public ArraySet() {
		// TODO Auto-generated constructor stub
		this.arr = new Container[15];
		this.size = 0;
	}
	
	@SuppressWarnings("unchecked")
	public ArraySet(int size) {
		// TODO Auto-generated constructor stub
		this.arr = new Container[size];
		this.size = 0;
	}

	@Override
	public POS add(ELEM elem) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.size; i++) {
			if (this.arr[i].getElem().equals(elem)) {
				System.out.println("Element bereits in dem Set vorhanden");
				return null;
			}
		}
		POS pos = new POS();
		for (int i = 0; i < this.arr.length; i++) {
			if (this.arr[i] == null) {
				this.arr[i] = new Container<ELEM>(null, null, elem, new KEY());
				this.size ++;
				pos.setInteger(i);
				return pos;
			}
		}
		if (pos.getInteger() == -1) {
			@SuppressWarnings("unchecked")
			Container<ELEM> [] arr2 = new Container[this.size * 2]; 
			for (int i = 0; i < arr.length; i++) {
				arr2[i] = this.arr[i];
			}
			this.arr = arr2;
			for (int i = 0; i < this.arr.length; i++) {
				if (this.arr[i] == null) {
					this.arr[i] = new Container<ELEM>(null, null, elem, new KEY());
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
			this.arr[i] = this.arr[i + 1];
		}
		this.size --;
	}

	@Override
	public void delete(KEY key) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.size; i++) {
			if (this.arr[i].getKey().equals(key)) {
				this.arr[i] = null;
				for (int j = i; j < this.size; i++) {
					this.arr[j] = this.arr[j + 1];
				}
			}
		}
	}

	@Override
	public POS find(KEY key) {
		// TODO Auto-generated method stub
		POS pos = new POS();
		for (int i = 0; i < this.size; i++) {
			if (this.arr[i].getKey().equals(key)) {
				pos.setInteger(i);
			}
		}
		return pos;
	}

	@Override
	public ELEM retrieve(POS pos) {
		// TODO Auto-generated method stub
		return this.arr[pos.getInteger()].getElem();
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
		SET<ELEM> set = new ArraySet<ELEM>(s.size() + t.size());
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
