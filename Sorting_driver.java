/*
    Name:           Daniel Oliveira
    Student ID:     0x2EB8D7
    Date:           Mon Jan 17 03:48:38 PM MST 2022
    Class:          CS235 Data Structures and Algorithms
    Instructor:     Daniel Oliveira

    Description:    Sorting algorithms


    I pledge that the work done here was my own and that I have learned how to write this program, such that I could
    throw it out and restart and finish it in a timely manner. I am not turning in any work that I cannot understand,
    describe, or recreate. I further acknowledge that I contributed substantially to all code handed in and vouch for
    its authenticity. (Daniel Oliveira)

    Visualization:
        https://www.cs.usfca.edu/~galles/visualization/BST.html
        https://visualgo.net/en

*/

package edu.ensign.cs235.sorting;


public class Sorting_driver
{
    public static void main(String[] args)
    {
        final int K_NUM_OF_RANDOMS = 100;

        ///
        System.out.println("\n");
        System.out.println("Creating list of random numbers: ");
        Sorting unsorted_numbers = new Sorting(K_NUM_OF_RANDOMS);

        /// Generate randoms, based on the size of the unsorted_numbers
        /// so,  K_NUM_OF_RANDOMS
        unsorted_numbers.generate_randoms();
        unsorted_numbers.display_numbers();
        System.out.println(" Size of random numbers list: " + unsorted_numbers.get_size());
        System.out.println("\n\n");

        /// Runs Merge-Sort on the unsorted.
        unsorted_numbers.run_merge_sort();

        /// Runs Quick-Sort on the unsorted.
        unsorted_numbers.run_quick_sort();

        /// Runs Insertion-Sort on the unsorted.
        unsorted_numbers.run_insertion_sort();

        /// Runs Selection-Sort on the unsorted.
        unsorted_numbers.run_selection_sort();

        /// Runs Selection-Sort on the unsorted.
        unsorted_numbers.run_bucket_sort();

        /// Runs Selection-Sort on the unsorted.
        unsorted_numbers.run_radix_sort();
    }
}

