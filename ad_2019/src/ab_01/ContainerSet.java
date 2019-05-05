package ab_01;

public class ContainerSet<ELEM> implements SET<ELEM> {
	
	public Container<ELEM> firstContainer;
	public Container<ELEM> lastContainer;
	public int size;
	public long count;
	
	public ContainerSet() {
		// TODO Auto-generated constructor stub
		this.firstContainer =  new Container<ELEM>(null, null, null, new KEY());
		this.lastContainer = new Container<ELEM>(null, null, null, new KEY());
		this.firstContainer.setNext(lastContainer);
		this.lastContainer.setPrev(firstContainer);
		this.size = 0;
	}

	@Override
	public POS add(ELEM elem) {
		Container<ELEM> iteratorContainerSet = this.firstContainer;
		while (iteratorContainerSet.getNext() != null) {
			if (iteratorContainerSet.getElem() == elem) {
				System.out.println("Element bereits in dem Set vorhanden");
				return null;
			}
			iteratorContainerSet = iteratorContainerSet.getNext();
			this.count ++;
		}
		Container<ELEM> container = new Container<ELEM>(this.lastContainer.getPrev(), this.lastContainer, elem, new KEY());
		this.lastContainer.getPrev().setNext(container);
		this.lastContainer.setPrev(container);
		this.size ++;
		int counter = 0;
		iteratorContainerSet = this.firstContainer.getNext();
		while (iteratorContainerSet != this.lastContainer) {
			counter ++;
			iteratorContainerSet = iteratorContainerSet.getNext();
			this.count ++;
		}
		POS pos = new POS();
		pos.setInteger(counter);
		return pos;
	}

	@Override
	public void delete(POS pos) {
		// TODO Auto-generated method stub
		if (pos.getInteger() <= this.size && pos.getInteger() >= 0) {
			Container<ELEM> container = this.firstContainer.getNext();
			for (int i = 0; i < pos.getInteger() - 1; i++) {
				container = container.getNext();
				this.count ++;
			}
			container.getPrev().setNext(container.getNext());
			container.getNext().setPrev(container.getPrev());	
			this.size --;
		} else {
			System.err.println(pos.getInteger());
		}
	}

	@Override
	public void delete(KEY key) {
		// TODO Auto-generated method stub
		Container<ELEM> iteratorContainer = this.firstContainer.getNext();
		while (iteratorContainer.getKey() != key || iteratorContainer == lastContainer) {
			iteratorContainer = iteratorContainer.getNext();
			count ++;
		}
		if (iteratorContainer == lastContainer) {
			System.err.println("key nicht gefunden");
		} else {
			iteratorContainer.getNext().setPrev(iteratorContainer.getNext());
			iteratorContainer.getPrev().setNext(iteratorContainer.getPrev());
			this.size --;
		}
	}

	@Override
	public POS find(KEY key) {
		// TODO Auto-generated method stub
		Container<ELEM> container = this.firstContainer;
		int counter = 0;
		while (container.getNext().getKey() != key) {
			container = container.getNext();
			counter ++;
			this.count ++;
		}
		POS pos = new POS();
		pos.setInteger(counter);
		return pos;
	}

	@Override
	public ELEM retrieve(POS pos) {
		// TODO Auto-generated method stub
		Container<ELEM> container = this.firstContainer.getNext();
		for (int i = 0; i < pos.getInteger(); i++) {
			container = container.getNext();
		}
		return container.getElem();
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		Container<ELEM> container = this.firstContainer.getNext();
		while (container != this.lastContainer) {
			System.out.println(container.getElem().toString());
			container = container.getNext();
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
		ContainerSet<ELEM> set = new ContainerSet<ELEM>();
		POS pos = new POS();
		for (int i = 1; i <= s.size(); i++) {
			pos.setInteger(i);
			set.add(s.retrieve(pos));
		}
		for (int i = 1; i <= t.size(); i++) {
			pos.setInteger(i);
			set.add(t.retrieve(pos));
		}
		return set;
	}

}
