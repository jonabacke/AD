package adp01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import arrayContainer.SeqSetContainer;
import arrayContainer.SetPosContainer;
import seqList.SeqList;
import seqSet.SeqPos;
import seqSet.SeqSet;

public class Test {

	public static void main(String[] args) {
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
		
		testListe.showall();
	}

}
