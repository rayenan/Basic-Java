/*****************************************************************/
/*                                                               */
/*   Student name: Renee Fung                                    */
/*                                                               */
/*   Student ID number: V00778609                                */
/*                                                               */
/*****************************************************************/

import java.util.*;
import java.io.*;

public class Graph
{
    // Question 3: Declare the fields of your object here.
    int[][] adjMatrix;
    int graphVertex;
    int graphEdges;

    //RF: Main method for testing purposes 
    /***********************************************************************************
    public static void main(String [] args) {
        EdgeList edges;

        //Scanner in = new Scanner("5 7 0 1 1 0 2 3 1 2 4 2 3 5 2 4 6 4 3 6 4 0 2");
        Scanner in = new Scanner("6 6 2 0 4 1 2 3 2 3 5 1 4 6 3 5 1 2 4 5");

        edges = EdgeList.readEdgeList(in);

        Graph graph = new Graph(edges); 

        //Test print
        graph.print();
        
        //Test delete
        graph.delete(0, 1);
        System.out.println();
        graph.print();

    } 
    *************************************************************************************/

    // Question 3: your constructor for a graph.
    public Graph(EdgeList edges)
    {
        graphEdges = edges.m;
        //RF: Use adjacency matrix, fill it in with weights 
        graphVertex = edges.n;
        adjMatrix = new int[graphVertex][graphVertex];

        EdgeNode test = edges.start;
        while(test != null) {
            adjMatrix[test.u][test.v] = test.weight;
            adjMatrix[test.v][test.u] = test.weight;

            test = test.next;
        }

    }

    // Question 4: Include code for printing your graph as you 
    // are debugging in a nice human-readable format.
    public void print()
    {
        //RF: Loop through matrix and print
        for(int i = 0; i < graphVertex; i++) {
            for(int j = 0; j < graphVertex; j++) {
                System.out.print(" " + adjMatrix[i][j]);
            }

            System.out.println(" ");
        }
    }

    // You may include other methods here for accessing a graph
    // for use by other questions.

    //RF: Add delete method 
    public void delete(int u, int v) {
        //RF: Change selected u and v to zero
        adjMatrix[u][v] = 0;
        adjMatrix[v][u] = 0;
    }


}
