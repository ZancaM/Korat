# Korat
Korat datastructure testing for KHeap and DirectedRGGraph


## How to run Korat example on KHeap
```
javac -cp :alloy4.jar:javassist.jar:junit.jar:commons-cli-1.0.jar:kfixvis.jar:korat.jar KHeap.java

java -cp :alloy4.jar:javassist.jar:junit.jar:commons-cli-1.0.jar:kfixvis.jar:korat.jar-Xverify:none korat.Korat --class KHeap --args k,n,n,n
```
Above k,n,n,n are the arguments you are passing to the function `IFinitization finKHeap(int k, int maxSize, int maxArrayLength, int maxArrayValue)
`

## How to run Korat example on DirectedRGGraph


```
javac -cp :alloy4.jar:javassist.jar:junit.jar:commons-cli-1.0.jar:kfixvis.jar:korat.jar DirectedRGGraph.java

java -cp :alloy4.jar:javassist.jar:junit.jar:commons-cli-1.0.jar:kfixvis.jar:korat.jar-Xverify:none korat.Korat --class DirectedRGGraph --args n,r,g
```




### KHEAP
A  k -ary heap is a tree data structure that satisfies   the   following   properties:

1. Node   property:   Each   node   contains   a   data   item   and   has   at   most    k    children.
2. Shape property: All levels of the tree, except possibly the deepest one, are full. If the deepest level of the tree is not full, its nodes begin at the far left and proceed to the right
with   no   gaps.
3. Heap property: The data item in a node is greater than or equal to the data items in each
of its children according to some comparison predicate which is fixed for the entire data structure.

### Directed (r,g) Graph 
A graph consisting of vertices and   edges   such   that   the   following   properties   are   satisfied:

1. Directed property: Each edge is traversed in one direction only, from the source vertex to the destination vertex. The source and destination vertex cannot be the same vertex, i.e. a vertex   cannot   have   an   outgoing   edge   to   itself.
2. Duplicate Edge property: The graph contains no duplicate edges, i.e. there is at most one edge from a particular source vertex to a particular destination vertex. It is valid for there to be reciprocal edges between vertices, i.e. an edge from vertex  u to vertex  v , and another   edge   from    v    to    u .
3. Reachability property: All vertices in the graph must be reachable via the starting vertex (or   root)   of   the   graph   by   traversing   edges.
4. Regular property: The graph is  r-regular , meaning each vertex has exactly  r outgoing edges. The number of directed edges originating from a vertex is the  outdegree of the vertex.
5. Girth property: The girth of the graph is of size  g . The girth of a graph is the length of the   shortest   cycle   contained   in   the   graph.


