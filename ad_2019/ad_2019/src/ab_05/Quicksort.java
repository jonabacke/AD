package ab_05;

public class Quicksort  {
    private int[] numbers;
    private int number;
    private int counterRechts;
    private int counterMedian;
    private int counterZufaellig;
    

    public void sort(int[] values) {
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksortRechts(0, number - 1);
        this.numbers = values;
        quicksortMedian(0, number - 1);
        this.numbers = values;
        quicksortZufaellig(0, number - 1);
        System.out.println("CounterRechts: " + counterRechts);
        System.out.println("CounterMedian: " + counterMedian);
        System.out.println("CounterZufaellig: " + counterZufaellig);
    }

    private void quicksortRechts(int low, int high) {
        int i = low, j = high;
        int pivot = numbers[high];

        while (i <= j) {
        	counterRechts ++;
            while (numbers[i] < pivot) {
            	counterRechts ++;
                i++;
            }
            while (numbers[j] > pivot) {
            	counterRechts ++;
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (low < j)
        	quicksortRechts(low, j);
        if (i < high)
        	quicksortRechts(i, high);
    }
    
    private void quicksortMedian(int low, int high) {
        int i = low, j = high, median = low + (high-low)/2;
        int pivot;
        if(i < j && i > median) {  
        	pivot = numbers[i];
        	}

        if(j < i && j > median) { 
        	pivot = numbers[j];
        	}
        else {
        	pivot = numbers[median];
        	}

        while (i <= j) {
        	counterMedian ++;
            while (numbers[i] < pivot) {
            	counterMedian ++;
                i++;
            }
            while (numbers[j] > pivot) {
            	counterMedian ++;
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (low < j)
        	quicksortMedian(low, j);
        if (i < high)
        	quicksortMedian(i, high);
    }
    
    private void quicksortZufaellig(int low, int high) {
        int i = low, j = high;
        int pivot = numbers[(int) (Math.random() * high)];

        while (i <= j) {
        	counterZufaellig ++;
            while (numbers[i] < pivot) {
            	counterZufaellig ++;
                i++;
            }
            while (numbers[j] > pivot) {
            	counterZufaellig ++;
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (low < j)
        	quicksortZufaellig(low, j);
        if (i < high)
        	quicksortZufaellig(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
