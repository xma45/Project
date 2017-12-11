package MST;

public class Edge implements Comparable<Edge> 
{
	protected int from;
	protected int to;
	protected int weight;
	
	public Edge() 
	{
		from = 0;
		to = 0;
		weight = 0;
	}
	
	public Edge(int from, int to, int weight) 
	{
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	public void setFrom(int f) 
	{
		from = f;
	}
	
	public void setTo(int t) 
	{
		to = t;
	}
	
	public void setWeight(int w) 
	{
		weight = w;
	}
	
	public int getFrom() 
	{
		return from;
	}
	
	public int getTo() 
	{
		return to;
	}
	
	public int getWeight() 
	{
		return weight;
	}
	
	@Override
	public int compareTo(Edge o) 
	{
		if (this.weight < o.weight) return -1;
		else if (this.weight > o.weight) return 1;
		return 0;
	}

}
