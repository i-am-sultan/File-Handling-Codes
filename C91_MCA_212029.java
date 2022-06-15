import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class C91_MCA_212029 {
  static Scanner userInput = new Scanner(System.in);
  static int heap_counter = 0, bubble_counter = 0;

  static void sequential_search(long arr[], int limit, long key) {
    int index = 0;
    int counter = 0;
    while (index < limit && arr[index] != key) {
      index++;
      counter++;
    }
    if (index != limit)

      System.out.println("\nElement: " + key + " not found at index " + index + " and ");

    else

      System.out.println("\nElement: " + key + " found at index " + index + " and ");
    System.out.println("the loop executed " + counter + " times.");
  }

  public static boolean isSorted(long[] a, int l) { // The function "isSorted()" is to check wheather the given array is
                                                    // sorted or not.

    for (int i = 0; i < l; i++) {
      if (a[i] > a[i + 1]) {
        System.out.println("\nArray is not sorted.Operation can not be performed.\n");
        return false;
      }
    }
    System.out.println("\nArray is sorted. Operation can be performed:\n");

    return true;
  }

  static int binarySearch(long a[], int left, int right, long key, int counter) {

    while (left <= right) {
      int m = left + (right - left) / 2; // finding the middle element
      if (a[m] == key) {
        System.out.println("The loop executed " + counter + " times");
        return m;
      }
      if (a[m] > key) // considering only first half of the array
        return binarySearch(a, left, m - 1, key, counter + 1);
      else // considering only second half of the array
        return binarySearch(a, m + 1, right, key, counter + 1);
    }
    System.out.println("The loop executed " + counter + " times");
    return -1;
  }

  static void bubbleSort(long[] arr) {
    int n = arr.length;
    long temp = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < (n - i); j++) {
        bubble_counter++;
        if (arr[j - 1] > arr[j]) {

          // swaping elements
          temp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }

  public static void heapSort(long[] arr) {
    int n = arr.length;

    // Building max heap

    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, n, i);
    }

    // Heap sort

    for (int i = n - 1; i >= 0; i--) {
      long temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      // Heapify root element

      heapify(arr, i, 0);
    }
  }

  static void heapify(long[] arr, int n, int i) {
    heap_counter++;
    // Find largest among root, left child and right child
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && arr[l] > arr[largest])
      largest = l;

    if (r < n && arr[r] > arr[largest])
      largest = r;

    // Swap and continue heapifying if root is not largest
    if (largest != i) {
      long swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;

      heapify(arr, n, largest);
    }
  }

  public static void main(String args[]) throws FileNotFoundException {
    System.out.println("\n*****Enter Data from text files******\nEnter file path : \t");
    String filepath = userInput.nextLine(); // accepting a string from command line (the filepath)

    Scanner inp = new Scanner(new File(filepath)); // creating a scanner object and file object
    int limit = Integer.parseInt(inp.nextLine()); // first line of textfile contains number of elements the array should
                                                  // contain
    long key1 = Long.parseLong(inp.nextLine()); // first key in line 2 of input file
    long key2 = Long.parseLong(inp.nextLine()); // second key in line 3 of input file

    long[] arr = new long[limit]; // declaring array and allocating memory to array

    for (int i = 0; i < limit; i++) // entering the array with elements present in the text file from line 2 till
                                    // last.

      arr[i] = Long.parseLong(inp.nextLine());

    System.out.println("\nElements entered successfully");

    int choice = 0;

    while (choice != 5) {
      System.out.println(
          "**************MENU*************:\n1.linear Search/Sequential Search\n2.Recursive Binary Search\n3.Bubble Sort\n4.Heap Sort\n5.Exit");
      choice = Integer.parseInt(userInput.nextLine());
      switch (choice) {
        case 1:
          sequential_search(arr, limit, key1);
          sequential_search(arr, limit, key2);
          System.out.println("\nTherefore the time complexity of linear search algorithm is O(n).\n");
          break;

        case 2:
          boolean d = isSorted(arr, limit - 1);
          if (d == true) {
            int counter = 0;
            int c = binarySearch(arr, 0, limit - 1, key1, counter);
            if (c == -1)
              System.out.println("Element " + key1 + " not found.\n");
            else
              System.out.println("Element " + key1 + " found at index: " + c);

            int e = binarySearch(arr, 0, limit - 1, key2, counter);
            if (e == -1)
              System.out.println("\nElement " + key2 + " not found");
            else
              System.out.println("Element " + key2 + " found at index: " + e);
            System.out.println(
                "\nThe value of log 500 in base 2 is: 8.965 \nTherefore the time complexity of recursive binary search algorithm is log(n)");
          }
          break;

        case 3:

          bubbleSort(arr);
          System.out.println("\nThe loops executed " + bubble_counter + " times.");
          System.out.println("Since, the average case time complexity of bubble sort is O(n*n)\n");
          System.out.println("********The Sorted array is********");
          for (int k = 0; k < limit; k++)
            System.out.print(arr[k] + "  ");
          break;

        case 4:
          heap_counter = 0;
          heapSort(arr);
          System.out.println("\nNo of time the function executed is: " + heap_counter);
          System.out.println("*****The Sorted array is *****");

          for (int i = 0; i < limit; ++i)
            System.out.print(arr[i] + "  ");

        case 5:
          System.out.println("Successfully Exited...........");
          break;

        default:
          System.out.println("\nInvalid Choice...\nPlease try again...");

      } // end of switch
    } // end of while
  } // end of main
}// end of menuDriven class