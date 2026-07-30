public class reversePairs {

        //public static int count = 0;

        public static int divide(int[] arr, int low, int high) {
            if (low >= high)
                return 0;
            int count = 0;
            int mid = low + (high - low) / 2;
            count += divide(arr, low, mid);
            count += divide(arr, mid + 1, high);
            count += conquer(arr, low, mid, high);
            return count;
        }

        public static int conquer(int[] arr, int low, int mid, int high) {
            int count = 0;
            // count reversed pairs
            int right = mid + 1;
            for(int left = low; left <= mid; left++){
                while(right <= high && (long) arr[left] > 2L * arr[right]){
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
        int[] arr = { 1, 3, 2, 3, 1 };
        int ans = divide(arr, 0, arr.length - 1);
        System.out.println(ans);

        int[] arr1 = { 2, 4, 3, 5, 1 };
        ans = divide(arr1, 0, arr1.length - 1);
        System.out.println(ans);
    }

}