package ab_01;

public class ContainerSet<ELEM> implements SET<ELEM> {
	
	public Container<ELEM> firstContainer;
	public Container<ELEM> lastContainer;
	public int size;
	
	public ContainerSet() {
		// TODO Auto-generated constructor stub
		this.firstContainer =  new Container<ELEM>(this.lastContainer, null, null, new KEY());
		this.lastContainer = new Container<ELEM>(null, this.firstContainer, null, new KEY());
		this.size = 0;
	}

	@Override
	public POS add(ELEM elem) {
		// TODO Auto-generated method stub
		Container<ELEM> container = new Container<ELEM>(this.lastContainer, this.lastContainer.getPrev(), elem, new KEY());
		this.lastContainer.getPrev().setNext(container);
		this.lastContainer.setPrev(container);
		this.size ++;
		int counter = 0;
		while (this.firstContainer.getNext() != this.lastContainer) {
			counter ++;
		}
		POS pos = new POS();
		pos.setInteger(counter);
		return pos;
	}

	@Override
	public void delete(POS pos) {
		// TODO Auto-generated method stub
		if (pos.getInteger() <= this.size && pos.getInteger() >= 0) {
			Container<ELEM> container = this.firstContainer;
			for (int i = 0; i < pos.getInteger(); i++) {
				container = container.getNext();
			}
			container.getPrev().setNext(container.getNext());
			container.getNext().setPrev(container.getPrev());	
			this.size --;
		}
	}

	@Override
	public void delete(KEY key) {
		// TODO Auto-generated method stub
		this.delete(this.find(key));
	}

	@Override
	public POS find(KEY key) {
		// TODO Auto-generated method stub
		Container<ELEM> container = this.firstContainer;
		int counter = 0;
		while (container.getNext().getKey() != key) {
			container = container.getNext();
			counter ++;
		}
		POS pos = new POS();
		pos.setInteger(counter);
		return pos;
	}

	@Override
	public ELEM retrieve(POS pos) {
		// TODO Auto-generated method stub
		Container<ELEM> container = this.firstContainer;
		for (int i = 0; i < pos.getInteger(); i++) {
			container = container.getNext();
		}
		return container.getElem();
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		Container<ELEM> container = this.firstContainer;
		while (container.getNext() != this.lastContainer) {
			System.out.println(container.getElem().toString());
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
