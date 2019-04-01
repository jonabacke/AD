/**
 * 
 */
package seqList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import adp01.ELEM;

/**
 * @author acm901
 *
 */
class SeqListTest {

	@Test
	void addTestSimple() {
		SeqList testListe = new SeqList();
		ELEM[] testElems = new ELEM[10];
		
		for(int i = 0; i < 10; i++) {
			testElems[i] = new ELEM("Test: " + i);
			testListe.add(testElems[i]);
		}
		assertEquals(10, testListe.size());
		
		
	}
	
	@Test
	void addRetriveTest() {
		SeqList testListe = new SeqList();
		ELEM[] testElems = new ELEM[10];
		
		for(int i = 0; i < 10; i++) {
			testElems[i] = new ELEM("Test: " + i);
			testListe.add(testElems[i]);
		}
		
		Knoten<ELEM> testKnoten = testListe.head;
		ELEM testElem = new ELEM("");
		for(int i = 1; i < 10; i++) {
			testElem = testListe.retrieve(new ListPos(testListe, testKnoten));
			assertEquals(testElems[i-1], testElem);
			testKnoten = testKnoten.getNext();
		}
	}
	
	@Test
	void addUniqueTest() {
		SeqList testListe = new SeqList();
		ELEM testElem = new ELEM("Test: 0");
		
		testListe.add(testElem);
		assertEquals(1, testListe.size());
		testListe.add(testElem);
		assertEquals(1, testListe.size());
		
		testListe.delete(testElem.key);
		assertEquals(0, testListe.size());
	}
	
	@Test
	void addManySimple() {
		SeqList testListe = new SeqList();
		ELEM[] testElems = new ELEM[1000];
		
		for(int i = 0; i < 1000; i++) {
			testElems[i] = new ELEM("Test: " + i);
			testListe.add(testElems[i]);
		}
		assertEquals(1000, testListe.size());
	}
	
	@Test
	void addManyRetrive() {
		SeqList testListe = new SeqList();
		ELEM[] testElems = new ELEM[1000];
		
		for(int i = 0; i < 1000; i++) {
			testElems[i] = new ELEM("Test: " + i);
			testListe.add(testElems[i]);
		}
		assertEquals(1000, testListe.size());
		
		Knoten<ELEM> testKnoten = testListe.head;
		ELEM testElem = new ELEM("");
		for(int i = 1; i < 1000; i++) {
			testElem = testListe.retrieve(new ListPos(testListe, testKnoten));
			assertEquals(testElems[i-1], testElem);
			testKnoten = testKnoten.getNext();
		}
	}
	
	@Test
	void deleteAll() {
		SeqList testListe = new SeqList();
		ELEM[] testElems = new ELEM[11];
		
		for(int i = 1; i < 11; i++) {
			testElems[i] = new ELEM("Test: " + i);
			testListe.add(testElems[i]);
		}
		assertEquals(10, testListe.size());
		
		for(int i = 1; i < 11; i++) {
			testListe.delete(new ListPos(testListe, testListe.head.getNext()));
			assertFalse(testListe.find(testElems[i].key).getValid());
		}
	}
	
	@Test
	void findTest() {
		SeqList testListe = new SeqList();
		ELEM testElem = new ELEM("");
		
		testListe.add(testElem);
		assertTrue(testListe.find(testElem.key).getValid());
	}
	
	@Test
	void retriveTest() {
		SeqList testListe = new SeqList();
		ELEM testElem = new ELEM("Test");
		testListe.add(testElem);
		
		assertEquals(testElem, testListe.retrieve(new ListPos(testListe, testListe.head)));
	}

}
