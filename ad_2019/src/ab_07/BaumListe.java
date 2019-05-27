package ab_07;

public class BaumListe<T extends Comparable<T>> implements BaumInterface<T> {
	
	KnotenListe<T> head;
	
	public BaumListe() {
		// TODO Auto-generated constructor stub
		this.head = new KnotenListe<T>(null, null, null, null);
	}

	@Override
	public void insert(KnotenInterface<T> knoten) {
		// TODO Auto-generated method stub
		this.insert((KnotenListe<T>)knoten, this.head, null);
	}
	
	private void insert(KnotenListe<T> knoten, KnotenListe<T> head, KnotenListe<T> father) {
		if (head == null  || head.getValue() == null) {
			knoten.setFather(father);
			head = knoten;
			if (head.father.compareTo(head) < 0) {
				head.father.setRightSon(head);
			}
			else {
				head.father.setLeftSon(head);
			}
		}
		if (head.compareTo(knoten) < 0) {
			insert(knoten, head.getLeftSon(), head);
		}
		else {
			insert(knoten, head.getRightSon(), head);
		}
	}

}
