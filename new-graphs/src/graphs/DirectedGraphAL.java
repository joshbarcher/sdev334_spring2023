package graphs;

import adts.IGraph;
import exceptions.DuplicateException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.Set;

public class DirectedGraphAL<V> implements IGraph<V>
{
    private HashMap<V, Node> adjLists = new HashMap<>();

    @Override
    public void addVertex(V vertex)
    {
        if (containsVertex(vertex))
        {
            throw new DuplicateException("Duplicate vertex found!");
        }
        adjLists.put(vertex, null);
    }

    @Override
    public void addEdge(V source, V destination)
    {
        if (!containsVertex(source) || !containsVertex(destination))
        {
            throw new NoSuchElementException(source + " or " + destination + " is missing");
        }
        else if (containsEdge(source, destination))
        {
            throw new DuplicateException("Duplicate edge found!");
        }

        Node head = adjLists.get(source);
        if (head == null)
        {
            //no adjacent vertices
            head = new Node(destination);
            adjLists.put(source, head);
        }
        else
        {
            //some adjacent vertices
            head = new Node(destination, head);
            adjLists.put(source, head);
        }
    }

    @Override
    public void printGraph()
    {
        for (V key : adjLists.keySet())
        {
            Node list = adjLists.get(key);
            System.out.print(key + ": ");

            //loop over adjacent verts
            while (list != null)
            {
                System.out.print(list.vertex + " -> ");
                list = list.next;
            }
            System.out.println(); //new line!
        }
    }

    @Override
    public boolean containsVertex(V vertex)
    {
        return adjLists.containsKey(vertex);
    }

    @Override
    public boolean containsEdge(V source, V destination)
    {
        return false;
    }

    @Override
    public boolean removeVertex(V vertex)
    {
        return false;
    }

    @Override
    public boolean removeEdge(V source, V destination)
    {
        return false;
    }

    @Override
    public int vertexSize()
    {
        return 0;
    }

    @Override
    public int edgeSize()
    {
        return 0;
    }

    @Override
    public Set<V> getVertices()
    {
        return null;
    }

    @Override
    public Set<Edge<V>> getEdges()
    {
        return null;
    }

    private class Node
    {
        private V vertex;
        private Node next;

        public Node(V vertex)
        {
            this.vertex = vertex;
        }

        public Node(V vertex, Node next)
        {
            this.vertex = vertex;
            this.next = next;
        }
    }
}
