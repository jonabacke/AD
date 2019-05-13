package ab_05;

public class Sort {
	
	int [] numbers;
	int number;
	int counterInsertSort;
	
    public void sort(int[] values) {
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        number = values.length;
        insertSort();
 //       System.out.println("CounterInserSort: " + counterInsertSort);
    }
	public int getCounterInsertSort() {
		return counterInsertSort;
	}
	public void switches(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
    public void insertSort() {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers.length-1; j > 0; j--) {
                if (numbers[j-1] > numbers[j]) {
                    switches(j, j - 1);
                }
                counterInsertSort ++;
            }
        }
    } 

}
