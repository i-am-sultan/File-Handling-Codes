
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FHheapSort {

  static Scanner userInput = new Scanner(System.in);

  public void sort(double[] arr) {
    int n = arr.length;
    int count=0;
    // Build max heap
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, n, i,count++);
    }
    // Heap sort
    for (int i = n - 1; i >= 0; i--) {
      double temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      // Heapify root element
      heapify(arr, i, 0,count++);
    }
  }

  void heapify(double arr[], int n, int i,int count) {
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
      double swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;

      heapify(arr, n, largest,count++);
    }
    System.out.println("the loop executed for "+count+" times.");
  }

  public static void main(String args[]) throws FileNotFoundException {
    // System.out.println("Original array is: ");
    FHheapSort ob = new FHheapSort();
    System.out.println("\n*****Enter Data from text files******\nEnter file path : \t");
    String filepath = userInput.nextLine(); // assigning path in string
    Scanner inp = new Scanner(new File(filepath)); // taking the path from user

    int limit = Integer.parseInt(inp.nextLine()); // the first line of the file contains the "limit"

    double arr[] = new double[(int) limit]; // declaring an array

    for (int i = 0; i < limit; i++) {
      arr[i] = Double.parseDouble(inp.nextLine()); // assigning file's data to an array
    }
    if (limit == 0) // checking if the file was empty or not
      System.out.println("\nEmpty array...");
    ob.sort(arr);
    System.out.println("Sorted array is");
    System.out.println("The sorted array is: ");
    for (int j = 0; j < limit; j++)
      System.out.println(arr[j]); // printing array's value
  }
}