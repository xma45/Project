package MST;

import java.util.ArrayList;

public class MinHeap 
{
	private ArrayList<Edge> heap;
	private int size;
	
	private static final int FRONT = 1;
	
	public MinHeap() 
	{
		
		this.size = 0;
		heap = new ArrayList<Edge>();
		heap.add(null);//make sure the first one is null
	}
	
	private int parent(int pos) 
	{
		return pos/2;
	}
	
	private int leftChild(int pos) 
	{
		return (2*pos);
	}
	
	private int rightChild(int pos) 
	{
		return (2*pos)+1;
	}
	
	private boolean isLeaf(int pos)
    {
        if (pos >  (size / 2))
        { 
            return true;
        }
        return false;
    }
	
    private void swap(int fpos, int spos)
    {
    		Edge tmp;
        tmp = heap.get(fpos);
        heap.set(fpos, heap.get(spos));
        heap.set(spos, tmp);
    }
    /*
     * minHeapify:make sure the parent edge is always smaller than its children.
     */
    
    private void minHeapify(int pos)
    {
        if (isLeaf(pos))// make sure that the leaf is exist
        { 
        		return;
        }
    		int child = leftChild(pos);
    		/*
    		 * Compare which child is smaller
    		 */
    		if (rightChild(pos) <= size && heap.get(child).compareTo(heap.get(rightChild(pos)))>0) 
    		{
    			child = rightChild(pos);
    		}
    		/*
    		 * Compare the current with the smaller child
    		 */
    		if (heap.get(pos).compareTo(heap.get(child))<=0) 
    		{
    			return;
    		} 		
    		swap(pos, child);
    		minHeapify(child);
    }
    /*
     * Insert the edge
     */
    public void insert(Edge element)
    {
    		if (heap.size() <= size+1) 
    		{
    			heap.add(element);
    		} else 
    		{
    			heap.set(size+1, element);
    		}
    		size++;
    		int current = size;
    		while(parent(current) > 0 && heap.get(current).compareTo(heap.get(parent(current)))<0)
        {
            swap(current,parent(current));
            current = parent(current);
        }
    }
    /*
     * Extract-minimum edges
     */
    public Edge popout()
    {
    		if (size <= 0) 
    		{
    			return null;
    		}
    		Edge popped = heap.get(FRONT);
    		heap.set(FRONT, heap.get(size--));
//    		System.out.printf("popout size=%d\n", size);
        minHeapify(FRONT);
        return popped;
    }
}
