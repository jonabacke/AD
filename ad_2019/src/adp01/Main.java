package adp01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import arrayContainer.SeqSetContainer;
import arrayContainer.SetPosContainer;
import seqList.ListPos;
import seqList.SeqList;
import seqSet.SeqPos;
import seqSet.SeqSet;

public class Main {
	private static int n = 100;
	public static void main(String[] args) {		
		testSeqSetKey(n);
		testSeqSetPos(n);
		
		testArrayContainerKey(n);
		testArrayContainerPos(n);
		
		testSeqListKey(n);
		testSeqListPos(n);
	}
/////////////////////////////////////TEST 1//////////////////////////////
	public static void testSeqSetKey(int n) {
		SeqSet testList = new SeqSet();
		ELEM[] testElems = new ELEM[n];
		
		for (int i = 0; i < n; i++) {
			testElems[i] = new ELEM("Test" + i);
		}
		
		for (int i = 0; i < n; i++) {
			testList.add(testElems[i]);
		}
		
		for (int i = 0; i < n; i++) {
			testList.delete(testElems[i].key);
		}
		System.out.print("Test 1: Delete mit KEY, Counter: ");
		System.out.println(testList.getCounter());
	}
	
	public static void testSeqSetPos(int n) {
		SeqSet testList = new SeqSet();
		ELEM[] testElems = new ELEM[n];
		
		for (int i = 0; i < n; i++) {
			testElems[i] = new ELEM("Test" + i);
		}
		
		for (int i = 0; i < n; i++) {
			testList.add(testElems[i]);
		}
		
		for (int i = 0; i < n; i++) {
			testList.delete(new SeqPos(i));
		}
		System.out.print("Test 1: Delete mit POS, Counter: ");
		System.out.println(testList.getCounter());
	}
	
//////////////////////////////TEST 2///////////////////////////////////////////
	public static void testArrayContainerKey(int n) {
		SeqSetContainer testList = new SeqSetContainer();
		ELEM[] testElems = new ELEM[n];
		
		for (int i = 0; i < n; i++) {
			testElems[i] = new ELEM("Test" + i);
		}
		
		for (int i = 0; i < n; i++) {
			testList.add(testElems[i]);
		}
		
		for (int i = 0; i < n; i++) {
			testList.delete(testElems[i].key);
		}
		System.out.print("Test 2: Delete mit KEY, Counter: ");
		System.out.println(testList.getCounter());
	}
	
	public static void testArrayContainerPos(int n) {
		SeqSetContainer testList = new SeqSetContainer();
		ELEM[] testElems = new ELEM[n];
		
		for (int i = 0; i < n; i++) {
			testElems[i] = new ELEM("Test" + i);
		}
		
		for (int i = 0; i < n; i++) {
			testList.add(testElems[i]);
		}
		
		for (int i = 0; i < n; i++) {
			testList.delete(new SetPosContainer(i));
		}
		System.out.print("Test 2: Delete mit POS, Counter: ");
		System.out.println(testList.getCounter());
	}
	
///////////////////////////////TEST 3/////////////////////////////////////////////
	public static void testSeqListKey(int n) {
		SeqList testList = new SeqList();
		ELEM[] testElems = new ELEM[n];
		
		for (int i = 0; i < n; i++) {
			testElems[i] = new ELEM("Test" + i);
		}
		
		for (int i = 0; i < n; i++) {
			testList.add(testElems[i]);
		}
		
		for (int i = 0; i < n; i++) {
			testList.delete(testElems[i].key);
		}
		System.out.print("Test 3: Delete mit key, Counter: ");
		System.out.println(testList.getCounter());
	}
	
	public static void testSeqListPos(int n) {
		SeqList testList = new SeqList();
		ELEM[] testElems = new ELEM[n];
		
		for (int i = 0; i < n; i++) {
			testElems[i] = new ELEM("Test" + i);
		}
		
		for (int i = 0; i < n; i++) {
			testList.add(testElems[i]);
		}
		
		for (int i = 0; i < n; i++) {
			testList.delete(new ListPos(testList, testList.head.getNext()));
		}
		System.out.print("Test 3: Delete mit POS, Counter: ");
		System.out.println(testList.getCounter());
	}
}
