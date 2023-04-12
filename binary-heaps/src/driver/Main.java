package driver;

import heap.BinaryHeap;

public class Main
{
	public static void main(String[] args)
	{
		BinaryHeap<String> heapOfLetters = new BinaryHeap<>();
		String[] inputs = {"c", "f", "w", "m", "c",
				           "p", "b", "a", "l", "d"};

		for (String input : inputs)
		{
			heapOfLetters.add(input);
		}

		System.out.println(heapOfLetters);
	}
}