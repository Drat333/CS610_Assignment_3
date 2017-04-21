import java.util.ArrayList;
import java.util.Iterator;

public class GraphNode {
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
}
