package ab_01;

public class Queue {
	
	private Container<Position> firstContainer;
	private Container<Position> lastContainer;
	private int length;
	
	public Queue() {
		// TODO Auto-generated constructor stub
		this.firstContainer = new Container<Position>(this.lastContainer, null, null, null);
		this.lastContainer = new Container<Position>(null, firstContainer, null, null);
		this.length = 0;
	}
	
	public void enqueue(int pos) {
		Position elem = new Position(pos);
		Container<Position> container = new Container<Position>(lastContainer, lastContainer.getPrev(), elem, null);
		this.lastContainer.getPrev().setNext(container);
		this.length ++;
	}
	
	public int dequeue() {
		int stelle = this.firstContainer.getNext().getElem().getPosition();
		firstContainer.setNext(firstContainer.getNext().getNext());
		this.length --;
		return stelle;
	}
	
	public int getLength() {
		return this.length;
	}
	

}
