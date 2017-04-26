import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.Iterator;

public class programming_assignment_3 {
    public static void main(String [] args){

        String str_A = "[v4,v1][v5,v1][v5,v2][v6,v2][v6,v3][v7,v3][v8,v4][v9,v4][v9,v5][v10,v5][v10,v6][v10,v7][v11,v7][v12,v8][v12,v9][v13,v10][v13,v11][v14,v12][v14,v13][v15,v1][v15,v2]";
        DirectedGraph DAG_A = new DirectedGraph(str_A);
        Iterator<GraphNode> Nodes_A = DAG_A.getNodes();

        GraphNode node;
        while (Nodes_A.hasNext()){
            node = Nodes_A.next();
            if (node != null){
                System.out.println(node.index() + 1);
            }
            else{
                System.out.println("uhoh");
            }
        }

        System.out.println("\n\n\n\n");
        DAG_A.testing();
        DAG_A.printAsAdjacencyMatrix();
    }
}
