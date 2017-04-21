import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.ArrayList;

public class DirectedGraph {
    private ArrayList <GraphNode> nodes;


    public DirectedGraph(String str) {
        nodes = new ArrayList<>();

        int strStart;
        int strEnd;
        int index;
        GraphNode startNode;
        GraphNode endNode;

        while (true){
            //get strStart node
            strStart = str.indexOf('v');
            strEnd = str.indexOf(',');

            if (strStart == -1){
                break;
            }

            index = Integer.parseInt(str.substring(strStart,strEnd));
            str = str.substring(strEnd);

            if (nodes.get(index) == null){
                nodes.add(index, new GraphNode(index));
            }
            startNode = nodes.get(index);

            //get outgoing node
            strStart = str.indexOf('v');
            strEnd = str.indexOf(']');

            index = Integer.parseInt(str.substring(strStart,strEnd));
            str = str.substring(strEnd);

            if (nodes.get(index) == null){
                nodes.add(index, new GraphNode(index));
            }
            endNode = nodes.get(index);

            startNode.addEdge(endNode);
        }
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

}
