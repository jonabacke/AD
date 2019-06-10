package ab_08;

public class BaumListe<T extends Comparable<T>> implements BaumInterface<T> {
	
	public KnotenListe<T> head;
	public int counter = 0;
	
	public BaumListe() {
		// TODO Auto-generated constructor stub
		this.head = new KnotenListe<T>(null, null, null, null);
	}

	@Override
	public void insert(KnotenInterface<T> knoten) {
		// TODO Auto-generated method stub
		this.insert((KnotenListe<T>)knoten, this.head, null);
	}
	
	private void insert(KnotenListe<T> knoten, KnotenListe<T> position, KnotenListe<T> father) {
		if (this.head.value == null) {
			this.head = knoten;
		} else {
			if (position == null || position.getValue() == null) {
				knoten.setFather(father);
				position = knoten;
			
				if (position.getFather().compareTo(position) < 0) {
					position.getFather().setRightSon(position);
				}
				else {
					position.getFather().setLeftSon(position);
				}
			} else {
				if (knoten.compareTo(position) < 0) {
					insert(knoten, position.getLeftSon(), position);
				}
				else {
					insert(knoten, position.getRightSon(), position);
				}
			}
		}	
	}
	
	public void add(T value) {
		KnotenListe<T> node = getPosition(this.head, value);
		this.insert(new KnotenListe<T>(null, null, node.father, value));
	}
	
	public KnotenListe<T> getPosition(KnotenListe<T> node, T value) {
		if (node.getValue() == value || (node.getLeftSon() == null && node.getRightSon() == null)) {
			counter ++;
			return node;
		} else {
			if (node.getValue().compareTo(value) < 0) {
				if (node.getRightSon() == null) {
					counter ++;
					return node;
				}
				counter ++;
				return getPosition(node.getRightSon(), value);
			} else {
				if (node.getLeftSon() == null) {
					counter ++;
					return node;
				}
				counter ++;
				return getPosition(node.getLeftSon(), value);
			}
		}
	}
	
	public KnotenInterface<T> getHead() {
		return head;
	}

}
