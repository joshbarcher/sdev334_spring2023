package graphs;

public class Edge<V>
{
    private V source;
    private V destination;

    public Edge(V source, V destination)
    {
        this.source = source;
        this.destination = destination;
    }

    public V getSource()
    {
        return source;
    }

    public V getDestination()
    {
        return destination;
    }

    public String toString()
    {
        return "(" + source + "," + destination + ")";
    }
}
