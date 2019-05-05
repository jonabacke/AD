package ab_05;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class QuicksortTest {

    private int[] numbers;
    private final static int SIZE = 100;
    private final static int MAX = 1000;

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
    public void testQuickSort() {
//        for (Integer i : numbers) {
//            System.out.println(i + " ");
//        }
        long startTime = System.currentTimeMillis();

        Quicksort sorter = new Quicksort();
        sorter.sort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Quicksort " + elapsedTime);
        printResult(numbers);

        if (!validate(numbers)) {
            fail("Should not happen");
        }
        assertTrue(true);
    }
    
    @org.junit.jupiter.api.Test
    public void testInsertSort() {
//        for (Integer i : numbers) {
//            System.out.println(i + " ");
//        }
        long startTime = System.currentTimeMillis();

        Sort sorter = new Sort();
        sorter.sort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("InsertSort " + elapsedTime);
        printResult(numbers);

        if (!validate(numbers)) {
            fail("Should not happen");
        }
        assertTrue(true);
    }
    
    @org.junit.jupiter.api.Test
    public void testMergeInsertSort() {
//        for (Integer i : numbers) {
//            System.out.println(i + " ");
//        }
        long startTime = System.currentTimeMillis();

        MergeInsertion sorter = new MergeInsertion();
        sorter.sort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("InsertSort " + elapsedTime);
        printResult(sorter.numbers);

        if (!validate(sorter.numbers)) {
            fail("Should not happen");
        }
        assertTrue(true);
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
