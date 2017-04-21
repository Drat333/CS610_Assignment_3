import java.util.ArrayList;
import java.util.Iterator;

public class DirectedGraph {
    private ArrayList <GraphNode> nodes;


    public DirectedGraph(String str) {
        int start;
        int end;
        int index;

        while (true){
            //get start node
            start = str.indexOf('v');
            end = str.indexOf(',');

            if (start == -1){
                break;
            }

            index = Integer.parseInt(str.substring(start,end));
            str = str.substring(end);

            if (nodes.get(index) == null){
                nodes.add(index, new GraphNode(index));
            }



            //get outgoing node
            start = str.indexOf('v');
            end = str.indexOf(']');

            index = Integer.parseInt(str.substring(start,end));
            str = str.substring(end);
        }
    }

    public ArrayList<GraphNode> getIncomingEdges(GraphNode v) {

    }

    public boolean isDAG() {

    }

    public ArrayList<GraphNode> getRoots() {

    }

    public int edgeCount() {

    }

    public void printAsAdjacencyMatrix() {

    }

    public ArrayList<GraphNode> findCycle(GraphNode v) {

    }

}
