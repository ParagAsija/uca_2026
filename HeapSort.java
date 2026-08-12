import java.util.*;

public class HeapSort {

    // Heapify-down operation
    public static void heapify(int[] arr, int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check left child
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check right child
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify affected subtree
            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int[] arr) {

        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Repeatedly remove maximum element
        for (int i = n - 1; i > 0; i--) {

            // Move maximum to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify remaining heap
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {

        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(arr));

        heapSort(arr);

        System.out.println("After sorting:");
        System.out.println(Arrays.toString(arr));
    }
}