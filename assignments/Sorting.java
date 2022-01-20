public class Sorting {
    public static void main(String[] args) {
        int arr[] = new int[20];
        int arr2[] = new int[20];

        // Make random array
        for (int i = 0; i < 20; i++) {
            arr[i] = arr2[i] = (int) (Math.random() * 100);
        }

        // Print array
        System.out.println("Unsorted Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nSorted Array from Bubble Sort:");
        int bubbleSortArr[] = bubbleSort(arr);
        for (int i = 0; i < bubbleSortArr.length; i++) {
            System.out.print(bubbleSortArr[i] + " ");
        }
        
        System.out.println("\nSorted Array from Selection Sort:");
        int selectionSortArr[] = selectionSort(arr2);
        for (int i = 0; i < selectionSortArr.length; i++) {
            System.out.print(selectionSortArr[i] + " ");
        }
        System.out.println();

    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int low = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[low]) {
                    low = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[low];
            arr[low] = temp;
        }

        return arr;
    }
}
