// ##########################################################
// Explanes Loops in Realistic.java (lines 40–45)
//
// These 2 `for` loops are used to copy elements from the
// original `arr[]` array to a new array `temporary[]`,
// leaving out the smallest element.
//
// First Loop: 
// `for (int i = 0; i < smallest_index; i++)`
// - The range of `i`: from 0 up to (but not including) `smallest_index`.
// - Meaning: It copies all the elements prior to the smallest
//   element from `arr` to `temporary` using the same index.
// - Array access: `temporary[i] = arr[i];` — both arrays use the
//   same index because we haven't skipped anything.
//
// Second Loop: 
// `for (int i = smallest_index + 1; i < arr.length; i++)`
// - The range of `i`: from the element after the smallest index to
//   the end of the array.
// - Meaning: It copies the elements after the smallest one.
// - Array access: `temporary[i - 1] = arr[i];` — we subtract 1 from `i`
//   because the `temporary` array is one element shorter, so we shift
//   elements left by one position.
//
// Conclusion :
// - The first loop copies elements directly.
// - The second loop skips the smallest element and shifts the rest left.
// Purpose - This allows us to "remove" the smallest element from the array.
// ##########################################################


import java.util.Arrays; // for printing arrays

/**
 * A class to demonstrate minimum heap operations using arrays
 */
public class Realistic {

    /** Set up our test array. */
    static int[] arr = { 10, -5, 11, 2 };

    /**
     * Scan the entire array to find and remove its smallest value.
     * 
     * @return int with the smallest value in array arr
     */
    public static int getSmallest() {
        int smallest_index = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[smallest_index]) {
                smallest_index = i;
            }
        }

        int result = arr[smallest_index];
        int[] temporary = new int[arr.length - 1];

        // First loop: copy elements before smallest
        for (int i = 0; i < smallest_index; i++) {
            temporary[i] = arr[i];
        }

        // Second loop: copy elements after smallest, shifted by one
        for (int i = smallest_index + 1; i < arr.length; i++) {
            temporary[i - 1] = arr[i];
        }

        arr = temporary;
        return result;
    }

    /** Driver/simple test code */
    public static void main(String[] args) {
        System.out.printf("\n\nArray before removal of smallest element: %s",
                Arrays.toString(arr));
        System.out.printf("\nSmallest element found: %d", getSmallest());
        System.out.printf("\nArray after removal of smallest element: %s\n\n",
                Arrays.toString(arr));
    }
}
