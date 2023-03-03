package edu.ensign.cs235.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class Sorting {
    double staring_time = System.currentTimeMillis();
    double time_total;
    public static int[] m_numbers;

    public void generate_randoms() //Method to generate randoms
    {
        System.out.print("\n");
        System.out.print("Elapsed Time in ms: " + time_total + "\n");
        Sorting.m_numbers = random_array(Sorting.m_numbers, get_size());
    }//End of method

    public void display_numbers() //Method to display numbers
    {
        System.out.print("\n");
        for (int j = 0; j < get_size(); j++) {
            System.out.print(Sorting.m_numbers[j] + "; ");
        }
        System.out.println("\n");
    }//End of method

    public Sorting(int value) //Method to sort
    {
        Sorting.m_numbers = new int[value];
    }//End of method


    public void run_quick_sort() //Method to quick sort
    {
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("** 2) Quick-sort:");
        quick_sort(Sorting.m_numbers, 0, Sorting.m_numbers.length - 1);
        display_numbers();
        double stopTime_2 = System.currentTimeMillis();
        time_total = stopTime_2 - staring_time;
        System.out.print(" Elapsed Time in ms: " + time_total + "\n");
    }//End of method

    public void run_insertion_sort() //Method insert sort
    {
        System.out.print("\n\n** 3) Insertion-Sort:");
        insertion_sort(Sorting.m_numbers);
        display_numbers();

        double stopTime_3 = System.currentTimeMillis();
        time_total = stopTime_3 - staring_time;
        System.out.print(" Elapsed Time in ms: " + time_total + "\n");
    }//End of method

    public void run_merge_sort() //Method merge sort
    {
        System.out.print("** 1) Merge-Sort:");
        merge_sort(Sorting.m_numbers, 0, Sorting.m_numbers.length - 1);
        display_numbers();
        double stopTime_1 = System.currentTimeMillis();
        time_total = stopTime_1 - staring_time;
        System.out.print(" Elapsed Time in ms: " + time_total + "\n");
    }//End of method

    public void run_selection_sort() //Selection sort
    {
        System.out.print("\n\n** 4) Selection-sort:");

        selection_sort(Sorting.m_numbers);
        display_numbers();

        double stopTime_4 = System.currentTimeMillis();
        time_total = stopTime_4 - staring_time;
        System.out.print(" Elapsed Time in ms: " + time_total + "\n");
    }//End of method

    public void run_bucket_sort()//Bucket sort
    {
        System.out.print("\n\n** 5) Bucket-Sort:");
        bucket_sort(Sorting.m_numbers);
        display_numbers();
        double stopTime_5 = System.currentTimeMillis();
        time_total = stopTime_5 - staring_time;
        System.out.print(" Elapsed Time in ms: " + time_total + "\n");
    }//End method

    public void run_radix_sort()//Method Radix Sort
    {
        System.out.print("\n\n** 6) Radix-Sort:");
        radix_sort(Sorting.m_numbers, Sorting.m_numbers.length);
        display_numbers();
        double stopTime_6 = System.currentTimeMillis();
        time_total = stopTime_6 - staring_time;
        System.out.print(" Elapsed Time in ms: " + time_total + "\n");
    }//End of method

    public int get_size()//Retrieve size
    {
        return Sorting.m_numbers.length;
    }//End Method

    public static int[] random_array(int[] array, int rand_num)//Random Array
    {
        int first = 1;
        int last = 50000;
        int length = (rand_num != 0) ? rand_num : array.length;

        for (int i = 0; i < length; i++) {
            array[i] = randomization(first, last);
        }
        return array;
    }//End Method

    public static int randomization(int min, int max)//Method randomization
    {
        return (int) ((Math.random() * (max - min)) + min);
    }//End of Method

    public void merge_sort(int[] array, int first, int second) //Merge sort Method
    {
        if (first < second) {
            int middle = first + (second - first) / 2;
            merge_sort(array, first, middle);
            merge_sort(array, middle + 1, second);
            sorting_merge_sort(array, first, middle, second);
        } else {
            return;
        }
    }//End of Method

    public void sorting_merge_sort(int[] array, int first, int middle, int second)//Merge Sort method
    {
        int size1 = middle - first + 1;
        int size2 = second - middle;

        int temp1[] = new int[size1];
        int temp2[] = new int[size2];
        for (int i = 0; i < size1; ++i)
            temp1[i] = array[first + i];
        for (int j = 0; j < size2; ++j)
            temp2[j] = array[middle + 1 + j];

        int i = 0;
        int j = 0;
        int k = first;

        while (i < size1 && j < size2) {
            if (temp1[i] <= temp2[j]) {
                array[k] = temp1[i];
                i++;
            } else {
                array[k] = temp2[j];
                j++;
            }
            k++;
        }

        while (i < size1) {
            array[k] = temp1[i];
            i++;
            k++;
        }

        while (j < size2) {
            array[k] = temp2[j];
            j++;
            k++;
        }
    }//End of Method

    public static void quick_sort(int[] array, int start, int end)//Quick Sort
    {
        if (start < end) {
            int split_index = split_array(array, start, end);

            quick_sort(array, start, split_index - 1);
            quick_sort(array, split_index + 1, end);
        }
    }//End of Method

    public static void swap(int[] array, int i, int j)// Method uses (Quick Sort/Split Array helper)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }//End of method

    public static int split_array(int[] array, int low, int high)//Split Array method
    {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return (i++);
    }//End of Method

    public void insertion_sort(int[] array)//Method Insertion
    {
        int size = array.length;
        for (int i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            // Iterate key to next value
            array[j + 1] = key;
        }
    }//End of Method

    public void selection_sort(int[] array)//Method selection_sort
    {
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            int min_value = i;
            for (int j = i + 1; j < size; j++)
                if (array[j] < array[min_value])
                    min_value = j;
            int temp = array[min_value];
            array[min_value] = array[i];
            array[i] = temp;
        }
    }//End of Method

    private static void bucket_sort(int[] array)//Method bucket sort
    {
        int max = max(array);
        int min = min(array);
        int num_buckets = max - min + 1;

        List<List<Integer>> buckets = new ArrayList<>(num_buckets);
        for (int i = 0; i < num_buckets; ++i) {
            buckets.add(new ArrayList<>());
        }
        for (int value : array) {
            int hash = hash(value, min, num_buckets);
            buckets.get(hash).add(value);
        }
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                array[index++] = value;
            }
        }
    }//End of Method

    public static int hash(int value, int min, int num_buckets)//Method Hash
    {
        return (value - min) / num_buckets;
    }//End of Method

    public static int max(int[] array)//Method max
    {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }//End of Method

    public static int min(int[] array)//Method min
    {
        int min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }//End of Method

    public static void radix_sort(int[] array, int n)//Method radix_sort
    {
        int max = get_max(array, n);
        for (int i = 1; max / i > 0; i *= 10)
            count_sort(array, n, i);
    }//End of Method

    public static void count_sort(int[] array, int n, int exp)//Method count sort
    {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++)
            count[(array[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
        for (i = 0; i < n; i++)
            array[i] = output[i];
    }//End of Method

    public static int get_max(int[] array, int n)//Method get max
    {
        int max = array[0];
        for (int i = 1; i < n; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }
}//End of Method

