import java.util.ArrayList;
import java.util.Iterator;

public class DirectedGraph {
    private ArrayList <GraphNode> nodes;

    public DirectedGraph(String str) {
        nodes = new ArrayList<>();

        int strStart;
        int strEnd;
        int index;
        GraphNode startNode;
        GraphNode endNode;

        while (true) {
            //TODO: no need to find v and shorten string, keep track of index => more efficient

            //get strStart node
            strStart = str.indexOf('v');
            strEnd = str.indexOf(',');

            if (strStart == -1) {
                break;
            }

            index = Integer.parseInt(str.substring(strStart + 1, strEnd)) - 1;
            str = str.substring(strEnd);

            insertNode(index);
            startNode = nodes.get(index);

            //get outgoing node
            strStart = str.indexOf('v');
            strEnd = str.indexOf(']');

            index = Integer.parseInt(str.substring(strStart + 1, strEnd)) - 1;
            str = str.substring(strEnd + 1);

            insertNode(index);
            endNode = nodes.get(index);

            startNode.addEdge(endNode);
        }
    }


    private void insertNode(int index){
        //handles checks for inserting nodes into node collection
        //assumes input nodes are labeled with no sequence gaps, 1-based
        if (index > nodes.size()-1){
            for (int i = nodes.size(); i < index; i++) {
                nodes.add(null);
            }
            nodes.add(index,new GraphNode(index));
        }
        else if (nodes.get(index) == null) {
            nodes.set(index,new GraphNode(index));
        }
        //else node exists
    }



    public ArrayList<GraphNode> getIncomingEdges(GraphNode v) {
        //acyclic graph; ignore outgoing edges of v, and v itself
        ArrayList<GraphNode> output = new ArrayList<>();
        for (GraphNode node:nodes) {
            if (!v.hasEdge(node) && node != v){
                if (node.hasEdge(v)){
                    output.add(node);
                }
            }
        }

        return output;
    }

    public boolean isDAG() {
        return false;
    }

    public ArrayList<GraphNode> getRoots() {
        return nodes;
    }

    public int edgeCount() {
        //sum of outgoing edges of all nodes
        int num = 0;
        for (GraphNode node:nodes) {
            num += node.outSize();
        }

        return num;
    }

    public void printAsAdjacencyMatrix() {
    }

    public ArrayList<GraphNode> findCycle(GraphNode v) {
        return nodes;
    }

    public Iterator<GraphNode> getNodes(){
        return nodes.iterator();
    }
}
