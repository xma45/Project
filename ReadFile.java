package MST;
import java.io.*;
import java.util.*;

public class ReadFile {
	
	public int vertexNumber;
	public String vertex;
	public String[] vertexCharName;
	public int EdgeNumber;
	public String filepath ="";
	HashMap<String,Integer> vertexNo = new HashMap<String,Integer>();
	HashMap<Integer,String> vertexCh = new HashMap<Integer,String>();
	ArrayList<Edge> edges = new ArrayList<Edge>();
	ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	Edge e = new Edge();
	Vertex v = new Vertex();
	Scanner input = new Scanner(System.in);
	
	public void openFile(String a) {
		try {
			FileInputStream fis = new FileInputStream(a);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			/*
			 * Get the total vertex number from the ReadFile
			 */
			vertexNumber=Integer.parseInt(br.readLine());	//read the total vertex number
			
			/*
			 * Get every vertex character from the ReadFile
			 */
			vertex=br.readLine();
			vertexCharName=vertex.split(",");				//read all vertex name (a,b,c,d,e...)
			for(int i = 0; i < vertexNumber; i++) {			
				vertexNo.put(vertexCharName[i], i);		//get the vertex key-value pair a-1, b-2, c-3...
			}
			for(int i = 0; i < vertexNumber; i++) {		//get the vertex key-value pair 1-a, b-2, c-3...
				vertexCh.put(i,vertexCharName[i]);
			}
			
			/*
			 * Get the total edges number from the ReadFile
			 */
			EdgeNumber=Integer.parseInt(br.readLine());	//read the total edge number
			
			/*
			 * Get every edges information from the ReadFile
			 */
			for(int i=0;i<EdgeNumber;i++) {
				e = new Edge();
				String[] first = br.readLine().split(",");
				String[] second = first[0].split("\\(");
				e.setFrom(vertexNo.get(second[1]));
				String[] third = first[1].split("\\)=");
				e.setTo(vertexNo.get(third[0]));
				e.setWeight(Integer.parseInt(third[1]));
				edges.add(e);		//record edge to ArrayList edges
			}//end for-loop	
			br.close();
		}catch(Exception e) {
			System.out.println(e.toString());
			System.out.println(e.getStackTrace()[0].getLineNumber());
			System.out.println("Could not Find the File");
		}
	}//end of openFile
	
}
