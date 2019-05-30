package ab_01;

public class POS {

	private int positionInteger;
	
	public POS() {
		// TODO Auto-generated constructor stub
		this.setInteger(-1);
	}
	
	public POS(int i) {
		this.setInteger(i);
	}
	
	public void setInteger(int pos) {
		this.positionInteger = pos;
	}
	
	public int getInteger() {
		return this.positionInteger;
	}
}
