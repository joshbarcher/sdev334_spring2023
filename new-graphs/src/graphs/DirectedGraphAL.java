package graphs;

import adts.IGraph;
import exceptions.DuplicateException;

import java.util.*;

public class DirectedGraphAL<V> implements IGraph<V>
{
    private HashMap<V, Node> adjLists = new HashMap<>();
    private int edgeSize;

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
        edgeSize++;
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
        if (!containsVertex(source) || !containsVertex(destination))
        {
            return false;
        }

        Node head = adjLists.get(source);
        Node current = head;
        while (current != null)
        {
            if (current.vertex.equals(destination))
            {
                return true;
            }
            current = current.next;
        }

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
        return adjLists.size();
    }

    @Override
    public int edgeSize()
    {
        return edgeSize;
    }

    @Override
    public Set<V> getVertices()
    {
        //create a new set (with all elements copied from the vertex set)
        //to ensure encapsulation
        return new HashSet(adjLists.keySet());
    }

    @Override
    public Set<Edge<V>> getEdges()
    {
        Set<Edge<V>> edges = new HashSet<>();

        //for each vertex
        for (V vertex : adjLists.keySet())
        {
            Node current = adjLists.get(vertex);
            while (current != null)
            {
                V other = current.vertex;
                edges.add(new Edge<>(vertex, other));
                current = current.next;
            }
        }
        return edges;
    }

    @Override
    public List<V> dfs(V source)
    {
        Set<V> seen = new HashSet<>();
        List<V> traversal = new ArrayList<>();

        //check whether the vertex exists or not
        if (!containsVertex(source))
        {
            return traversal;
        }

        dfs(source, seen, traversal);

        return traversal;
    }

    //recursive support method
    private void dfs(V current, Set<V> seen, List<V> traversal)
    {
        if (!seen.contains(current))
        {
            seen.add(current);
            traversal.add(current);

            //traverse to adjacent vertices
            Node head = adjLists.get(current);
            while (head != null)
            {
                dfs(head.vertex, seen, traversal);
                head = head.next;
            }
        }
    }

    @Override
    public List<V> bfs(V source)
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
