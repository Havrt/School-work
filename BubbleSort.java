public class BubbleSort {

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) { // Compare adjacent elements
                    // Swap array[j] and array[j + 1]
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // Test with Integer array
        Integer[] intArray = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(intArray);
        System.out.println("Sorted Integer array: ");
        for (Integer i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Test with String array
        String[] strArray = {"apple", "orange", "banana", "mango", "grape"};
        bubbleSort(strArray);
        System.out.println("Sorted String array: ");
        for (String s : strArray) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}