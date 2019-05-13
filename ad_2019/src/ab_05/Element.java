package ab_05;

import java.util.Random;

public class Element {

	public int key;

	public Element() {
		key = 0;
		set_key();
	}

	public int get_key() {
		return key;
	}

	public void set_key() {
		this.key = randomkey();
	}
	
	public void set_keyselbst(int keyy) {
		this.key = keyy;
	}
	
	public int randomkey() {
		Random r = new Random();
		return r.nextInt(100);
	}


}
