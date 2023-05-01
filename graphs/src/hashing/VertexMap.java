package hashing;

import java.util.Arrays;

//T is the type of our vertices in the graph
public class VertexMap<T>
{
    //these will govern how the hash table fills...
    private static final int INITIAL_CAPACITY = 10;
    private static final double MAX_LOAD_FACTOR = 0.7;

    private Pair[] table;
    private int size;

    public VertexMap()
    {
        table = new Pair[INITIAL_CAPACITY];
    }

    public void add(T vertex, int index)
    {
        //create our table element
        Pair element = new Pair(vertex, index);

        //find a spot for the element
        int code = element.hashCode();
        int position = code % table.length;

        //probe if there is a collision
        while (table[position] != null)
        {
            position = (position + 1) % table.length;
        }

        table[position] = element;
    }

    public String toString()
    {
        return Arrays.toString(table);
    }

    private static class Pair
    {
        private Object vertex;
        private int index;

        public Pair(Object vertex, int index)
        {
            this.vertex = vertex;
            this.index = index;
        }

        public String toString()
        {
            return "(" + vertex + ", " + index + ")";
        }
    }
}
