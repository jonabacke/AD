package ab_09;

public class Container {
	
	boolean gesetzt = false;
	int randemenge;
	Container vorgänger;
	
	int value = 0;
	
	public Container(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
		this.randemenge = value;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public boolean getGesetzt() {
		// TODO Auto-generated method stub
		return this.gesetzt;
	}
	public void setGesetzt(boolean gesetzt) {
		this.gesetzt = gesetzt;
	}
	public int getRandemenge() {
		return randemenge;
	}
	public void setRandemenge(int randemenge) {
		this.randemenge = randemenge;
	}
	public Container getVorgänger() {
		return vorgänger;
	}
	public void setVorgänger(Container vorgänger) {
		this.vorgänger = vorgänger;
	}

}
