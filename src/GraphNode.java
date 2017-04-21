import java.util.ArrayList;
import java.util.Iterator;

public class GraphNode {
    private final int index;
    private final ArrayList<GraphNode> outgoingEdges;

    public GraphNode(int index){
        this.index = index;
        ArrayList<GraphNode> outgoingEdges = new ArrayList<GraphNode>();
    }

    public void addEdge(int i){
    }

    public Iterator<GraphNode> getEdges(){

    }
}
