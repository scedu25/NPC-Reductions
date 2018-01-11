import java.util.ArrayList;

/**
 * Eric Du, Josh Vetter
 * IT 328-001
 * Asg1: Vertex.java
 */

public class Vertex {
	private int vertexNumber;
	private ArrayList<Vertex> neighbors;
	
	public Vertex(int number) {
		vertexNumber = number;
		neighbors = new ArrayList<Vertex>();
	}
	
	@Override
	public String toString() {
		return String.valueOf(vertexNumber);
	}

	public int getVertexNumber() {
		return vertexNumber;
	}
	
	public void setVertexNumber(int vertexNumber) {
		this.vertexNumber = vertexNumber;
	}
	
	public ArrayList<Vertex> getNeighbors() {
		return neighbors;
	}
	
	public void addNeighbor(Vertex neighbor) {
		this.neighbors.add(neighbor);
	}
}
