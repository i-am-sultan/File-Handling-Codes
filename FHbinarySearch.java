
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class BinarySearch {
    static Scanner userInput = new Scanner(System.in);
    
    public static int binarySearch(long[] arr,int start,int end,long key){
        int mid;
        while(start<=end){
            mid=start+(end-start)/2;
            if (key==arr[mid]) {
                return mid;
            } 
            else if(key<arr[mid]) {
                return binarySearch(arr, start, mid-1, key);
            }
            else{
                return binarySearch(arr, mid+1, end, key);
            }
        }
        return -1;
    }

    public static void main(String args[]) throws FileNotFoundException {
        System.out.println("\n*****Enter Data from text files******\nEnter file path : \t");
        String filepath = userInput.nextLine(); //assigning path in string
        Scanner inp = new Scanner(new File(filepath)); //taking the path from user

        int start=0;
        int end = Integer.parseInt(inp.nextLine()); //the first line of the file contains the "end"
        
        long key1 = Long.parseLong(inp.nextLine());//the second line of the file contains the "first key"
        long key2 = Long.parseLong(inp.nextLine());//the third line of the file contains the "key2"
        
        long arr[] = new long[(int) end]; //declaring an array

        for (int i = 0 ; i < end; i++) {
            arr[i] = Long.parseLong(inp.nextLine()); //assigning file's data to an array
        }
        if (end == 0) //checking if the file was empty or not
            System.out.println("\nEmpty array...");
        // else {
        //     for (int j = 0; j < end; j++)
        //         System.out.println(arr[j] + "\t");  //printing array's value
        //     System.out.println("");
        // }
        System.out.println("key 1 :" + key1);
        System.out.println("key 2 :" + key2);
        int result = binarySearch(arr,start,end-1, key1);
        int result2= binarySearch(arr,start,end-1, key2);
        if (result == -1) {
            System.out.println("Item "+key1+ " not present in the array");
        }
        else{
            System.out.println("Item "+key1+ " is present in the array index "+result);
        }
        if (result2 == -1) {
            System.out.println("Item "+key2+ " not present in the array");
        }
        else{
            System.out.println("Item "+key2+ " is present in the array index "+result2);
        }
    }
} 
