package MST;

import java.util.ArrayList;

public class Vertex 
{
	protected boolean visited;
	protected ArrayList<Edge> adjedges;
	
	public Vertex() 
	{
		visited = false;
		adjedges = new ArrayList<Edge>();
	}
	
	public void setVisited(boolean vi) 
	{
		visited = vi;
	}
	
	public void setAdjedges(ArrayList<Edge> adj) 
	{
		adjedges = adj;
	}	
	public boolean getVisited() 
	{
		return visited;
	}
	
	public ArrayList<Edge> getAdjedges()
	{
		return adjedges;
	}
}
