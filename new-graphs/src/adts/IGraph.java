package adts;

import graphs.Edge;

import java.util.List;
import java.util.Set;

//interface for a directed, weighted
public interface IGraph<V>
{
    void addVertex(V vertex);
    void addEdge(V source, V destination);

    boolean containsVertex(V vertex);
    boolean containsEdge(V source, V destination);

    boolean removeVertex(V vertex);
    boolean removeEdge(V source, V destination);

    int vertexSize();
    int edgeSize();

    Set<V> getVertices();
    Set<Edge<V>> getEdges();

    List<V> dfs(V source);
    List<V> bfs(V source);

    void printGraph();
}
