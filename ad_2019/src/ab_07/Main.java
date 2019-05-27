package ab_07;

import java.util.Random;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BaumArray<Integer> testArray = new BaumArray<Integer>();
		Random rnd = new Random();
		
		for (int i = 0; i < 10; i++) {
			testArray.insert(new KnotenArray<Integer>(testArray, rnd.nextInt(100)));
		}

		
		
		int i = 0;
		boolean ergebnis = true;
		do {
			if (testArray.arrayList.get(i).compareTo(testArray.arrayList.get(i+1)) > 0) {
				ergebnis = false;
			}
			i++;
		} while (ergebnis && i < testArray.arrayList.size() - 1);
		
		System.out.println(ergebnis);
	}

}
