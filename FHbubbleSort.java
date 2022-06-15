
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FHbubbleSort {

    static Scanner userInput = new Scanner(System.in);

    void bubbleSort(double[] arr) {
        int n = arr.length;
        double temp = 0;
        int count1=0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                count1++;
                if (arr[j - 1] > arr[j]) {
                    // swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("The loops executed "+count1+" times.");
    }

    public static void main(String args[]) throws FileNotFoundException {
        // System.out.println("Original array is: ");
        FHbubbleSort ob = new FHbubbleSort();
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

        ob.bubbleSort(arr);
        System.out.println("The sorted array is: ");
        for (int j = 0; j < limit; j++)
            System.out.println(arr[j]); // printing array's value
    }
}
