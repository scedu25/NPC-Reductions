import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class solveISET {
	
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
						else if (num == 0) {
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
	
	public static void main(String[] args) throws Exception {
		String filename = "src\\" + args[0];
		ArrayList<Graph> graphList = createGraphsFromFile(filename);
		System.out.println("* Max Independent Sets of graphs in " + filename + " : (reduced to K-Clique) *");
		System.out.println("    (|V|,|E|) Independent Set (size, ms used)");
		solveClique.printCliques(filename, graphList);
	}
	
}

/**	
	public static int[][] complementMatrix (int[][] matrix)
    {
    	
    		for (int p = 0; p <= matrix.length -1; p++) 
        {
//            System.out.print(p + " ");
            for (int z = 0; z <= matrix.length - 1; z++) 
            {
            		
            		if(p == z)
            		{
            			//do nothing, keep the diagonal as 1
            		}
            		else if(matrix[p][z] == 1)	
            		{
            			matrix[p][z] = 0;
            		}
            		else
            		{
            			matrix[p][z] = 1;
            		}
            }
//                System.out.print(graph.getEdge(p, z) + " ");
            System.out.println();
        }
    		
		return matrix;
    		
    }
    
    public static void printArray(int matrix[][]) {
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int column = 0; column < matrix[row].length - 1; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

}
*/