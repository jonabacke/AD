/**
 * 
 */
package ab_01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**
 * @author abu844
 *
 */
class ContainerTest {
	@Test
	void addTestSimple() {
		ContainerSet<String> testListe = new ContainerSet<String>();

		for(int i = 0; i < 10; i++) {
			testListe.add("Test: " + i);
		}
		assertEquals(10, testListe.size());
	}
	
	@Test
	void addRetriveTest() {
		ContainerSet<String> testListe = new ContainerSet<String>();
		String[] testElems = new String[10];
		
		for(int i = 0; i < 10; i++) {
			testElems[i] = new String("Test: " + i);
			testListe.add(testElems[i]);
		}
		
		String testElem = new String("");
		for(int i = 1; i < 10; i++) {
			testElem = testListe.retrieve(new POS(i));
			assertEquals(testElem, testElems[i-1]);
		}
	}
	
	@Test
	void addUniqueTest() {
		ContainerSet<String> testListe = new ContainerSet<String>();
		Container<String> testCon = new Container<String>(null, null, "Test", new KEY());
		
		testListe.add(testCon.getElem());
		assertEquals(1, testListe.size());
		testListe.add(testCon.getElem());
		assertEquals(1, testListe.size());
		
		testListe.delete(testCon.getKey());
		assertEquals(0, testListe.size());
	}
	
	@Test
	void addManySimple() {
		ContainerSet<String> testListe = new ContainerSet<String>();
		String[] testElems = new String[1000];
		
		for(int i = 0; i < 1000; i++) {
			testElems[i] = new String("Test: " + i);
			testListe.add(testElems[i]);
		}
		assertEquals(1000, testListe.size());
	}
	
	@Test
	void addManyRetrive() {
		ContainerSet<String> testListe = new ContainerSet<String>();
		Container<String> testCon = null;
		
		for(int i = 0; i < 1000; i++) {
			testCon = new Container<String>(null, null, "Test" + i, new KEY());
			testListe.add(testCon.getElem());
			assertEquals(testCon.getElem(), testListe.retrieve(new POS(i)));
		}
		assertEquals(1000, testListe.size());
	}
	
	@Test
	void deleteAll() {
		ContainerSet<String> testListe = new ContainerSet<String>();
		
		for(int i = 0; i < 1000; i++) {
			testListe.add("Test" + i);
		}
		assertEquals(1000, testListe.size());
		
		for(int i = 0; i < 1000; i++) {
			testListe.delete(new POS(i));
		}
		
		assertEquals(0, testListe.size());
	}
	
	@Test
	void findTest() {
		ContainerSet<String> testListe = new ContainerSet<String>();
		Container testCon = new Container<String>(null, null, "Test", new KEY());
		
		testListe.add("Test");
		assertEquals(new POS(1), testListe.find(testCon.getKey()));
	}
	
	@Test
	void retriveTest() {
		ContainerSet<String> testListe = new ContainerSet<String>();
		String testElem = new String("Test");
		testListe.add(testElem);
		
		assertEquals("Test", testListe.retrieve(new POS(1)));
	}
}
