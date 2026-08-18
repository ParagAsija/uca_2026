#include <stdio.h>
#include <stdlib.h>
int findNo(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        int x = abs(arr[i]);
        arr[x] = -arr[x];
    }
    for (int i = 1; i < n; i++) {
        int x = abs(arr[i]);
        if (arr[x] > 0) {
            return x;
        }
    }
    return 0;
}
int main() {
    int n;
    printf("Enter the number of elements: ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter the elements: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }
    printf("Element that appears 4 times : %d\n", findNo(arr, n));
    return 0;
}