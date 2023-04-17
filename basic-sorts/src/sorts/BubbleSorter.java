package sorts;

public class BubbleSorter
{
    public void sort(int[] array)
    {
        //loop for each index in the array
        for (int i = 0; i < array.length - 1; i++)
        {
            //loop over the elements in the array and bubble one element
            //to the "top" index
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    SortingUtilities.swap(array, j, j + 1);
                }
            }
        }
    }
}
