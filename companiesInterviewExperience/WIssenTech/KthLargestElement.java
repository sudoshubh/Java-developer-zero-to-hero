import java.util.*;
import java.util.Arrays;

// Approach 1: Using Quick Sort Partitioning
public class KthLargestElement {

    public class Main {
        public static void main(String[] args) {
            int[] nums = { 3, 2, 1, 5, 6, 4 };
            int k = 2;
            System.out.println(findKthLargest(nums, k)); // Output: 5
        }

        public static int findKthLargest(int[] nums, int k) {
            int targetIndex = nums.length - k; // kth largest = (n-k)th index

            int left = 0, right = nums.length - 1;

            while (true) {
                int pivotIndex = partition(nums, left, right);

                if (pivotIndex == targetIndex) {
                    return nums[pivotIndex];
                } else if (pivotIndex < targetIndex) {
                    left = pivotIndex + 1; // search right side
                } else {
                    right = pivotIndex - 1; // search left side
                }
            }
        }

        // Standard partition (Lomuto)
        private static int partition(int[] nums, int left, int right) {
            int pivot = nums[right];
            int i = left;

            for (int j = left; j < right; j++) {
                if (nums[j] <= pivot) {
                    swap(nums, i, j);
                    i++;
                }
            }

            swap(nums, i, right);
            return i; // pivot index
        }

        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
