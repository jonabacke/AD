/**
 * 
 */
package seqSet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import adp01.ELEM;
import seqList.ListPos;
import seqList.SeqList;

/**
 * @author acm901
 *
 */
class SeqSetTests {
	
	@Test
	void addTestSimple() {
		SeqSet testListe = new SeqSet();
		ELEM[] testElems = new ELEM[10];
		
		for(int i = 0; i < 10; i++) {
			testElems[i] = new ELEM("Test: " + i);
			testListe.add(testElems[i]);
		}
		assertEquals(10, testListe.size());
		
		
	}
	
	@Test
	void addRetriveTest() {
		SeqSet testListe = new SeqSet();
		ELEM[] testElems = new ELEM[10];
		
		for(int i = 0; i < 10; i++) {
			testElems[i] = new ELEM("Test: " + i);
			testListe.add(testElems[i]);
		}
		
		ELEM testElem = new ELEM("");
		for(int i = 1; i < 10; i++) {
			testElem = testListe.retrieve(new SeqPos(i));
			assertEquals(testElem, testElems[i-1]);
		}
	}
	
	@Test
	void addUniqueTest() {
		SeqSet testListe = new SeqSet();
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
		SeqSet testListe = new SeqSet();
		ELEM[] testElems = new ELEM[1000];
		
		for(int i = 0; i < 1000; i++) {
			testElems[i] = new ELEM("Test: " + i);
			testListe.add(testElems[i]);
		}
		assertEquals(1000, testListe.size());
	}
	
	@Test
	void addManyRetrive() {
		SeqSet testListe = new SeqSet();
		ELEM[] testElems = new ELEM[1000];
		
		for(int i = 0; i < 1000; i++) {
			testElems[i] = new ELEM("Test: " + i);
			testListe.add(testElems[i]);
		}
		assertEquals(1000, testListe.size());
		
		ELEM testElem = new ELEM("");
		for(int i = 1; i < 1001; i++) {
			testElem = testListe.retrieve(new SeqPos(i));
			assertEquals(testElem, testElems[i-1]);
		}
	}
	
	@Test
	void deleteAll() {
		SeqSet testListe = new SeqSet();
		ELEM[] testElems = new ELEM[11];
		
		for(int i = 1; i < 11; i++) {
			testElems[i] = new ELEM("Test: " + i);
			testListe.add(testElems[i]);
		}
		assertEquals(10, testListe.size());
		
		for(int i = 1; i < 11; i++) {
			testListe.delete(new SeqPos(1));
			assertFalse(testListe.find(testElems[i].key).getValid());
		}
	}
	
	@Test
	void findTest() {
		SeqSet testListe = new SeqSet();
		ELEM testElem = new ELEM("");
		
		testListe.add(testElem);
		assertTrue(testListe.find(testElem.key).getValid());
	}
	
	@Test
	void retriveTest() {
		SeqSet testListe = new SeqSet();
		ELEM testElem = new ELEM("Test");
		testListe.add(testElem);
		
		assertEquals(testElem, testListe.retrieve(testListe.find(testElem.key)));
	}
}
