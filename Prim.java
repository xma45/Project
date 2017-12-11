package MST;

import java.util.ArrayList;

public class Prim extends ReadFile 
{	
	private MinHeap heap = new MinHeap();
	private ArrayList<Vertex> adjList;
	private ArrayList<Edge> MST = new ArrayList<Edge>();
	Edge e = new Edge();	
	Vertex v = new Vertex();
	Vertex w = new Vertex();
	
	/*
	 * edges --> adjList
	 */
	public void buildGraph(ArrayList<Edge> edges) 
	{
		adjList = new ArrayList<Vertex>();
		
		/*
		 * Initialize the adjList
		 */
		for(int i = 0; i<vertexNumber;i++) 
		{
			adjList.add(new Vertex());
		}
		
		/*
		 * edges --> adjList
		 */
		for(int i = 0; i<EdgeNumber;i++) //get one vertex's adjList
		{		
			Edge e = edges.get(i);		//for every edge
			
			/*
			 * assign every vertex with adjacency edges.
			 * For each adjList, it has two vertex (e.from,e.to).
			 * We need to give those two vertex adjacent List, each
			 * of the vertex have the same adjList e.
			 */
			Vertex v = adjList.get(e.to);//v is one vertex of this edge
			v.adjedges.add(e);			
			v = adjList.get(e.from);//v is one vertex of this edge
			v.adjedges.add(e);
		}
	}
	
	/*
	 * Put all adjacency edges of u and then pop out the minimum adjacency edges 
	 * of u and put it into MST then assign v to visited then recursively
	 */
	public void PrimAlgorithm(String a) 
	{
		openFile(a);
		buildGraph(edges);
		v = adjList.get(0);// get the first vertex
		v.visited =true;
		for(int i = 0; i<v.adjedges.size();i++) 
		{
			heap.insert(v.adjedges.get(i));
		}
		while(true) 
		{
			if (MST.size() >= vertexNumber-1) 
			{
				break;
			}
			e = heap.popout();
			if (e == null) 
			{
				break;
			}
			v = adjList.get(e.from);
			Vertex u = adjList.get(e.to);
			if(v.visited && u.visited) 
			{
				continue;
			}
			MST.add(e);
			
			if(v.visited) 
			{
				w = u;
			}
			else 
			{
				w = v;
			}			
			w.visited=true;
			for(int i = 0; i<w.adjedges.size();i++) 
			{
				heap.insert(w.adjedges.get(i));
			}
		}//end of while loop
	}//end of PrimAlgorithm
	
	public String printPrim() 
	{
		String PrimOut=MST.size()+"\r\n";
		for( int i = 0 ;i < MST.size(); i++)
		{
			Edge e = MST.get(i);
			String fromName = vertexCh.get(e.from);
			String toName = vertexCh.get(e.to);
			String output ="("+fromName+","+toName+")="+e.getWeight()+"\r\n";
			PrimOut+=output;
		}
		return PrimOut;
	}

}//end of Class
