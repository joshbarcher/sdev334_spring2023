package heap;

import java.util.NoSuchElementException;

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
		//if the heap is empty
		if (size == 0)
		{
			throw new NoSuchElementException("Heap is empty");
		}

		//save the element to remove
		T removed = heap[1];

		//replace the root element
		heap[1] = heap[size];
		heap[size] = null;
		size--;

		//reorder the heap, sink at the root
		sink(1);

		return removed;
	}

	private void sink(int parentIndex)
	{
		//the highest index with a child is size/2
		while (parentIndex <= size / 2)
		{
			//get the children
			int leftIndex = 2 * parentIndex;
			int rightIndex = 2 * parentIndex + 1;

			//determine the smallest child
			int smallestChildIndex = leftIndex;
			if (rightIndex <= size && heap[leftIndex].compareTo(heap[rightIndex]) > 0)
			{
				smallestChildIndex = rightIndex;
			}

			//is the parent and child out of order?
			if (heap[parentIndex].compareTo(heap[smallestChildIndex]) > 0)
			{
				swap(parentIndex, smallestChildIndex);
				parentIndex = smallestChildIndex;
			}
			else
			{
				break;
			}
		}
	}
}

