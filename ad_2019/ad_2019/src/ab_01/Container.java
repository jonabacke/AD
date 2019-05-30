package ab_01;

public class Container<ELEM> {
	
	private Container<ELEM> next;
	private Container<ELEM> prev;
	private ELEM element;
	private KEY key;
	
	public Container(Container<ELEM> prev, Container<ELEM> next, ELEM element, KEY key) {
		// TODO Auto-generated constructor stub
		this.next = next;
		this.prev = prev;
		this.element = element;
		this.key = key;
	}
	
	public Container<ELEM> getPrev() {
		return this.prev;
	}
	
	public Container<ELEM> getNext() {
		return this.next;
	}
	
	public void setPrev(Container<ELEM> prev) {
		this.prev = prev;
	}
	
	public void setNext(Container<ELEM> next) {
		this.next = next;
	}
	
	public ELEM getElem() {
		return element;
	}
	
	public KEY getKey() {
		return this.key;
	}
}
