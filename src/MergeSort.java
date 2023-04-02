public class MergeSort {
    /*
    Merge-Sort is a divide and conquer algorithm. We use this algorithm to sort arrays. Merge-sort works by dividing
    the given array into sub-arrays until no further division can be done. Then merges sub-arrays start with the smallest
    pieces. As we can understand from the previous sentences merge-sort uses a recursive method.
    */

    public void MergeSort(int[] arrayToSort, int numberOfPartitions) {
        if (numberOfPartitions == 2)
            mergeSortTwo(arrayToSort, 0, arrayToSort.length - 1);

        else if (numberOfPartitions == 3) {

            // if array is empty return 0.
            if (arrayToSort == null)
                return;

            // Duplicate the original array and copy elements into duplicate array.
            int[] dupArray = new int[arrayToSort.length];
            for (int i = 0; i < dupArray.length; i++)
                dupArray[i] = arrayToSort[i];

            // Call sort function.
            mergeSortThree(dupArray, 0, arrayToSort.length, arrayToSort);

            // Copy the sorted elements back into the array we want to sort in the first place.
            for (int i = 0; i < dupArray.length; i++)
                arrayToSort[i] = dupArray[i];
            /*
                We duplicate the original array's elements that way we can compare elements(at mergeThree() )
                and preserve their original indexes.
             */

        } else
            System.out.println("Wrong 'numberOfPartitions' value. Enter either 2 or 3.");


    }

    private void mergeTwo(int[] arr, int left, int mid, int right)//Merges two sub-arrays into one,
    // first array includes [left to mid],
    // second array includes [mid to right].
    {
        // To initialize temp arrays find sizes of the two sub-arrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        //Create and initialize temp arrays(L - Left, R - Right)
        int[] L = new int[n1];
        int[] R = new int[n2];

        //Fill the first temp array with data [left to mid]
        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        //Fill the second temp array with data [mid to right]
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        //We use temp arrays that gives us the opportunity to reindex the sorted values into the original array.

        // Initial indexes of first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of merged sub-array array
        int k = left;
        while (i < n1 && j < n2) //Need that condition to not get out of the bounds of temp arrays.
        {
            /*Compare left and right arrays indexes. Find the smaller element and place it in first.
            DO NOT INCREASE the index number unless it was reindex into orig. array.
            */
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /*If there is a remaining element in Left or Right sub-arrays add into end of the orig. array */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private void mergeSortTwo(int[] arr, int left, int right) {
        if (left < right) {
            // Find the mid-point of two given indexes.,
            int mid = (left + right) / 2;

            // Sort two parts individually and recursively
            mergeSortTwo(arr, left, mid); //recursive
            mergeSortTwo(arr, mid + 1, right);//recursive

            // Merge the sorted halves
            mergeTwo(arr, left, mid, right);
        }
    }

    //public static void mergeSort3Way(Integer[] gArray)

    public static void mergeSortThree(int[] arrayToSort, int left, int right, int[] destArr) {
        // If array includes only 1 element return.
        if (right - left < 2)
            return;

        // Split the array into three
        int midOne = left + ((right - left) / 3);
        int midTwo = left + 2 * ((right - left) / 3) + 1;

        // Sort three arrays recursively.
        mergeSortThree(destArr, left, midOne, arrayToSort);//first array [left to midOne]
        mergeSortThree(destArr, midOne, midTwo, arrayToSort);//second array [midOne to midTwo]
        mergeSortThree(destArr, midTwo, right, arrayToSort);//third array [midTwo to right]

        // Merge, sorted three arrays.
        mergeThree(destArr, left, midOne, midTwo, right, arrayToSort);
    }

    public static void mergeThree(int[] arr, int left, int midOne, int midTwo, int right, int[] destArr) {

        int i = left, l = left /* this one for destination array */, j = midOne, k = midTwo;

        while ((i < midOne) && (j < midTwo) && (k < right)) { // Condition to keep in bounds.

            /* Compare the start indexes of three parts. Find the smaller element and place it in first.
            DO NOT INCREASE the index number unless it was reindex into orig. array.
            */
            if (arr[i] < arr[j]) { // compare left and midOne, if left is smaller enter
                if (arr[i] < arr[k])// compare left and midTwo...
                    destArr[l++] = arr[i++];
                else
                    destArr[l++] = arr[k++];
            } else {
                if (arr[j] < arr[k])
                    destArr[l++] = arr[j++];
                else
                    destArr[l++] = arr[k++];
            }
        }

        //if there are remaining elements at first two parts compare and add them too.
        while ((i < midOne) && (j < midTwo)) {
            if (arr[i] < arr[j])
                destArr[l++] = arr[i++];
            else
                destArr[l++] = arr[j++];
        }

        //if there are remaining elements at second and third parts compare and add them too.
        while ((j < midTwo) && (k < right)) {
            if (arr[j] < arr[k])
                destArr[l++] = arr[j++];

            else
                destArr[l++] = arr[k++];
        }

        //if there are remaining elements at first and third parts compare and add them too.
        while ((i < midOne) && (k < right)) {
            if (arr[i] < arr[k])
                destArr[l++] = arr[i++];
            else
                destArr[l++] = arr[k++];
        }

        // if there are still remaining elements in first part copy them into destination.
        while (i < midOne)
            destArr[l++] = arr[i++];

        // if there are still remaining elements in first part copy them into destination.
        while (j < midTwo)
            destArr[l++] = arr[j++];

        // if there are still remaining elements in first part copy them into destination.
        while (k < right)
            destArr[l++] = arr[k++];

    }


}
