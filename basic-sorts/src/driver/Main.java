package driver;

import sorts.BubbleSorter;
import sorts.SortingUtilities;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int[] testArray = SortingUtilities.generateRandomArray(1000000, 1, 1000000);
        System.out.println("Generated array");
        //System.out.println(Arrays.toString(testArray));

        BubbleSorter sorter = new BubbleSorter();
        sorter.sort(testArray);
        //System.out.println(Arrays.toString(testArray));
        System.out.println("Sorted array");

        System.out.println("Sorted? " + !SortingUtilities.detectAdjacentInversions(testArray));
    }
}