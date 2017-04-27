import java.util.ArrayList;
import java.util.Iterator;

public class programming_assignment_3 {
    public static void main(String [] args){

        String str_A = "[v4,v1][v5,v1][v3,v10][v5,v2][v6,v2][v6,v3][v7,v3][v8,v4][v9,v4][v9,v5][v10,v5][v10,v6][v10,v7][v11,v7][v12,v8][v12,v9][v13,v10][v13,v11][v14,v12][v14,v13][v15,v1][v15,v2]";
        String str_B = "[v4,v1][v5,v1][v5,v2][v6,v2][v6,v3][v7,v3][v8,v4][v9,v4][v9,v5][v10,v5][v10,v6][v10,v7][v11,v7][v12,v8][v12,v9][v13,v10][v13,v11][v14,v12][v14,v13][v15,v1][v15,v2]";
        DirectedGraph DAG_A = new DirectedGraph(str_A);


        System.out.println("\n\n\n\n");
        DAG_A.testing();
        System.out.print("\n\nDAG_A is a DAG: "); System.out.println(DAG_A.isDAG());


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
    }
}
