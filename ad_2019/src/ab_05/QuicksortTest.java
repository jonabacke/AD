package ab_05;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class QuicksortTest {

    private int[] numbers;
    private final static int SIZE = 1000000;
    private final static int MAX = 10000000;
    private long counterRechts;
    private long counterMedian;
    private long counterZufaellig;
	private long counterMergeInsertionSort;
	private long counter;
	private long counterInsertSort;

    private long timercounterRechts;
    private long timercounterMedian;
    private long timercounterZufaellig;
	private long timercounterMergeInsertionSort;
	private long timercounter;
	private long timercounterInsertSort;

    @BeforeEach
    public void setUp() throws Exception {
        numbers = new int[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX) + 7000;
        }
    }

//    @org.junit.jupiter.api.Test
//    public void testNull() {
//        Quicksort sorter = new Quicksort();
//        sorter.sort(null);
//    }

//    @org.junit.jupiter.api.Test
//    public void testEmpty() {
//        Quicksort sorter = new Quicksort();
//        sorter.sort(new int[0]);
//    }

//    @org.junit.jupiter.api.Test
//    public void testSimpleElement() {
//        Quicksort sorter = new Quicksort();
//        int[] test = new int[1];
//        test[0] = 5;
//        sorter.sort(test);
//    }

//    @org.junit.jupiter.api.Test
//    public void testSpecial() {
//        Quicksort sorter = new Quicksort();
//        int[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
//        sorter.sort(test);
//        if (!validate(test)) {
//            fail("Should not happen");
//        }
//        printResult(test);
//    }

    @org.junit.jupiter.api.Test
    public void testQuickSortRechts() {
//        for (Integer i : numbers) {
//            System.out.println(i + " ");
//        }
    	for (int i = 0; i < 100; i++) {
            long startTime = System.currentTimeMillis();

            Quicksort sorter = new Quicksort();
            sorter.sortRechts(numbers);

            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
//            System.out.println("Quicksort " + elapsedTime);
      //      printResult(numbers);
            this.timercounterRechts = this.timercounterRechts + elapsedTime;
            this.counterRechts = this.counterRechts + sorter.getCounterRechts();
            if (!validate(numbers)) {
                fail("Should not happen");
            }
            assertTrue(true);
			
		}
    	System.out.println("QuickRechtsCounterAVG: " + this.counterRechts / 100);
    	System.out.println("QuickRechtsTimerAVG: " + this.timercounterRechts / 100);
    }

    @org.junit.jupiter.api.Test
    public void testQuickSortMedian() {
//        for (Integer i : numbers) {
//            System.out.println(i + " ");
//        }
    	for (int i = 0; i < 100; i++) {
            long startTime = System.currentTimeMillis();

            Quicksort sorter = new Quicksort();
            sorter.sortMedian(numbers);

            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
 //           System.out.println("Quicksort " + elapsedTime);
     //       printResult(numbers);
            this.timercounterMedian = this.timercounterMedian + elapsedTime;
            this.counterMedian = this.counterMedian + sorter.getCounterMedian();

            if (!validate(numbers)) {
                fail("Should not happen");
            }
            assertTrue(true);
			
		}
    	System.out.println("QuickMedianCounterAVG: " + this.counterMedian / 100);
    	System.out.println("QuickMedianTimerAVG: " + this.timercounterMedian / 100);
    }

    @org.junit.jupiter.api.Test
    public void testQuickSortZufall() {
//        for (Integer i : numbers) {
//            System.out.println(i + " ");
//        }
    	for (int i = 0; i < 100; i++) {
            long startTime = System.currentTimeMillis();

            Quicksort sorter = new Quicksort();
            sorter.sortZufall(numbers);

            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
 //           System.out.println("Quicksort " + elapsedTime);
//            printResult(numbers);
            this.timercounterZufaellig = this.timercounterZufaellig + elapsedTime;
            this.counterZufaellig = this.counterZufaellig + sorter.getCounterZufaellig();

            if (!validate(numbers)) {
                fail("Should not happen");
            }
            assertTrue(true);
			
		}
    	System.out.println("QuickZufallCounterAVG: " + this.counterZufaellig / 100);
    	System.out.println("QuickZufallTimerAVG: " + this.timercounterZufaellig / 100);
    }
 
    @org.junit.jupiter.api.Test
    public void testInsertSort() {
//        for (Integer i : numbers) {
//            System.out.println(i + " ");
//        }
    	for (int i = 0; i < 100; i++) {
            long startTime = System.currentTimeMillis();

            Sort sorter = new Sort();
            sorter.sort(numbers);

            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
  //          System.out.println("InsertSort " + elapsedTime);
     //       printResult(numbers);
            this.timercounterInsertSort = this.timercounterInsertSort + elapsedTime;
            this.counterInsertSort = this.counterInsertSort + sorter.getCounterInsertSort();
            if (!validate(numbers)) {
                fail("Should not happen");
            }
            assertTrue(true);			
		}
    	System.out.println("InsertSortCounterAVG: " + this.counterInsertSort /100);
    	System.out.println("InsertSortTimerAVG: " + this.timercounterInsertSort /100);
    }
   
    @org.junit.jupiter.api.Test
    public void testHeapSort() {
//        for (Integer i : numbers) {
//            System.out.println(i + " ");
//        }
    	for (int i = 0; i < 100; i++) {
            long startTime = System.currentTimeMillis();

            HeapSort sorter = new HeapSort();
            sorter.sort(numbers);

            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
//            System.out.println("InsertSort " + elapsedTime);
//            printResult(numbers);
            this.timercounter = this.timercounter + elapsedTime;
            this.counter = this.counter + sorter.getcounter();

            if (!validate(numbers)) {
                fail("Should not happen");
            }
            assertTrue(true);			
		}
    	System.out.println("HeapSortCounterAVG: " + this.counter / 100);
    	System.out.println("HeapSortTimerAVG: " + this.timercounter / 100);
    }
    
    @org.junit.jupiter.api.Test
    public void testMergeInsertSort() {
//        for (Integer i : numbers) {
//            System.out.println(i + " ");
//        }
    	for (int i = 0; i < 100; i++) {
            long startTime = System.currentTimeMillis();

            MergeInsertion sorter = new MergeInsertion();
            sorter.sort(numbers);

            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
 //           System.out.println("InsertSort " + elapsedTime);
     //n       printResult(sorter.nummern);
            this.timercounterMergeInsertionSort = this.timercounterMergeInsertionSort + elapsedTime;
            this.counterMergeInsertionSort = this.counterMergeInsertionSort + sorter.getCounterMergeInsertionSort();

            if (!validate(sorter.nummern)) {
                fail("Should not happen");
            }
            assertTrue(true);
			
		}
    	System.out.println("MergeInsertCounterAVG: " + this.counterMergeInsertionSort/100);
    	System.out.println("MergeInsertTimerAVG: " + this.timercounterMergeInsertionSort/100);
    }

//    @org.junit.jupiter.api.Test
//    public void testStandardSort() {
//        long startTime = System.currentTimeMillis();
//        Arrays.sort(numbers);
//        long stopTime = System.currentTimeMillis();
//        long elapsedTime = stopTime - startTime;
//        System.out.println("Standard Java sort " + elapsedTime);
//        if (!validate(numbers)) {
//            fail("Should not happen");
//        }
//        assertTrue(true);
//    }

    private boolean validate(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private void printResult(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();
    }
}
