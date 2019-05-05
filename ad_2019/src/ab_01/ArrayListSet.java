package ab_01;

public class ArrayListSet<ELEM> implements SET<ELEM> {
	
	private int size;
	private Container<ELEM> [] arrList;
	private Container<ELEM> pointerArrayListElement;
	private Container<ELEM> firstContainer;
	private Queue queue;
	

	@SuppressWarnings("unchecked")
	public ArrayListSet() {
		// TODO Auto-generated constructor stub
		this.arrList = new Container[15];
		this.size = 0;
		this.queue = new Queue();
		this.firstContainer = new Container<ELEM>(null, null, null, null);
		this.pointerArrayListElement = this.arrList[0];
	}
	
	@SuppressWarnings("unchecked")
	public ArrayListSet(int size) {
		// TODO Auto-generated constructor stub
		this.arrList = new Container[size];
		this.size = 0;
		this.firstContainer = new Container<ELEM>(null, null, null, null);
		this.queue = new Queue();
		this.pointerArrayListElement = this.arrList[0];
	}

	@Override
	public POS add(ELEM elem) {
		// TODO Auto-generated method stub
		if (this.size == 0) {
			POS pos = new POS();
			Container<ELEM> element = new Container<ELEM>(this.firstContainer, null, elem, new KEY());
			this.arrList[0] = element;
			this.firstContainer.setNext(element);
			this.size ++;
			this.pointerArrayListElement = element;
			pos.setInteger(0);
			return pos;
		}
		for (int i = 0; i < this.arrList.length; i++) {
			if (this.arrList[i].getElem().equals(elem)) {
				System.out.println("Element bereits in dem Set vorhanden");
				return null;
			}
		}
		POS pos = new POS();
		for (int i = 0; i < this.arrList.length; i++) {
			if (this.arrList[i] == null) {
				Container<ELEM> element = new Container<ELEM>(this.pointerArrayListElement, null, elem, new KEY());
				this.arrList[i] = element;
				this.pointerArrayListElement.setNext(element);
				this.pointerArrayListElement = element;
				pos.setInteger(i);
				this.size ++;
				return pos;				
			}
		}
		// kein platz im Array
		if (pos.getInteger() == -1 && this.queue.getLength() == 0) {
			@SuppressWarnings("unchecked")
			Container<ELEM>[] arrList2 = new Container[this.size * 2]; 
			for (int i = 0; i < arrList.length; i++) {
				arrList2[i] = this.arrList[i];
			}
			this.arrList = arrList2;
			for (int i = 0; i < this.arrList.length; i++) {
				if (this.arrList[i] == null) {
					Container<ELEM> element = new Container<ELEM>(this.pointerArrayListElement, null, elem, new KEY());
					this.arrList[i] = element;
					this.pointerArrayListElement.setNext(element);
					this.pointerArrayListElement = element;
					pos.setInteger(i);
				}
			}
		} else {
			Container<ELEM> element = new Container<ELEM>(this.pointerArrayListElement, null, elem, new KEY());
			this.arrList[this.queue.dequeue()] = element;
			this.pointerArrayListElement.setNext(element);
			this.pointerArrayListElement = element;
		}
		this.size ++;
		return pos;
	}

	@Override
	public void delete(POS pos) {
		// TODO Auto-generated method stub
		if (this.arrList[pos.getInteger()] != null) {
			this.arrList[pos.getInteger()].getPrev().setNext(this.arrList[pos.getInteger()].getNext());
			this.arrList[pos.getInteger()].getNext().setPrev(this.arrList[pos.getInteger()].getPrev());
			this.size --;
			this.queue.enqueue(pos.getInteger());			
		}
	}

	@Override
	public void delete(KEY key) {
		// TODO Auto-generated method stub
		Container<ELEM> hilfsContainer = this.firstContainer;
		while (hilfsContainer.getNext() != null) {
			hilfsContainer = hilfsContainer.getNext();
			if (hilfsContainer.getKey().equals(key)) {
				hilfsContainer.getPrev().setNext(hilfsContainer.getNext());
				hilfsContainer.getNext().setPrev(hilfsContainer.getPrev());
				this.size --;
				for (int i = 0; i < this.arrList.length; i++) {
					if (hilfsContainer == this.arrList[i]) {
						this.queue.enqueue(i);
					}
				}
			}
		}
	}

	@Override
	public POS find(KEY key) {
		// TODO Auto-generated method stub
		POS pos = new POS();
		for (int i = 0; i < this.arrList.length; i++) {
			if (this.arrList[i].getKey().equals(key)) {
				pos.setInteger(i);
			}
		}
		return pos;
	}

	@Override
	public ELEM retrieve(POS pos) {
		// TODO Auto-generated method stub
		return this.arrList[pos.getInteger()].getElem();
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		Container<ELEM> element = this.firstContainer;
		while (element.getNext() != null) {
			element = element.getNext();
			System.out.println(element.getElem().toString());
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public SET<ELEM> unify(SET<ELEM> s, SET<ELEM> t) {
		// TODO Auto-generated method stub
		POS pos = new POS();
		pos.setInteger(0);
		ArrayListSet<ELEM> arrayList = new ArrayListSet<ELEM>(s.size() + t.size());
		while (s.retrieve(pos) != null) {
			arrayList.add(s.retrieve(pos));
			pos.setInteger(pos.getInteger() + 1);
		}
		while (t.retrieve(pos) != null) {
			arrayList.add(t.retrieve(pos));
			pos.setInteger(pos.getInteger() + 1);
		}
		return arrayList;
	}

}
