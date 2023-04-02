import java.util.Arrays;

public class SortingClass {

    public static void main(String[] args) {

        Integer[] arr = {1,5,6,8,2,9,15,23,12,162,142, 45, 56, 38};
        MergeSort mergeSort = new MergeSort();
        //mergeSort.MergeSort(arr, 3);
        mergeSort.mergeSort3Way(arr);
        System.out.println(Arrays.toString(arr));




    }








}
