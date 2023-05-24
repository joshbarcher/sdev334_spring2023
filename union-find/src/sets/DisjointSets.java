package sets;

import java.util.Arrays;

public class DisjointSets
{
    private int[] sets;

    public DisjointSets(int numElements)
    {
        if (numElements <= 0)
        {
            throw new IllegalArgumentException("Positive set total only please");
        }

        sets = new int[numElements];
        Arrays.fill(sets, -1);
    }

    public int find(int element)
    {
        if (sets[element] < 0)
        {
            return element;
        }
        return find(sets[element]);
    }

    public boolean union(int first, int second)
    {
        //find the root of both sets
        int firstRoot = find(first);
        int secondRoot = find(second);

        if (firstRoot == secondRoot)
        {
            return false;
        }
        else
        {
            if (sets[firstRoot] < sets[secondRoot]) //firstRoot is new root
            {
                sets[secondRoot] = firstRoot;
            }
            else if (sets[secondRoot] < sets[firstRoot]) //secondRoot is new root
            {
                sets[firstRoot] = secondRoot;
            }
            else //arbitrarily pick a root (first)
            {
                sets[secondRoot] = firstRoot;

                //update the height since it increased
                sets[firstRoot]--;
            }

            return true;
        }
    }

    public String toString()
    {
        return Arrays.toString(sets);
    }
}




