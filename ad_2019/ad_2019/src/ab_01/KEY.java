package ab_01;

public class KEY {
	
	private int keyInteger;
	private static int keys;
	
	public KEY() {
		// TODO Auto-generated constructor stub
		this.keyInteger = keys;
		keys ++;
	}
	
	public void setInteger(int key) {
		this.keyInteger = key;
	}
	
	public int getInteger() {
		return this.keyInteger;
	}

}
