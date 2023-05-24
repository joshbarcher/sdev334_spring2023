package driver;

import sets.DisjointSets;

public class Main
{
    public static void main(String[] args)
    {
        DisjointSets sets = new DisjointSets(10);

        sets.union(2, 3);
        sets.union(7, 5);
        sets.union(7, 3);
        sets.union(9, 0);
        sets.union(9, 4);
        sets.union(0, 4);
        sets.union(5, 4);

        System.out.println(sets);
    }
}