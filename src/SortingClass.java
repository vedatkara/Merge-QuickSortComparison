import java.util.Arrays;

public class SortingClass {

    public static void main(String[] args) {

        int[] arr = {1,5,6,8,2,9,15,23,12,162,142, 45, 56, 38};
        MergeSort mergeSort = new MergeSort();
        //mergeSort.MergeSort(arr, 3);
        mergeSort.MergeSort(arr, 2);
        System.out.println(Arrays.toString(arr));

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












}
