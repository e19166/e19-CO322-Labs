/**
 * Simple sorting algorithms and their performance 
 * Reg: E/19/166
 *
 */
import java.util.Arrays;


public class Sort {

    //create an array of given size and populate it with random data  
    static int [] create_rand_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = (int)(Math.random() * 100);
	return data; 
    }

    //create an array of given size and populate it with worst data arrangement 
    static int [] create_worst_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = data.length - i;
	return data; 
    }

    //create an array of given size and populate it with best data arrangement 
    static int [] create_best_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = i;
	return data; 
    }

    // function to swap. Would be useful since all need this 
    static void swap(int []d, int i, int j) { 
	int tmp = d[i]; 
	d[i] = d[j]; 
	d[j] = tmp;
    }

    // check if the soring worked on the array 
    static boolean isSorted(int [] data) {
	int i;
	for(i=1; i < data.length; i++)
	    if(data[i] < data[i-1]) break;
	return (i == data.length);
    }

    // If you want just display the array as well :) 
    static void display(int []data) { 
	System.out.println("=======");
	for(int i=0; i < data.length; i++) 
	    System.out.print(data[i] + "  "); 
	System.out.println("\n=======");
    }

    
    /**********************************************************
     *     Implementation of sorting algorithms               *
     *********************************************************/
    static void buble_sort(int [] data)  {
	// Implement 
		boolean quit = false;
		for(int i = 0; i < data.length && !quit; i++) {
			quit = true;
			for(int j = data.length - 1; j > 1; j--) {
				if (data[j] < data[j - 1]) {
					swap(data,j,j-1);
					quit = false;
				}
			}
		}
    }

    static void selection_sort(int [] data) {
	// Implement 
		for(int i = 0; i < data.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < data.length; j++) {
				if (data[j] < data[min]) {
					min = j;
				}
			}
			swap(data, i, min);
		}
    }

    static void insertion_sort(int [] data) {
	// Implement

		for(int i = 1; i < data.length; i++) {
			int v = data[i];
			int j = i - 1;
			while(j >= 0 && data[j] > v) {
				data[j + 1] = data[j];
				j = j - 1;
			}
			data[j + 1] = v;
		}
    }

    public static void main(String [] args) {
	// create arrays of different size populate with data
	// measure the time taken by different algorithms to
	// sort the array.
	// Think about effects of caches, other apps running etc. 
		int[] sizes = {0, 1, 100, 10000, 1000000};
		for(int k = 0; k < 3; k++) {
			for (int g: sizes){
				int[] arr = create_best_data(g);
				//int[] arr = create_worst_data(g);
				//int[] arr = create_rand_data(g);
			

		// Measure time taken by Bubble Sort
		int[] bubbleArr = Arrays.copyOf(arr, arr.length);
		long start = System.currentTimeMillis();
		buble_sort(bubbleArr);
		long end = System.currentTimeMillis();

		System.out.println("Bubble Sort took " + (end - start) + "ms");

		// Measure time taken by Insertion Sort
		int[] insertArr = Arrays.copyOf(arr, arr.length);
		long starti = System.currentTimeMillis();
		insertion_sort(insertArr);
		long endi = System.currentTimeMillis();

		System.out.println("Insertion Sort took " + (endi - starti) + "ms");

		// Measure time taken by Bubble Sort
		int[] selectArr = Arrays.copyOf(arr, arr.length);
		long starts = System.currentTimeMillis();
		selection_sort(selectArr);
		long ends = System.currentTimeMillis();

		System.out.println("Selection Sort took " + (ends - starts) + "ms");
		System.out.println();
			}
		}
    }
}