package heap;

public class BinaryHeap<T extends Comparable<T>>
{
	private T[] heap;
	private int size;

	public BinaryHeap()
	{
		heap = (T[])new Comparable[20];
	}

	public void add(T element)
	{
		heap[size + 1] = element;
		size++;

		swim(size);
	}

	private void swim(int currentIndex)
	{
		//loop here to move from the current index up to the root
		while (currentIndex > 1)
		{
			int parentIndex = currentIndex / 2;

			//if parent is larger, swap
			if (heap[currentIndex].compareTo(heap[parentIndex]) < 0)
			{
				swap(currentIndex, parentIndex);
				currentIndex = parentIndex;
			}
			else
			{
				break; //stop looping, they are in order!
			}
		}
	}

	private void swap(int first, int second)
	{
		T temp = heap[first];
		heap[first] = heap[second];
		heap[second] = temp;
	}

	public T remove()
	{
		return null;
	}
}
