/* Problem Name is &&& Smallest Number &&& PLEASE DO NOT REMOVE THIS LINE. */ /* * Instructions to candidate. * 
                                                                              1) The execution entry point is main(). * 
                                                                              2) Consider adding some additional tests in doTestsPass(). * 
                                                                              3) Implement FindMin(int a[]) correctly. * 
                                                                              4) If time permits, discuss the solution in case there are duplicates in array. */

/* Problem Name is &&& Smallest Number &&& PLEASE DO NOT REMOVE THIS LINE. */

// Approach 1: with linear scan
public class SmallestNumber {

    /*
     * Return the smallest number in the array.
     * If array is null or empty, you can decide to return Integer.MAX_VALUE
     * or throw an IllegalArgumentException (both are acceptable in interviews).
     */
    public static int FindMin(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }

        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    /*
     * Test cases to verify correctness.
     */
    public static boolean doTestsPass() {
        boolean testsPass = true;

        // Test 1: Basic case
        testsPass &= FindMin(new int[] { 5, 3, 8, 1, 9 }) == 1;

        // Test 2: Already sorted
        testsPass &= FindMin(new int[] { 1, 2, 3, 4, 5 }) == 1;

        // Test 3: Reverse sorted
        testsPass &= FindMin(new int[] { 9, 7, 5, 3, 1 }) == 1;

        // Test 4: All equal
        testsPass &= FindMin(new int[] { 4, 4, 4, 4 }) == 4;

        // Test 5: Negative numbers
        testsPass &= FindMin(new int[] { -1, -5, -3 }) == -5;

        // Test 6: Single element
        testsPass &= FindMin(new int[] { 42 }) == 42;

        // Test 7: Array with duplicates
        testsPass &= FindMin(new int[] { 3, 1, 2, 1, 4 }) == 1;

        return testsPass;
    }

    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass!");
        } else {
            System.out.println("Tests failed.");
        }
    }
}

// Approach2: with Binary search (for rotated sorted array)
public static int FindMin(int[] a) {
    if (a == null || a.length == 0) {
        throw new IllegalArgumentException("Array must not be null or empty");
    }

    int left = 0;
    int right = a.length - 1;

    // If array is not rotated at all
    if (a[left] < a[right]) {
        return a[left];
    }

    while (left <= right) {
        int mid = left + (right - left) / 2;

        // Check if mid is the minimum
        if (mid > 0 && a[mid] < a[mid - 1]) {
            return a[mid];
        }

        // Check if mid+1 is the minimum
        if (mid < a.length - 1 && a[mid] > a[mid + 1]) {
            return a[mid + 1];
        }

        // Decide search direction
        if (a[mid] >= a[left]) {
            // Minimum is in the right side
            left = mid + 1;
        } else {
            // Minimum is in the left side
            right = mid - 1;
        }
    }

    return -1; // Should never reach here
}