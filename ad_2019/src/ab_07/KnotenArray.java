package ab_07;

public class KnotenArray<T extends Comparable<T>> implements KnotenInterface<T>, Comparable<KnotenArray<T>>{
	private BaumArray<T> root;
	private T daten;
	
	public KnotenArray(BaumArray<T> root, T daten) {
		this.root = root;
		this.daten = daten;
	}
	
	public KnotenArray(T daten) {
		this.daten = daten;
	}

	public void setRoot(BaumArray<T> root) {
		this.root = root;
	}
	
	@Override
	public KnotenInterface<T> getRightSon() {
		int index = root.arrayList.indexOf(this);
		return root.arrayList.get(2*index+2);
	}

	@Override
	public KnotenInterface<T> getLeftSon() {
		int index = root.arrayList.indexOf(this);
		return root.arrayList.get(2*index+1);
	}

	@Override
	public KnotenInterface<T> getFather() {
		int index = root.arrayList.indexOf(this);
		return root.arrayList.get((index-1)/2);
	}

	@Override
	public T getValue() {
		return daten;
	}
	
	@Override
	public int compareTo(KnotenArray<T> o) {
		return  this.getValue().compareTo(o.getValue());
	}

}
