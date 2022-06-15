
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FHinsertionsort {

    static Scanner userInput = new Scanner(System.in);

    void sort(double array[]) {

        int n = array.length;
        for (int i = 1; i < n; ++i) {
            double key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        // System.out.println("Original array is: ");
        FHinsertionsort ob = new FHinsertionsort();
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
        // else {
        // for (int j = 0; j < limit; j++)
        // System.out.println(arr[j] + "\t"); // printing array's value
        // System.out.println("");
        // }

        ob.sort(arr);
        System.out.println("The sorted array is: ");
        for (int j = 0; j < limit; j++)
            System.out.println(arr[j]); // printing array's value
    }
}
