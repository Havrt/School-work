import java.util.Arrays;

public class MergeSort {

    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        if (array.length > 1) {
            // Split the array into two halves
            int mid = array.length / 2;

            // Create left and right subarrays
            T[] leftArray = Arrays.copyOfRange(array, 0, mid);
            T[] rightArray = Arrays.copyOfRange(array, mid, array.length);

            // Recursively sort the two halves
            mergeSort(leftArray);
            mergeSort(rightArray);

            // Merge the sorted halves
            merge(array, leftArray, rightArray);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] array, T[] leftArray, T[] rightArray) {
        int i = 0, j = 0, k = 0;

        // Merge the left and right arrays into the original array
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements of leftArray, if any
        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        // Copy remaining elements of rightArray, if any
        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        // Test with Integer array
        Integer[] intArray = {64, 34, 25, 12, 22, 11, 90};
        mergeSort(intArray);
        System.out.println("Sorted Integer array: " + Arrays.toString(intArray));

        // Test with String array
        String[] strArray = {"apple", "orange", "banana", "mango", "grape"};
        mergeSort(strArray);
        System.out.println("Sorted String array: " + Arrays.toString(strArray));

        // Test with custom objects
        Person[] people = {
            new Person("John", 25),
            new Person("Alice", 30),
            new Person("Bob", 20)
        };
        mergeSort(people);
        System.out.println("Sorted Person array: " + Arrays.toString(people));
    }
}

// Custom class to demonstrate sorting with custom objects
class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name); // Sort by name
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}