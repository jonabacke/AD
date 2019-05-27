package ab_07;

public class KnotenListe<T extends Comparable<T>> implements KnotenInterface<T>, Comparable<KnotenListe<T>> {
	
	KnotenListe<T> rightSon;
	KnotenListe<T> leftSon;
	KnotenListe<T> father;
	T value;
	
	public KnotenListe(KnotenListe<T> rightSon, KnotenListe<T> leftSon, KnotenListe<T> father, T value) {
		// TODO Auto-generated constructor stub
		this.rightSon = rightSon;
		this.leftSon = leftSon;
		this.father = father;
		this.value = value;
	}

	@Override
	public KnotenListe<T> getRightSon() {
		// TODO Auto-generated method stub
		return this.rightSon;
	}
	
	public void setRightSon(KnotenListe<T> knoten) {
		this.rightSon = knoten;
	}

	@Override
	public KnotenListe<T> getLeftSon() {
		// TODO Auto-generated method stub
		return this.leftSon;
	}
	
	public void setLeftSon(KnotenListe<T> knoten) {
		this.leftSon = knoten;
	}

	@Override
	public KnotenListe<T> getFather() {
		// TODO Auto-generated method stub
		return this.father;
	}
	
	public void setFather(KnotenListe<T> knoten) {
		this.father = knoten;
	}
	
	public T getValue() {
		return this.value;
	}

	@Override
	public int compareTo(KnotenListe<T> o) {
		// TODO Auto-generated method stub
		return  this.getValue().compareTo(o.getValue());
	}

}
