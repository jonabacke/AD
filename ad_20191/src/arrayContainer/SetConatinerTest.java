/**
 * 
 */
package arrayContainer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import adp01.ELEM;

/**
 * PM 2 Praktikumsaufgaben
 *
 * @author Fabian Erdmann
 * @version 31.03.2019
 *
 */
class SetConatinerTest {

	@Test
	void addTestSimple() {
		SeqSetContainer testListe = new SeqSetContainer();
		ELEM[] testElems = new ELEM[10];
		
		for(int i = 0; i < 10; i++) {
			testElems[i] = new ELEM("Test: " + i);
			testListe.add(testElems[i]);
		}
		assertEquals(10, testListe.size());
		
		
	}
	
	@Test
	void addRetriveTest() {
		SeqSetContainer testListe = new SeqSetContainer();
		ELEM[] testElems = new ELEM[10];
		
		for(int i = 0; i < 10; i++) {
			testElems[i] = new ELEM("Test: " + i);
			testListe.add(testElems[i]);
		}
		
		ELEM testElem = new ELEM("");
		for(int i = 1; i < 10; i++) {
			testElem = testListe.retrieve(new SetPosContainer(i));
			assertEquals(testElem, testElems[i-1]);
		}
	}
	
	@Test
	void addUniqueTest() {
		SeqSetContainer testListe = new SeqSetContainer();
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
		SeqSetContainer testListe = new SeqSetContainer();
		ELEM[] testElems = new ELEM[1000];
		
		for(int i = 0; i < 1000; i++) {
			testElems[i] = new ELEM("Test: " + i);
			testListe.add(testElems[i]);
		}
		assertEquals(1000, testListe.size());
	}
	
	@Test
	void addManyRetrive() {
		SeqSetContainer testListe = new SeqSetContainer();
		ELEM[] testElems = new ELEM[1000];
		
		for(int i = 0; i < 1000; i++) {
			testElems[i] = new ELEM("Test: " + i);
			testListe.add(testElems[i]);
		}
		assertEquals(1000, testListe.size());
		
		ELEM testElem = new ELEM("");
		for(int i = 1; i < 1001; i++) {
			testElem = testListe.retrieve(new SetPosContainer(i));
			assertEquals(testElem, testElems[i-1]);
		}
	}
	
	@Test
	void deleteAll() {
		SeqSetContainer testListe = new SeqSetContainer();
		ELEM[] testElems = new ELEM[11];
		
		for(int i = 1; i < 11; i++) {
			testElems[i] = new ELEM("Test: " + i);
			testListe.add(testElems[i]);
		}
		assertEquals(10, testListe.size());
		
		for(int i = 1; i < 11; i++) {
			testListe.delete(new SetPosContainer(i));
			assertFalse(testListe.find(testElems[i].key).getValid());
		}
	}
	
	@Test
	void findTest() {
		SeqSetContainer testListe = new SeqSetContainer();
		ELEM testElem = new ELEM("");
		
		testListe.add(testElem);
		assertTrue(testListe.find(testElem.key).getValid());
	}
	
	@Test
	void retriveTest() {
		SeqSetContainer testListe = new SeqSetContainer();
		ELEM testElem = new ELEM("Test");
		testListe.add(testElem);
		
		assertEquals("Test", testListe.retrieve(new SetPosContainer(1)).data);
	}
}
