package ab_05;

public class MergeInsertion {
	
	int [] numbers;
	int number;
	int counterMergeInsertionSort = 0;
	
    public void sort(int[] values) {
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        number = values.length;
        numbers = mergeInsertionSort(this.numbers);
        System.out.println("CounterMergeInserSort: " + counterMergeInsertionSort);
    }
    
    private int[] mergeInsertionSort(int [] array) {
    	if (array.length < 2) {
    		return array;
		}
    	else {
			int k = array.length % 2;
			int [] arrayLinks = new int [array.length / 2 + k];
			int [] arrayRechts = new int [array.length / 2];
    		for (int i = 0; i < array.length / 2; i++) {
    			if (array[2 * i] < array[2 * i + 1]) {
					arrayLinks[i] = array[2 * i];
					arrayRechts[i] = array[2 * i + 1];
				}
    			else {
					arrayLinks[i] = array[2 * i + 1];
					arrayRechts[i] = array[2 * i];
				}
    			counterMergeInsertionSort++;
			}
    		if (k == 1) {
				arrayLinks[arrayLinks.length - 1] = array[array.length - 1];
			}
    		arrayLinks = mergeInsertionSort(arrayLinks);
    		arrayRechts = mergeInsertionSort(arrayRechts);
    		int []arrayFertig = new int [arrayRechts.length + arrayLinks.length];
    		int arrFertig = arrayFertig.length;
    		int arrRechts = arrayRechts.length;
    		int arrLinks = arrayLinks.length;
    		while (arrFertig > 0) {
				while (arrRechts > 0) {
					if (arrayRechts[arrRechts - 1] > arrayLinks[arrLinks - 1]) {
						arrayFertig[arrFertig - 1] = arrayRechts[arrRechts - 1];
						arrRechts --;
						arrFertig --;
					}
					else {
						arrayFertig[arrFertig - 1] = arrayLinks[arrLinks - 1];
						arrLinks --;
						arrFertig --;
					}
					counterMergeInsertionSort ++;
				}
				while (arrLinks > 0) {
					arrayFertig[arrFertig - 1] = arrayLinks[arrLinks - 1];
					arrLinks --;
					arrFertig --;					
					counterMergeInsertionSort ++;
				}
			}
        	return arrayFertig;
		}
    }
}