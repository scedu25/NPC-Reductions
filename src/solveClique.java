/**
 * Eric Du, Josh Vetter
 * IT 328-001
 * Asg1: solveClique.java
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

public class solveClique {

	public static ArrayList<Graph> createGraphsFromFile(String filename) throws Exception {
		ArrayList<Graph> graphList = new ArrayList<Graph>();
		try {
			FileInputStream fis = new FileInputStream(filename);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String brLine = null;
			while ((brLine = br.readLine()) != null) {
				int vertexCount = Integer.parseInt(brLine);
				Graph graph = new Graph(vertexCount);
				for (int i = 0; i < vertexCount; i++) {
					Vertex vertex = new Vertex(i);
					graph.addVertex(vertex);
				}
				for (int i = 0; i < vertexCount; i++) {
					brLine = br.readLine();
					int j = 0;
					for (String s : brLine.split(" ")) {
						int num = Integer.parseInt(s);
						if (i == j) {}
						else if (num == 1) {
							graph.getVertices().get(i).addNeighbor(graph.getVertices().get(j));
							graph.setEdgeCount(graph.getEdgeCount() + 1);
						}
						j++;
					}
				}
				graph.setEdgeCount(graph.getEdgeCount() / 2);
				graphList.add(graph);
			}
			br.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Unable to locate file " + filename);
			System.exit(0);
		}
		
		return graphList;
	}
	
	public static Graph createGraphFromAdjacencyMatrix(int[][] adjacencyMatrix) {
		Graph graph = new Graph(adjacencyMatrix.length);
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			Vertex vertex = new Vertex(i);
			graph.addVertex(vertex);
		}
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			for (int j = 0; j < adjacencyMatrix.length; j++) {
				if (i == j) {}
				else if (adjacencyMatrix[i][j] == 1) {
					graph.getVertices().get(i).addNeighbor(graph.getVertices().get(j));
					graph.setEdgeCount(graph.getEdgeCount() + 1);
				}
			}
		}
		graph.setEdgeCount(graph.getEdgeCount() / 2);

		return graph;
	}
	
	public static void maximalClique(ArrayList<Vertex> R, ArrayList<Vertex> P, ArrayList<Vertex> X, Graph graph) {
		if (P.isEmpty() && X.isEmpty())
			graph.addClique(R);
		for (int i = 0; i < P.size(); i++) {
			Vertex v = P.get(i); 
			ArrayList<Vertex> R1 = new ArrayList<>(R);
			ArrayList<Vertex> P1 = new ArrayList<>(P);
			ArrayList<Vertex> X1 = new ArrayList<>(X);
			R1.add(v);
			P1.retainAll(v.getNeighbors());
			X1.retainAll(v.getNeighbors());
			maximalClique(R1, P1, X1, graph);
			P.remove(v);
			X.add(v);
		}
	}
	
	public static void printCliques(String filename, ArrayList<Graph> graphList) throws Exception {
		for (int i = 0; i < graphList.size()-1; i++) {
			Graph graph = graphList.get(i);
			System.out.print("G" + (i+1) + " (" + graph.getVertexCount() + "," + graph.getEdgeCount() + ") {");
			long startTime = System.currentTimeMillis();
			maximalClique(new ArrayList<Vertex>(), graph.getVertices(), new ArrayList<Vertex>(), graph);
			long elapsedTime = (new Date()).getTime() - startTime;
			ArrayList<Vertex> maxClique = new ArrayList<Vertex>();
			for (ArrayList<Vertex> clique : graph.getCliques()) {
				if (clique.size() > maxClique.size())
					maxClique = new ArrayList<>(clique);
			}
			for (int j = 0; j < maxClique.size(); j++) {
				if (j < maxClique.size()-1)
					System.out.print(maxClique.get(j) + ",");
				else
					System.out.print(maxClique.get(j) + "} (size=" + maxClique.size() + ", " + elapsedTime + " ms)");
			}
			System.out.println();
		}
		System.out.println("***");
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String filename = args[0];
		ArrayList<Graph> graphList = createGraphsFromFile(filename);
		System.out.println("* Max Cliques of graphs in " + filename);
		System.out.println("    (|V|,|E|) Cliques (size, ms used)");
		printCliques(filename, graphList);
	}

}
