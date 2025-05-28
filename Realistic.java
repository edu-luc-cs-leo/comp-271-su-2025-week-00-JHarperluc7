/** Explanation of Loops in Realistic.java (lines 40–45)

/** These two `for` loops are used to copy elements from the original `arr[]` array to a new array `temporary[]`, omitting the smallest element.

/* First Loop: `for (int i = 0; i < smallest_index; i++)`

/* Range of `i`**: from 0 up to (but not including) `smallest_index`.
/* What it does**: It copies all the elements *before* the smallest element from `arr` to `temporary` using the same index.
/* Array access**: `temporary[i] = arr[i];` — both arrays use the same index because we haven't skipped anything yet.

//** Second Loop: `for (int i = smallest_index + 1; i < arr.length; i++)`

//**Range of `i`**: from the element *after* the smallest index (`smallest_index + 1`) to the end of the array.
//**What it does**: It copies the elements *after* the smallest one.
//**Array access**: `temporary[i - 1] = arr[i];` — we subtract 1 from `i` because the `temporary` array is one element shorter (we've skipped the smallest element), so we need to "shift" the rest of the elements left by one position.

//*** Summary

//*** The first loop copies elements directly.
//*** The second loop skips the smallest element and shifts the remaining elements to the left by one in the new array.
//*** This allows us to "remove" the smallest element cleanly from the array.

import java.util.Arrays; // from printing array

/**
 * A class to demonstrate minimum heap operations using arrays
 */
public class Realistic {

    /** Set up our test array. */
    static int[] arr = { 10, -5, 11, 2 };

    /**
     * Scan the entire array to find and remove its smallest value.
     * The method uses array arr[] created above.
     * 
     * @return int with the smallest value in array arr
     */
    public static int getSmallest() {
        // Assume smallest is first element
        int smallest_index = 0;
        // Scan the remaining elements, replacing the position of the smallest element
        // with the position of any element found to be smaller.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[smallest_index]) {
                // found new smallest, update index
                smallest_index = i;
            }
        }
        // When loop is done, smallest_index points to smallest element. Save it in a
        // variable so that we can return its value when we are done.
        int result = arr[smallest_index];
        // Prepare to shrink the processed array by one element, effectively removing
        // its smallest element. A temporary array will hold the remaining elements.
        int[] temporary = new int[arr.length - 1];

        /*
         * Use two loops to copy the elements of arr[] to temporary[], except for the
         * smallest element. The first loop copies all the elements before the smallest
         * element and the second loop the elements after it.
         */
        for (int i = 0; i < smallest_index; i++) {
            temporary[i] = arr[i];
        }
        for (int i = smallest_index + 1; i < arr.length; i++) {
            temporary[i - 1] = arr[i];
        }
        /*
         * Same result with a while loop
         * 
         * int temp_index = 0;
         * int arr_index = 0;
         * while (arr_index < arr.length) {
         *   if (arr_index != smallest_index) {
         *     temporary[temp_index] = arr[arr_index];
         *     temp_index++;
         *   }
         *   arr_index++;
         * }
         */

        arr = temporary; // array shorted by 1 (removing smallest elem)
        return result; // smallest element
    } // method getSmallest

    /** Driver/simple test code */
    public static void main(String[] args) {
        System.out.printf("\n\nArray before removal of smallest element: %s",
                Arrays.toString(arr));
        System.out.printf("\nSmallest element found: %d", getSmallest());
        System.out.printf("\nArray after removal of smallest element: %s\n\n",
                Arrays.toString(arr));
    } // method main
} // class Realistic