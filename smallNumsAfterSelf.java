public class smallNumsAfterSelf{

    static class Pair{
        int value;
        int index;
        Pair(int value, int index){
            this.value = value;
            this.index = index;
        }
    }

    static int[] count;
    public static void main(String[] args){
        int[] nums = {5, 2, 6, 1};
        int n = nums.length;
        Pair[] arr = new Pair[n];
        count = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = new Pair(nums[i], i);
        }

        divide(arr, 0, n-1);
        for(int x : count){
            System.out.print(x + " ");
        }
    }

    public static void divide(Pair[] arr, int low, int high){
        if(low>=high)return;
        int mid = low + (high - low)/2;
        divide(arr, low, mid);
        divide(arr, mid + 1, high);
        conquer(arr, low, mid, high);
    }

    public static void conquer(Pair[] arr,int low,int mid, int high){
        Pair[] temp = new Pair[high - low + 1];
        int right = mid + 1;
        int left = low;
        int i = 0;
        int rightCount = 0;

        while(left <= mid && right <= high){
            if(arr[left].value > arr[right].value){
                temp[i++] = arr[right++];
                rightCount++;
            }
            else{
                count[arr[left].index] += rightCount;
                temp[i++] = arr[left++];
            }
        }

        while(left <= mid){
            count[arr[left].index] += rightCount;
            temp[i++] = arr[left++];

        }

        while(right <= high){
            temp[i++] = arr[right++];
        }

        for(int j = 0; j < temp.length; j++){
            arr[low + j] = temp[j];
        }
    }

}
