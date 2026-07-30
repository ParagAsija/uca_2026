public class countInversions {

        public static int divide(int[] arr, int low, int high) {
            if (low >= high)
                return 0;
            int mid = low + (high - low) / 2;
            return divide(arr, low, mid) + divide(arr, mid + 1, high) + conquer(arr, low, mid, high);
        }

        public static int conquer(int[] arr, int low, int mid, int high) {
            int count = 0;
            // count reversed pairs
            int right = mid + 1;
            for(int left = low; left <= mid; left++){
                while(right <= high && arr[left] > arr[right]){
                    right++;
                }
                count += right - (mid + 1);
            }

            int[] temp = new int[high - low + 1];
            right = mid + 1;
            int left = low;
            int i = 0;

            while (left <= mid && right <= high) {
                if (arr[left] <= arr[right]) {
                    temp[i++] = arr[left++];
                } else {
                    temp[i++] = arr[right++];
                }
            }

            while (left <= mid) {
                temp[i++] = arr[left++];
            }

            while (right <= high) {
                temp[i++] = arr[right++];
            }

            for (int j = 0; j < temp.length; j++) {
                arr[low + j] = temp[j];
            }

            return count;
        }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1, 3, 5};
        int ans = divide(arr, 0, arr.length - 1);
        System.out.println(ans);

        int[] arr1 = {2, 3, 4, 5, 6};
        ans = divide(arr1, 0, arr1.length - 1);
        System.out.println(ans);
    }

}