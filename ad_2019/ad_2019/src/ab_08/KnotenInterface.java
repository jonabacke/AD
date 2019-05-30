package ab_08;

public interface KnotenInterface<T> {
	public KnotenInterface<T> getRightSon();
	public KnotenInterface<T> getLeftSon();
	public KnotenInterface<T> getFather();
	public T getValue();
}
