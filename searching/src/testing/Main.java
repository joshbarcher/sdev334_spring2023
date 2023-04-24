package testing;

import searching.Search;

public class Main
{
    public static void main(String[] args)
    {
        Search search = new Search();
        int[] testArray = {3, 4, 6, 6, 7, 11, 12, 21, 42};
        //                 0  1  2  3  4   5   6   7   8

        int[] searches = {3, 6, 12, 42, 15};

        for (int i = 0; i < searches.length; i++)
        {
            System.out.println("bs(" + searches[i] + "): " +
                 search.binarySearch(testArray, searches[i]));
        }
    }
}