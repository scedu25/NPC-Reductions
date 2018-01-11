import java.util.ArrayList;
import java.util.List;

/**
 * Eric Du, Josh Vetter
 * IT 328-001
 * Asg1: Graph.java
 */

public class Graph {
	
	private int vertexCount;
	private int edgeCount;
	private ArrayList<Vertex> vertices;
	private List<ArrayList<Vertex>> cliques;
	
	public Graph(int v) {
		vertexCount = v;
		edgeCount = 0;
		vertices = new ArrayList<Vertex>();
		cliques = new ArrayList<ArrayList<Vertex>>();
	}

	public int getVertexCount() {
		return vertexCount;
	}

	public void setVertexCount(int vertexCount) {
		this.vertexCount = vertexCount;
	}
	
	public int getEdgeCount() {
		return edgeCount;
	}
	
	public void setEdgeCount(int edgeCount) {
		this.edgeCount = edgeCount;
	}
	
	public ArrayList<Vertex> getVertices() {
		return vertices;
	}
	
	public void addVertex(Vertex vertex) {
		this.vertices.add(vertex);
	}

	public List<ArrayList<Vertex>> getCliques() {
		return cliques;
	}

	public void addClique(ArrayList<Vertex> clique) {
		this.cliques.add(clique);
	}
	
}
