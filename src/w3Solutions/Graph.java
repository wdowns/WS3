package w3Solutions;

import java.io.*;
import java.util.Scanner;

/**
 *  The class creates an array to represent a graph from a file of the
 *  following form:
 *  <pre>
 * 5
 * 0 4 1
 * 1 2 1
 * 1 3 1
 * 2 1 1
 * 3 1 1
 * 3 4 1
 * 4 0 1
 * 4 3 1
 * </pre>
 * 
 *
 * The first element represents the number of nodes in the graph,
 * which corresponds to the size of the coincidence matrix, that is,
 * 5x5 in this case. The follow the links, e.g., there is a link from
 * node 0 to node 4 with weight 1.
 *
 *  @version 2015-10-19
 *  @author Manfred Kerber
 */
public class Graph{
    private int numberOfNodes;
    private int[][] incidenceMatrix;

    /**
     *  @param filename The name of a file that contains a graph
     *  <pre>
     * 5
     * 0 4 1
     * 1 2 1
     * 1 3 1
     * 2 1 1
     * 3 1 1
     * 3 4 1
     * 4 0 1
     * 4 3 1
     * </pre>
     * 
     *
     * The first element represents the number of nodes in the graph,
     * which corresponds to the size of the coincidence matrix, that is,
     * 5x5 in this case. The follow the links, e.g., there is a link from
     * node 0 to node 4 with weight 1.
     *
     * The first int is set to the numberOfNodes.
     * The following triples form the incidenceMatrix such that i j k means
     * incidenceMatrix[i][j] = k;
     */
    public Graph(String filename) {
        // try since the file may not exist.
        try {
            // we read from the scanner s which is linked to the file filename.
            Scanner s = new Scanner(new File(filename));

    
            // We read the initial element that is in our case "P2"
            numberOfNodes = s.nextInt();
            //We initialize and read in the different pixels.
            incidenceMatrix = new int[numberOfNodes][numberOfNodes];
            int i,j,value;
            while (s.hasNext()) {
                i = s.nextInt();
                j = s.nextInt();
                value = s.nextInt();
                incidenceMatrix[i][j] = value;
            }
            // We finished reading and close the scanner s.
            s.close();
        }
        catch (IOException e){
            //If the file is not found, an error message is printed.
            System.out.println("File not found.");
        }
    }

    /**
     *  @return The numberOfNodes of the graph.
     */
    public int getNumberOfNodes(){
        return numberOfNodes;
    }

    /**
     *  @return The incidence matrix of the graph.
     */
    public int[][] getIncidenceMatrix(){
        return incidenceMatrix;
    }
    
    /**
     *  @param a A two-dimensional array to be printed. 
     *  Using two standard for loops.
     */
    public static void print(int[][] a){
    	for (int i=0; i<a.length; i++) {
	    for (int j=0; j<a[0].length; j++){
		System.out.printf("%1d ",a[i][j]);
	    }
	    System.out.println();
	}
    }

    /**
     *  @return True if the graph is totally connected, false else.
     */
    public boolean isFullyConnected(){
        for (int i = 0; i < getNumberOfNodes(); i++){
            for (int j = 0; j < getNumberOfNodes(); j++){
                if ((j != i) && (incidenceMatrix[i][j] == 0)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *  The method creates a randomly generated graph in the format described in the class and writes it to a file.
     *  @param filename The filename to which the test is to be written. 
     *  @param numberOfNodes The number of nodes of the graph.
     *  @param connectionProbability The probability that any two different nodes are connected.
     */
    public static void createTest(String filename, int numberOfNodes, double connectionProbability) {
        double random;
        // try since it may not be possible to write to filename.
        try {
            BufferedWriter out = 
                new BufferedWriter(new FileWriter(filename));

            // We write the numberOfNodes out.
            out.write(numberOfNodes + "\n");
	
            for (int i = 0; i < numberOfNodes; i++) {
                for (int j = 0; j < numberOfNodes; j++) {
                    random = Math.random();
                    //If j is different from i and the random value is within the threshold then i and j are connected.
                    if (j != i && random <= connectionProbability) {
                        out.write(i + " " + j + " " + 1 + "\n");
                    }
                }
            }
            // We finished reading and close scanner s.
            out.close();
        }
        catch (IOException e){
            //Errors are caught.
            System.out.println("File not found.");
        }
    }

    
    /*
     * Some examples.
     */
    public static void main(String[] args) {
        System.out.println("g1.graph");
        Graph g1 = new Graph("g1.graph");
        print(g1.getIncidenceMatrix());
        System.out.println(g1.isFullyConnected());

        System.out.println("g2.graph");
        Graph g2 = new Graph("g2.graph");
        print(g2.getIncidenceMatrix());
        System.out.println(g2.isFullyConnected());

        System.out.println("g3.graph");
        Graph g3 = new Graph("g3.graph");
        print(g3.getIncidenceMatrix());
        System.out.println(g3.isFullyConnected());

        System.out.println("g4.graph");
        Graph g4 = new Graph("g4.graph");
        print(g4.getIncidenceMatrix());
        System.out.println(g4.isFullyConnected());

        System.out.println("g100.graph with connectionProbability 0.9");
        //createTest("g100.graph", 100, 0.9);
        Graph g100 = new Graph("g100.graph");
        print(g100.getIncidenceMatrix());
        System.out.println(g100.isFullyConnected());

        System.out.println("g1000.graph with connectionProbability 0.2");
        //createTest("g1000.graph", 1000, 0.2);
        Graph g1000 = new Graph("g1000.graph");
        print(g1000.getIncidenceMatrix());
        System.out.println(g1000.isFullyConnected());

        System.out.println("g1001.graph with connectionProbability 1.0");
        //createTest("g1001.graph", 1001, 1.0);
        Graph g1001 = new Graph("g1001.graph");
        print(g1001.getIncidenceMatrix());
        System.out.println(g1001.isFullyConnected());
    }
}
