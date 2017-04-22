import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.ArrayList;
import java.util.Iterator;

public class GraphNode implements Comparable{
    private final int index;
    private final ArrayList<GraphNode> outgoingEdges;

    public GraphNode(int index){
        this.index = index;
        outgoingEdges = new ArrayList<>();
    }

    public void addEdge(GraphNode node){
        outgoingEdges.add(node);
    }

    public Iterator<GraphNode> getEdges(){
        return outgoingEdges.iterator();
    }

    public boolean hasEdge(GraphNode node){
        return outgoingEdges.contains(node);
    }

    public int outSize(){
        return outgoingEdges.size();
    }

    public int index() {
        return this.index;
    }

    public int compareTo(Object node) throws ClassCastException{
        if (!(node instanceof GraphNode)){
            throw new ClassCastException("Comparison target is not a GraphNode.");
        }
        return this.index - ((GraphNode) node).index;
    }

    public int compareTo(int i){
        return this.index - i;
    }
}
