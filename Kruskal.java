package MST;

import java.util.ArrayList;

public class Kruskal extends ReadFile
{
	
		Edge e = new Edge();	
		Vertex v = new Vertex();
		Vertex w = new Vertex();
		private int[] parent;
		private MinHeap heap = new MinHeap();
		private ArrayList<Edge> MST = new ArrayList<Edge>();
		
		/*
		 * union a's parent to the node b.
		 */
		public void makeUnion(int a, int b) 
		{
			parent[find(a)] = find(b);
		}
		
		/*
		 * Find the a's parent
		 * find the root node of the node a
		 */
		public int find(int a) 
		{
			if (parent[a] == a) 
			{
				return a;
			}
			return parent[a] = find(parent[a]);//path compression
		}
		
		/*
		 * Kruskal's Algorithm runtime complexity is O(ElogV)
		 */
		public void KruskalAlgorithm(String a) 
		{
			openFile(a);
			parent = new int[vertexNumber];
			/*
			 * Initialize parents
			 */
			for( int i = 0 ;i < vertexNumber; i++)
			{
				parent[i] = i;
			}
			/*
			 * Insert all edges into the heap
			 */
			for(int i = 0; i <EdgeNumber;i++) 
			{
				heap.insert(edges.get(i));
			}
			/*
			 * Extract the minimum edge from heap and insert it into the MST
			 * If e.from and e.to is not in the same set then union those two.
			 */
			while(MST.size()!=vertexNumber-1) 
			{
				e = heap.popout();
				if( find(e.from) != find(e.to) )
				{
					MST.add( e );
					makeUnion( e.from, e.to);
				}
			}//end while.
		}//end KruskalAlgorithm
		
		public String printKruskal() 
		{
			String KruskalOut=MST.size()+"\r\n";
				for( int i = 0 ;i < MST.size(); i++)
				{
					Edge e = MST.get(i);
					String fromName = vertexCh.get(e.from);
					String toName = vertexCh.get(e.to);
					String output ="("+fromName+","+toName+")="+e.getWeight()+"\r\n";
					KruskalOut+=output;
				}
				return KruskalOut;
		}//end of printKruskal
		
	}
