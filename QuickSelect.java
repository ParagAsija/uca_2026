import java.util.*;

public class QuickSelect {

    // Returns the smallest k elements in any order
    public static int[] selectSmallestK(int[] arr, int k) {
        if (k <= 0) {
            return new int[0];
        }

        if (k >= arr.length) {
            return arr.clone();
        }

        quickSelect(arr, 0, arr.length - 1, k - 1);

        return Arrays.copyOf(arr, k);
    }

    private static void quickSelect(int[] arr, int left, int right, int target) {

        while (left <= right) {

            int pivotIndex = partition(arr, left, right);

            if (pivotIndex == target) {
                return;
            }

            if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
    }

    private static int partition(int[] arr, int left, int right) {

        // Choose a random pivot
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));

        swap(arr, pivotIndex, right);

        int pivot = arr[right];
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }

        swap(arr, storeIndex, right);

        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] data = {10, 4, 7, 2, 9, 1, 8, 3, 6, 5};

        int k = 4;

        int[] result = selectSmallestK(data, k);

        System.out.println(Arrays.toString(result));
    }
}