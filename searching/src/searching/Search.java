package searching;

public class Search
{
    public int binarySearch(int[] array, int searchValue)
    {
        int low = 0;
        int high = array.length - 1;

        //loop while low and high are in order
        while (low <= high)
        {
            //get our mid-point!
            int mid = (low + high) / 2;
            if (array[mid] == searchValue)
            {
                return mid;
            }
            else if (array[mid] > searchValue)
            {
                //move high to the left side of the array
                high = mid - 1;
            }
            else //if (array[mid] < searchValue)
            {
                //move low to right side of the array
                low = mid + 1;
            }
        }

        return -1;
    }
}
