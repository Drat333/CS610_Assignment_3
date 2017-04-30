import java.util.ArrayList;

public class DirectedGraph {
    private ArrayList <GraphNode> nodes;
    private ArrayList<GraphNode> visited;

    public DirectedGraph(String str) {
        nodes = new ArrayList<>();

        int strStart;
        int strEnd;
        int index;
        GraphNode startNode;
        GraphNode endNode;

        while (true) {
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
        //assumes input nodes are labeled with no sequence gaps, 1-based indexing
        if (index > nodes.size()-1){
            for (int i = nodes.size(); i < index; i++) {
                nodes.add(null);
            }
            nodes.add(index,new GraphNode(index));
        }
        else if (nodes.get(index) == null) {
            nodes.set(index,new GraphNode(index));
        }
        //else node exists, no further action required
    }



    public ArrayList<GraphNode> getIncomingEdges(GraphNode v) {
        ArrayList<GraphNode> output = new ArrayList<>();
        for (GraphNode node : nodes) {
            if (node.hasEdge(v)){
                output.add(node);
            }
        }
        return output;
    }

    public boolean isDAG() {
        //modified implementation of TopologicalSort

        ArrayList<GraphNode> roots = new ArrayList<>();
        int [] incounter = new int[nodes.size()];

        for (GraphNode node : nodes) {
            incounter[node.index()] = this.getIncomingEdges(node).size();
            if (incounter[node.index()] == 0){
                roots.add(node);
            }
        }

        int i = 1;
        GraphNode node;
        while (!roots.isEmpty()){
            node = roots.remove(roots.size()-1);
            i++;
            for (GraphNode edge : node.getEdges()){
                incounter[edge.index()]--;
                if (incounter[edge.index()] == 0){
                    roots.add(edge);
                }
            }
        }

        if (i > nodes.size()){
            return true;
        } else{
            return false;
        }
    }

    public ArrayList<GraphNode> getRoots() {
        ArrayList<GraphNode> roots = new ArrayList<>();
        for (GraphNode node : nodes) {
            if (this.getIncomingEdges(node).isEmpty()){
                roots.add(node);
            }
        }

        return roots;
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
        System.out.println("\t");
        for (int i = 0; i < nodes.size(); i++) {
            System.out.print("\t"); System.out.print(i + 1);
        }
        System.out.println();

        for (int i = 0; i < nodes.size(); i++) {
            System.out.print(i + 1); System.out.print("\t");
            for (int j = 0; j < nodes.size(); j++) {
                if (nodes.get(j).hasEdge(nodes.get(i))){
                    System.out.print(1);
                } else{
                    System.out.print("-");
                }
                System.out.print("\t");
            }
            System.out.println();
        }

    }

    public ArrayList<GraphNode> findCycle(GraphNode v) {
        //DFS starting from v, terminates if we find a back edge or if DFS completes
        visited = new ArrayList<>();
        ArrayList<GraphNode> output = new ArrayList<>();

        visited.add(v);
        output.add(v);
        ArrayList<GraphNode> result = null;
        for (GraphNode w : v.getEdges()){
            if (!visited.contains(w)){
                visited.add(w);
                output.add(w);
                result = findCycleVisit(w,output);
                if (result != null){
                    return result;
                }
                output.remove(output.size()-1);
            }
            else{
                if (!output.contains(w)){
                    return output;
                }

            }
        }

        return null;
    }

    private ArrayList<GraphNode> findCycleVisit(GraphNode u, ArrayList<GraphNode> output){

        ArrayList<GraphNode> result = null;
        for (GraphNode w : u.getEdges()){
            if (!visited.contains(w)){
                visited.add(w);
                output.add(w);
                result = findCycleVisit(w,output);
                if (result != null){
                    return result;
                }
                output.remove(output.size()-1);
            }
            else{
                if (output.contains(w)){
                    output.add(w);
                    return output;
                }

            }
        }

        return null;
    }


    public ArrayList<GraphNode> getNodes() {
        //for performing operations on each GraphNode in test cases
        return nodes;
    }

}
