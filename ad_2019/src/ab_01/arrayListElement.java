package ab_01;

public class arrayListElement<ELEM> {
	
	private arrayListElement<?> next;
	private arrayListElement<?> prev;
	private ELEM element;
	private KEY key;

	public arrayListElement(arrayListElement<ELEM> next, arrayListElement<ELEM> prev, ELEM element, KEY key) {
		// TODO Auto-generated constructor stub
		this.next = next;
		this.prev = prev;
		this.element = element;
		this.key = key;
	}
	
	public arrayListElement<?> getPrev() {
		return this.prev;
	}
	public arrayListElement<?> getNext() {
		return this.next;
	}
	public void setPrev(arrayListElement<?> prev) {
		this.prev = prev;
	}
	public void setNext(arrayListElement<?> next) {
		this.next = next;
	}
	public void setElement(ELEM element) {
		this.element = element;
	}
	public ELEM getElement() {
		return this.element;
	}
	public KEY getKey() {
		return key;
	}
}
