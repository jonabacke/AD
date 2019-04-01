package ab_01;

import java.lang.reflect.Array;

public class ArrayListSet<ELEM> implements SET<ELEM> {
	
	private int size;
	private arrayListElement<ELEM> [] arrList;
	private arrayListElement<ELEM> pointerArrayListElement;
	private Queue queue;
	
	@SuppressWarnings("unchecked")
	public ArrayListSet() {
		// TODO Auto-generated constructor stub
		this.arrList = new arrayListElement[15];
		this.size = 0;
		this.queue = new Queue();
		this.pointerArrayListElement = this.arrList[0];
	}
	
	@SuppressWarnings("unchecked")
	public ArrayListSet(int size) {
		// TODO Auto-generated constructor stub
		this.arrList = new arrayListElement[size];
		this.size = 0;
		this.queue = new Queue();
		this.pointerArrayListElement = this.arrList[0];
	}

	@Override
	public POS add(ELEM elem) {
		// TODO Auto-generated method stub
		if (this.size == 0) {
			KEY key = new KEY();
			POS pos = new POS();
			arrayListElement<ELEM> element = new arrayListElement<ELEM>(null, null, elem, key);
			this.arrList[0] = element;
			this.size ++;
			this.pointerArrayListElement = element;
			pos.setInteger(0);
			return pos;
		}
		for (int i = 0; i < this.arrList.length; i++) {
			if (this.arrList[i] != null) {
				if (this.arrList[i].getElement().equals(elem)) {
					System.out.println("Element bereits in dem Set vorhanden");
					return null;
				}
			}
		}
		KEY key = new KEY();
		POS pos = new POS();
		for (int i = 0; i < this.arrList.length; i++) {
			if (this.arrList[i] == null) {
				arrayListElement<ELEM> element = new arrayListElement<ELEM>(null, this.pointerArrayListElement, elem, key);
				this.arrList[i] = element;
				this.pointerArrayListElement.setNext(element);
				this.pointerArrayListElement = element;
				pos.setInteger(i);
				this.size ++;
				return pos;				
			} else {
				continue;
			}
		}
		// kein platz im Array
		if (pos.getInteger() == -1 && this.queue.getLength() == 0) {
			@SuppressWarnings("unchecked")
			arrayListElement<ELEM>[] arrList2 = (arrayListElement<ELEM>[]) Array.newInstance(null, this.size * 2); 
			for (int i = 0; i < arrList.length; i++) {
				arrList2[i] = this.arrList[i];
			}
			this.arrList = arrList2;
			for (int i = 0; i < this.arrList.length; i++) {
				if (this.arrList[i] == null) {
					arrayListElement<ELEM> element = new arrayListElement<ELEM>(null, this.pointerArrayListElement, elem, key);
					this.arrList[i] = element;
					this.pointerArrayListElement.setNext(element);
					this.pointerArrayListElement = element;
					pos.setInteger(i);
				} else {
					continue;
				}
			}
		} else {
			arrayListElement<ELEM> element = new arrayListElement<ELEM>(null, pointerArrayListElement, elem, key);
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
		if (pos.getInteger() == 0) {
			this.arrList[pos.getInteger()] = this.arrList[pos.getInteger() + 1];
			this.arrList[pos.getInteger() + 1].setPrev(null);
			pos.setInteger(pos.getInteger());
		} else {
			this.arrList[pos.getInteger() - 1].setNext(this.arrList[pos.getInteger() + 1]);
			this.arrList[pos.getInteger() + 1].setPrev(this.arrList[pos.getInteger() - 1]);
		}
		while (this.arrList[pos.getInteger()].getNext() != null) {
			this.arrList[pos.getInteger()] = this.arrList[pos.getInteger() + 1];
			pos.setInteger(pos.getInteger() + 1);
		}
		this.size --;
		this.queue.enqueue(pos.getInteger());
	}

	@Override
	public void delete(KEY key) {
		// TODO Auto-generated method stub
		if (this.find(key).getInteger() != -1) {
			this.delete(this.find(key));	
		}
	}

	@Override
	public POS find(KEY key) {
		// TODO Auto-generated method stub
		POS pos = new POS();
		pos.setInteger(0);
		while (this.arrList[pos.getInteger()].getKey().getInteger() != key.getInteger() && 
				this.arrList[pos.getInteger()] != null) {
			pos.setInteger(pos.getInteger() + 1);
		}
		if (this.arrList[pos.getInteger()] != null) {
			return pos;
		} else {
			pos.setInteger(-1);
			return pos;
		}
	}

	@Override
	public ELEM retrieve(POS pos) {
		// TODO Auto-generated method stub
		return this.arrList[pos.getInteger()].getElement();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		arrayListElement<ELEM> element = this.pointerArrayListElement;
		while (element != null) {
			System.out.println(element.getElement().toString());
			element = (arrayListElement<ELEM>) element.getPrev();
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
