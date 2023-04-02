import java.sql.SQLOutput;
import java.util.Arrays;

public class SortingClass {

    public static void main(String[] args) {
        // T = thousand TT = ten thousand, HT = hundred thousand.
        // Create and initialize arrays.
        int[] arrT = new int[1000], arrTT = new int[10000], arrHT = new int[100000];
        long start, est;
        MergeSort mergeSortObj = new MergeSort();

        /* Merge Sort Two Parts */
        System.out.println("-------------------------Merge Sort Two Way-------------------------");
        equalIntegers(arrT, 1000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrT, 2); // Merge-Sort Two Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Equal 1.000 | " + est + "ms");

        equalIntegers(arrTT, 10000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrTT, 2); // Merge-Sort Two Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Equal 10.000 | " + est + "ms");

        equalIntegers(arrHT, 100000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrHT, 2); // Merge-Sort Two Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Equal 100.000 | " + est + "ms\n");

        randomIntegers(arrT, 1000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrT, 2); // Merge-Sort Two Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Random 1.000 | " + est + "ms");

        randomIntegers(arrTT, 10000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrTT, 2); // Merge-Sort Two Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Random 10.000 | " + est + "ms");

        randomIntegers(arrHT, 100000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrHT, 2); // Merge-Sort Two Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Random 100.000 | " + est + "ms\n");

        increasingIntegers(arrT, 1000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrT, 2); // Merge-Sort Two Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Increasing 1.000 | " + est + "ms");

        increasingIntegers(arrTT, 10000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrTT, 2); // Merge-Sort Two Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Increasing 10.000 | " + est + "ms");

        increasingIntegers(arrHT, 100000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrHT, 2); // Merge-Sort Two Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Increasing 100.000 | " + est + "ms\n");

        decreasingIntegers(arrT, 1000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrT, 2); // Merge-Sort Two Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Decreasing 1.000 | " + est + "ms");

        decreasingIntegers(arrTT, 10000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrTT, 2); // Merge-Sort Two Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Decreasing 10.000 | " + est + "ms");

        decreasingIntegers(arrHT, 100000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrHT, 2); // Merge-Sort Two Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Decreasing 100.000 | " + est + "ms\n");

        /* Merge Sort Three Parts */
        System.out.println("-------------------------Merge Sort Three Way-------------------------");
        equalIntegers(arrT, 1000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrT, 3); // Merge-Sort Three Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Equal 1.000 | " + est + "ms");

        equalIntegers(arrTT, 10000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrTT, 3); // Merge-Sort Three Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Equal 10.000 | " + est + "ms");

        equalIntegers(arrHT, 100000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrHT, 3); // Merge-Sort Three Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Equal 100.000 | " + est + "ms\n");

        randomIntegers(arrT, 1000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrT, 3); // Merge-Sort Three Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Random 1.000 | " + est + "ms");

        randomIntegers(arrTT, 10000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrTT, 3); // Merge-Sort Three Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Random 10.000 | " + est + "ms");

        randomIntegers(arrHT, 100000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrHT, 3); // Merge-Sort Three Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Random 100.000 | " + est + "ms\n");

        increasingIntegers(arrT, 1000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrT, 3); // Merge-Sort Three Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Increasing 1.000 | " + est + "ms");

        increasingIntegers(arrTT, 10000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrTT, 3); // Merge-Sort Three Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Increasing 10.000 | " + est + "ms");

        increasingIntegers(arrHT, 100000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrHT, 3); // Merge-Sort Three Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Increasing 100.000 | " + est + "ms\n");

        decreasingIntegers(arrT, 1000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrT, 3); // Merge-Sort Three Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Decreasing 1.000 | " + est + "ms");

        decreasingIntegers(arrTT, 10000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrTT, 3); // Merge-Sort Three Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Decreasing 10.000 | " + est + "ms");

        decreasingIntegers(arrHT, 100000);
        start = System.currentTimeMillis();
        mergeSortObj.mergeSort(arrHT, 3); // Merge-Sort Three Way.
        est = System.currentTimeMillis() - start;
        System.out.println("Decreasing 100.000 | " + est + "ms\n");




    }

    public static void equalIntegers(int[] arr, int numOfInt){
        for(int i = 0; i < numOfInt; i++)
            arr[i] = 5;
    }

    public static void randomIntegers(int[] arr, int numOfInt){
        int rnd;
        for(int i = 0; i < numOfInt; i++){
            rnd = (int) (Math.random() * numOfInt);
            arr[i] = rnd;
        }
    }

    public static void increasingIntegers(int[] arr, int numOfInt){
        for(int i = 0; i < numOfInt; i++)
            arr[i] = i;
    }

    public static void decreasingIntegers(int[] arr, int numOfInt){
        for(int i = numOfInt - 1; i >= 0; i--)
            arr[i] = i;
    }












}
