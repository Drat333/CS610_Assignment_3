import java.util.ArrayList;

public class programming_assignment_3 {
    public static void main(String [] args){

        String str_A = "[v4,v1][v5,v1][v5,v2][v6,v2][v6,v3][v7,v3][v8,v4][v9,v4][v9,v5][v10,v5][v10,v6][v10,v7][v11,v7][v12,v8][v12,v9][v13,v10][v13,v11][v14,v12][v14,v13][v15,v1][v15,v2]";
        String str_B = "[v1,v4][v2,v5][v3,v6][v4,v8][v4,v9][v5,v1][v6,v2][v7,v3][v8,v9][v9,v5][v9,v10][v9,v11][v10,v5][v10,v6][v10,v7][v10,v11][v11,v7]";
        DirectedGraph DAG_A = new DirectedGraph(str_A);
        DirectedGraph DAG_B = new DirectedGraph(str_B);

        
        //DAG_A test cases
        System.out.print("DAG_A is a DAG: "); System.out.println(DAG_A.isDAG());
        System.out.print("DAG_A roots: ");
        for (GraphNode node : DAG_A.getRoots()){
            System.out.print(node.index()+1);
            System.out.print(", ");
        }
        System.out.println("\nDAG_A has " + Integer.toString(DAG_A.edgeCount()) + " edges.");
        System.out.print("DAG_A Adjacency Matrix:"); DAG_A.printAsAdjacencyMatrix();
        
        //find cycles
        for (GraphNode node : DAG_A.getNodes()){
            System.out.print("Cycle of v" + Integer.toString(node.index() + 1) + ": ");
            ArrayList<GraphNode> cycle = DAG_A.findCycle(node);
            if (cycle == null){
                System.out.print("No cycle");
            } else{
                for (GraphNode cycleNode : cycle) {
                    System.out.print(cycleNode.index() + 1);
                    System.out.print(", ");
                }
            }
            System.out.println();
        }


        System.out.println("\n");
        //DAG_B test cases
        System.out.print("DAG_B is a DAG: "); System.out.println(DAG_B.isDAG());
        System.out.print("DAG_B roots: ");
        for (GraphNode node : DAG_B.getRoots()){
            System.out.print(node.index()+1);
            System.out.print(", ");
        }
        System.out.println("\nDAG_B has " + Integer.toString(DAG_B.edgeCount()) + " edges.");
        System.out.print("DAG_B Adjacency Matrix:"); DAG_B.printAsAdjacencyMatrix();

        //find cycles
        for (GraphNode node : DAG_B.getNodes()){
            System.out.print("Cycle of v" + Integer.toString(node.index() + 1) + ": ");
            ArrayList<GraphNode> cycle = DAG_B.findCycle(node);
            if (cycle == null){
                System.out.print("No cycle");
            } else{
                for (GraphNode cycleNode : cycle) {
                    System.out.print(cycleNode.index() + 1);
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
