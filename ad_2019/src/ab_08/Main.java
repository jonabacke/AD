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
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 8));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 10));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 11));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 9));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 5));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 4));
		baumListe.insert(new KnotenListe<Integer>(null, null, null, 7));
		bearbeiteBaum(baumListe.getHead());
		insertOrder(baumListe.getHead());
		while (true) {
		System.out.println("GEben sie 2 zahlen ein");
		int value_one = 7;
		int value_two = 10;
		Scanner scan = new Scanner(System.in);
		value_one = scan.nextInt();
		value_two = scan.nextInt();
		
		int sumValue = baumListe.getPosition(baumListe.head, value_two).getSumValue() - 
				baumListe.getPosition(baumListe.head, value_one).getSumValue() + 
				baumListe.getPosition(baumListe.head, value_one).getValue();
		System.out.println(sumValue);
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
	
	public static void insertOrder(KnotenInterface<Integer> node) {
		if (node.getLeftSon() != null)
			{
				insertOrder(node.getLeftSon());
			}
		System.out.println(node.getValue() + ", " + ((KnotenListe<Integer>) node).getSumValue());
		if (node.getRightSon() != null) 
			{
				insertOrder(node.getRightSon());
			}
	}

}
