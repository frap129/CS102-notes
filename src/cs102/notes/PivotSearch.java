package cs102.notes;

import java.util.Arrays;

public class PivotSearch {
    public static void main(String args[])
    {
        int arr1[] = {12, 3, 5, 7, 4, 19, 26, 9, 13, 8, 43, 17, 52, 51, 99, 98, 94, 93, 95, 96, 81, 84, 72, 78, 76};
        int arr2[] = {12, 3, 5, 7, 4, 19, 26, 9, 13, 8, 43, 17, 52, 51, 99, 98, 94, 93, 95, 96, 81, 84, 72, 78, 76};
        int n = arr1.length, k = 3;
        long start = System.currentTimeMillis();
        int result = kthSmallestRecursive(arr1, 0, n-1, k);
        long stop = System.currentTimeMillis() - start;
        System.out.println("With Pivot: " + stop + "ms");
        start = System.currentTimeMillis();
        result = kthSmallestSort(arr2, k);
        stop = System.currentTimeMillis() - start;
        System.out.println("With sorting: " + stop + "ms");
    }

    private static int kthSmallestRecursive(int arr[], int left, int right, int k)
    {
        // If k is smaller than number of elements in array
        if (k > 0 && k <= right - left + 1)
        {
            // Partition the array around a random element and
            // get position of pivot element in sorted array
            int pos = randomPartition(arr, left, right);

            // If position is same as k
            if (pos-left == k-1)
                return arr[pos];

            // If position is more, recur for left subarray
            if (pos-left > k-1)
                return kthSmallestRecursive(arr, left, pos-1, k);

            // Else recur for right subarray
            return kthSmallestRecursive(arr, pos+1, right, k-pos+left-1);
        }

        // If k is more than number of elements in array
        return -1;
    }

    private static int kthSmallestSort(int arr[], int k)
    {
        // Sort the array
        Arrays.sort(arr);

        // Return kth element
        return arr[k-1];
    }

    private static void swap(int arr[], int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(int arr[], int left, int right)
    {
        int x = arr[right], i = left;
        for (int j = left; j <= right - 1; j++)
        {
            if (arr[j] <= x)
            {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    private static int randomPartition(int arr[], int left, int right)
    {
        int n = right-left+1;
        int pivot = (int)(Math.random()) * (n-1);
        swap(arr, left + pivot, right);
        return partition(arr, left, right);
    }
}