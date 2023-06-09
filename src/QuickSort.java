import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    /*
    Quick-Sort is another divide and conquer algorithm like merge-sort. This algorithm uses pivot to divide the array
    that wanted to be sorted. Once pivot is selected, reindex the pivot to the correct position where elements
    at left of the pivot are smaller than pivot and elements at right of the pivot are bigger than pivot. After that
    array partition occurs. Then each sub-array repeats previous steps until no further division can be done.
    */

    public void quickSort(int[] arrayToSort, String pivotType) {
        if (pivotType.equals("FirstElement"))
            quickSortFirst(arrayToSort, 0, arrayToSort.length - 1);

        else if (pivotType.equals("RandomElement"))
            quickSortRandom(arrayToSort, 0, arrayToSort.length - 1);

        else if (pivotType.equals("MidOfFirstMidLastElement")) {
            quickSortMedian(arrayToSort, 0, arrayToSort.length - 1);
        } else
            System.out.println("'pivotType' parameter has wrong value.");

    }

    private void swap(int[] arr, int i, int j) { //for swapping two elements
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void random(int[] arrayToSort, int left, int right) {
        Random rnd = new Random();
        // select random pivot between range of left and right(both included.)
        int piv = rnd.nextInt(right - left) + left;

        // swap last element and random pivot.
        swap(arrayToSort, piv, right);
    }

    public long medianOf3(int[]arrayToSort, int left, int right) {
        int mid = (left + right) / 2;
        if (arrayToSort[left] > arrayToSort[mid])
            swap(arrayToSort,left, mid);
        if (arrayToSort[left] > arrayToSort[right])
            swap(arrayToSort,left, right);
        if (arrayToSort[mid] > arrayToSort[right])
            swap(arrayToSort,mid, right);
        swap(arrayToSort,mid, right - 1);    // move the pivot to right
        return arrayToSort[right - 1];     // return pointer to location of median
    }

    public int partitionMedian(int[] arrayToSort ,int left, int right, long pivot) {
        int l = left; // index of the fist element
        int r = right - 1; // pivot index's left

        while (true) {
            // scan to find elements smaller than pivot
            while (arrayToSort[++l] < pivot);
            // scan to find elements bigger than pivot
            while (arrayToSort[--r] > pivot);
            if (l >= r) // when two pointers cross each other break
                break;
            else
                swap(arrayToSort,l, r); // if pointers did not cross swap the elements
        }
        swap(arrayToSort, l, right - 1); // put pivot into its correct position.
        return l; // return the index where the pivot is.
    }

    public void simpleSort(int[] arrayToSort,int left, int right) {
        int size = right - left + 1; // find size of the array.

        if (size <= 1)
            return; // if array has 1 element do nothing.
        if (size == 2) {
            // if array has only 2 elements compare and sort them
            if (arrayToSort[left] > arrayToSort[right])
                swap(arrayToSort,left, right);
        } else {
            // if array has only 3 elements no need to find median just sort.
            if (arrayToSort[left] > arrayToSort[right - 1])
                swap(arrayToSort,left, right - 1);
            if (arrayToSort[left] > arrayToSort[right])
                swap(arrayToSort,left, right);
            if (arrayToSort[right - 1] > arrayToSort[right])
                swap(arrayToSort,right - 1, right);
        }
    }


    // Divide the array as pivot's left and right.
    private int partitionFirstElement(int[] arr, int left, int right) {

        // select the pivot as first element(left most)
        int pivot = arr[left];

        // index of the bigger element, also indicates correct position of the pivot.
        int i = right;

        // loop to find correct position of the pivot also reordering the array such way elements at left of the pivot
        // are smaller and elements at right of the pivot are bigger than pivot.
        for (int j = right; j > left; j--) {

            // If element at jth index (current) is bigger than pivot enters
            if (arr[j] > pivot) {
                swap(arr, j, i--); // decrease the index of bigger element and swap the elements.
            }
        }
        // leave the loop when reaching to the pivot.

        swap(arr, left, i); // place pivot into the correct index.
        return i;
    }

    private void quickSortFirst(int[] arr, int left, int right) {
        // do something iff left < right!
        if (left < right) {
            // Partition of the array, returns pivot's position.
            int prt = partitionFirstElement(arr, left, right);

            // Recursive call for partition and quick-sorting.
            quickSortFirst(arr, left, prt - 1);
            quickSortFirst(arr, prt + 1, right);
        }
    }

    /*
    This function take pivot as last element (chooses pivot randomly and replace it to the last element.)
     */
    private int partitionRandom(int[] arrayToSort, int left, int right) {
        // Chose pivot randomly
        random(arrayToSort, left, right);
        int pivot = arrayToSort[right]; // Initialize the pivot.

        // index of the bigger element, also indicates correct position of the pivot.
        int i = (left - 1);

        // loop to find correct position of the pivot also reordering the array such way elements at left of the pivot
        // are smaller and elements at right of the pivot are bigger than pivot.
        for (int j = left; j < right; j++) {
            // If element at jth index (current) is smaller than pivot enters
            if (arrayToSort[j] < pivot) {
                i++; // increase index of the smaller element
                swap(arrayToSort, i, j); // swap the elements
            }
        }
        // leave the loop when reaching to the pivot.

        swap(arrayToSort, i + 1, right); // place pivot into the correct index.
        return i + 1;
    }


    private void quickSortRandom(int[] arrayToSort, int left, int right) {
        if (left < right) {
            // Partition of the array, returns pivot's position.
            int part = partitionRandom(arrayToSort, left, right);

            // Recursive call for partition and quick-sorting.
            quickSortRandom(arrayToSort, left, part - 1);
            quickSortRandom(arrayToSort, part + 1, right);
        }
    }

//    private int partitionMidElement(int[] arrayToSort, int left, int right){
//        int i = left, j = right;
//        int pivot = arrayToSort[(left + right) / 2];
//
//        while (i <= j) {
//            while (arrayToSort[i] < pivot)
//                i++;
//            while (arrayToSort[j] > pivot)
//                j--;
//            if (i <= j) {
//                swap(arrayToSort, i, j);
//                i++;
//                j--;
//            }
//
//        };
//        return i;
//    }


    public void quickSortMedian(int[] arrayToSort, int left, int right) {
        int size = right - left + 1;
        // if size of the array bigger than 3, we can find median and make it pivot.
        if (size >= 3) {
            long median = medianOf3(arrayToSort,left, right);    // find the median and determine partition
            int partition = partitionMedian(arrayToSort,left, right, median);

            // Recursive call for partition and quick-sorting.
            quickSortMedian(arrayToSort,left, partition - 1);
            quickSortMedian(arrayToSort,partition + 1, right);
        }
        else {
            // if array size is ess than three just do simple sort.
            simpleSort(arrayToSort,left, right);
        }
    }


}
