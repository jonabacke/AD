/**
 * 
 */
package ab_08;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * PM 2 Praktikumsaufgaben
 *
 * @author Fabian Erdmann, Jonathan Backes
 * @version 12.05.2019
 *
 */
public class Main {
	
	private static int sum = 0;

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
		
		BaumListe<Integer> baumListe = new BaumListe<Integer>();
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 50));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 75));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 25));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 13));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 38));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 63));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 83));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 6));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 18));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 28));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 42));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 58));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 68));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 82));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 95));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 0));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 100));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 90));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 80));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 40));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 70));
		bearbeiteBaum(baumListe.getHead());
		insertOrder(baumListe.getHead());
		while (true) {
		System.out.println("Geben sie 2 zahlen ein");
		int value_one = 7;
		int value_two = 10;
		Scanner scan = new Scanner(System.in);
		value_one = scan.nextInt();
		value_two = scan.nextInt();
		baumListe.counter = 0;
		int sumValue = baumListe.getPosition(baumListe.head, value_two).getSumValue() - 
				baumListe.getPosition(baumListe.head, value_one).getSumValue() + 
				baumListe.getPosition(baumListe.head, value_one).getValue();
		System.out.println("Summe = " + sumValue + " Counter = " + baumListe.counter);
		}
		
	}
	
	public static void bearbeiteBaum(KnotenInterface<Integer> node) {
		if (node.getLeftSon() != null)
		{
			bearbeiteBaum(node.getLeftSon());
		}
		sum = sum + (int) node.getValue();
		((KnotenListe<Integer>) node).setSumValue(sum);
		if (node.getRightSon() != null) 
		{
			bearbeiteBaum(node.getRightSon());
		}
	}
	
	public static int searchInsertOrder(KnotenInterface<Integer> node, int value) {
		if (node.getValue() > value && node.getLeftSon() != null) {
			return searchInsertOrder(node.getLeftSon(), value);
		} else if (node.getValue() < value && node.getRightSon() != null) {
			return searchInsertOrder(node.getRightSon(), value);
		} else {
			return node.getValue();
		}
	}
	
	public static void insertOrder(KnotenInterface<Integer> node) {
		if (node.getLeftSon() != null)
			{
				insertOrder(node.getLeftSon());
			}
		System.out.println(
				"Knotenwert : " + node.getValue() 
				+ ", " + 
				"Zusatzinformation: " +((KnotenListe<Integer>) node).getSumValue());
		if (node.getRightSon() != null) 
			{
				insertOrder(node.getRightSon());
			}
	}

}
