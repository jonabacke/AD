package ab_05;

public class MergeInsertion {
	
	int[]nummern;
	
	int counterMergeInsertionSort = 0;
	int counterMergeInsertionSort2 = 0;
	
    public void sort(int[] values) {
        if (values ==null || values.length==0){
            return;
        }
        int [] numbers = values;

        numbers = mergeInsertionSort2(numbers, values.length);
        numbers = mergeInsertionSort(numbers);
        this.nummern = values;
        System.out.println("CounterMergeInserSort: " + counterMergeInsertionSort);
        System.out.println("CounterMergeInserSort: " + counterMergeInsertionSort2);
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
    
    private int[] mergeInsertionSort2(int [] array, int length) {
    	if (length < 2) {
    		return array;
		}
    	else {
			int k = array.length % 2;
			int [] arrayLinks = new int [array.length];
			int [] arrayRechts = new int [array.length];
    		for (int i = array.length - 1, j = array.length - 1; i >= array.length - length; i--, i--, j--) {
    			if (array[i] < array[i - 1]) {
					arrayLinks[j] = array[i];
					arrayRechts[j] = array[i - 1];
				}
    			else {
					arrayLinks[j] = array[i - 1];
					arrayRechts[j] = array[i];
				}
    			counterMergeInsertionSort2++;
			}
    		if (k == 1) {
				arrayLinks[arrayLinks.length - 1] = array[array.length - 1];
			}
    		
    		arrayRechts = mergeInsertionSort2(arrayRechts, length / 2);
    		length = length / 2;
    		int arrRechts = arrayRechts.length;
    		int arrLinksLength = length;
    		
    		for (
    				int i = arrayRechts.length - 2; 
    				i >= arrayRechts.length - length; 
    				i--
    			) {
					int j = i - 1;
					while (arrLinksLength > 0) {
						arrayRechts = insert(arrayRechts, j, arrayLinks[arrayLinks.length - arrLinksLength]);	
						arrLinksLength --;
						j ++;
					}
				}
    		
    		
    		
    		
    		
        	return arrayRechts;
    	}
		
    }
    
    
	public int[] switches(int [] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
		return numbers;
	}
	
    public int[] insert(int [] numbers, int stelle, int nummer) {
    	if (numbers[stelle] == 0) {
		
    		numbers[stelle] = nummer;
			return numbers;
		}
    	else if (numbers[stelle] < nummer) {
			numbers = insert(numbers, stelle - 1, numbers[stelle]);
			numbers[stelle] = nummer;
		} else {
			numbers = insert(numbers, stelle - 1, nummer);
		}
    	return numbers;
    } 
    
    

    private int[] mergeInsertionSort3(int [] array) {
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