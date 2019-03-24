package adp01;

import seqList.SeqList;
import seqSet.SeqPos;
import seqSet.SeqSet;

public class Test {

	public static void main(String[] args) {
		SeqList testList = new SeqList();
		testList.add(new ELEM("Test"));
		testList.add(new ELEM("Test1"));
		System.out.println(testList);
		
		/*
		for (int i = 0; i < 20; i++) {
			testList.add(new ELEM("Test" + i));
		}
		
		testList.delete(new SeqPos(1));
		testList.delete(new KEY(18));
		testList.showall();
		*/
	}

}
