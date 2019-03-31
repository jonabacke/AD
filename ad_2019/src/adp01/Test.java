package adp01;

import arrayContainer.SeqSetContainer;
import seqList.SeqList;
import seqSet.SeqPos;
import seqSet.SeqSet;

public class Test {

	public static void main(String[] args) {
		SeqSetContainer testList = new SeqSetContainer();

		
		
		for (int i = 0; i < 20; i++) {
			testList.add(new ELEM("Test" + i));
		}
		
		testList.delete(new SeqPos(1));
		testList.delete(new KEY(18));
		testList.delete(new KEY(15));
		testList.delete(new KEY(13));
		testList.delete(new KEY(10));
		
		for (int i = 0; i < 5; i++) {
			testList.add(new ELEM("Test" + i));
		}
		
		testList.showall();
		
	}

}
