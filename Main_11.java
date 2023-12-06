import java.util.Random;
import java.util.*;
public class MergeSortBinarySearch {
    static void merge(int arr[], int left, int middle, int right) {
        int i, j, k;
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (j = 0; j < n2; j++)
            R[j] = arr[middle + 1 + j];

        // Merge the temporary arrays
        i = 0;
        j = 0;
        k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }


        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }


        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Merge sort function
    static void mergeSort(int arr[], int left, int right) {
        if (left >= right)
            return;

        int middle = left + (right - left) / 2;
        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);
        merge(arr, left, middle, right);
    }

    // Binary search function
    static int binarySearch(int arr[], int left, int right, int key) {
        if (left <= right) {
            int middle = left + (right - left) / 2;

            if (arr[middle] == key)
                return middle;
            if (arr[middle] > key)
                return binarySearch(arr, left, middle - 1, key);
            return binarySearch(arr, middle + 1, right, key);
        }
        return -1; // Key not found
    }

    public static void main(String[] args) {
        final int size = 5000;
        int[] randArray = new int[size];
        Random rand = new Random();

        // Generate random numbers between 1 and 10000
        for (int i = 0; i < size; i++)
            randArray[i] = 1 + rand.nextInt(10000);

        System.out.print("The unsorted array: ");
        for (int i = 0; i < size; i++)
            System.out.print(randArray[i] + " ");


        mergeSort(randArray, 0, size - 1);

        System.out.println("\n\nThe sorted array: ");
        for (int i = 0; i < size; i++)
            System.out.print(randArray[i] + " ");


        int key;
        System.out.print("\n\nEnter the element to be searched: ");
        Scanner scanner = new Scanner(System.in);
        key = scanner.nextInt();


        int result = binarySearch(randArray, 0, size - 1, key);
        if (result != -1)
            System.out.print("The element " + key + " is found at index " + result);
        else
            System.out.print("The element " + key + " is not found in the array.");
    }
}