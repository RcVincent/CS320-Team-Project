package ycp.cs320.teamProject.model;

import java.lang.reflect.Array;
//import java.util.Scanner;
import java.util.Arrays;
import java.util.NoSuchElementException;
public class BinaryHeap<T>    
{
    /** The number of children each node has **/
    private static final int d = 2;
    private int heapSize;
    private int[] heap;
 
    /** Constructor **/    
    public BinaryHeap()
    {
        heapSize = 0;
        heap = new int[1];
        Arrays.fill(heap, -1);
    }
 
    /** Function to check if heap is empty **/
    public boolean isEmpty( )
    {
        return heapSize == 0;
    }
 
    /** Check if heap is full **/
    public boolean isFull( )
    {
        return heapSize == heap.length;
    }
 
    /** Clear heap */
    public void makeEmpty( )
    {
        heapSize = 0;
    }
 
    /** Function to  get index parent of i **/
    private int parent(int i) 
    {
        return (i - 1)/d;
    }
 
    /** Function to get index of k th child of i **/
    private int kthChild(int i, int k) 
    {
        return d * i + k;
    }
 
    /** Function to insert element */
    public void insert(int x)
    {
        if (isFull( ) ){
            throw new NoSuchElementException("Overflow Exception");
        }
        
        if(heapSize > heap.length - 1) {
        	heap = this.resize();
        }
        /** Percolate up **/
        heap[heapSize++] = x;
        heapifyUp(heapSize - 1);
    }
 
    /** Function to find least element **/
    public int findMin( )
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");           
        return heap[0];
    }
 
    /** Function to delete min element **/
    public int deleteMin()
    {
        int keyItem = heap[0];
        delete(0);
        return keyItem;
    }
 
    /** Function to delete element at an index **/
    public int delete(int ind)
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        int keyItem = heap[ind];
        heap[ind] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(ind);        
        return keyItem;
    }
 
    /** Function heapifyUp  **/
    private void heapifyUp(int childInd)
    {
        int tmp = heap[childInd];    
        while (childInd > 0 && tmp < heap[parent(childInd)])
        {
            heap[childInd] = heap[ parent(childInd) ];
            childInd = parent(childInd);
        }                   
        heap[childInd] = tmp;
    }
 
    /** Function heapifyDown **/
    private void heapifyDown(int ind)
    {
        int child;
        int tmp = heap[ ind ];
        while (kthChild(ind, 1) < heapSize)
        {
            child = minChild(ind);
            if (heap[child] < tmp)
                heap[ind] = heap[child];
            else
                break;
            ind = child;
        }
        heap[ind] = tmp;
    }
 
    /** Function to get smallest child **/
    private int minChild(int ind) 
    {
        int bestChild = kthChild(ind, 1);
        int k = 2;
        int pos = kthChild(ind, k);
        while ((k <= d) && (pos < heapSize)) 
        {
            if (heap[pos] < heap[bestChild]) 
                bestChild = pos;
            pos = kthChild(ind, k++);
        }    
        return bestChild;
    }
    
    //Resize 
    protected int[] resize() {
        return Arrays.copyOf(heap, heap.length * 2);
    }
 
    /** Function to print heap **/
    public void printHeap()
    {
        System.out.print("\nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }     
}



//public class BinaryHeap<T extends Comparable<T>> /*implements priorityQueue<T>*/{
/*	
	
	private int heapSize;
	private T[] heap;
	
	@SuppressWarnings("unchecked")
	public BinaryHeap() {
		heapSize = 0;
		heap = (T[]) new Comparable[1];
	}

	//find if the heap is empty
	public boolean isEmpty(){
		return heapSize == 0;
	}
	
	//find if the heap is full
	public boolean isFull() {
		return heapSize == heap.length;
	}
	
	public void makeEmpty() {
		heapSize = 0;
	}
	
	protected int leftChild(int idx) {
		return idx * 2;
	}
	
	protected int rightChild(int idx) {
		return 2 * idx + 1;
	}
	
	//find the parent of the desired index
	protected int parentIndex(int idx) {
		return idx/ 2;
	}
	
	protected boolean hasParent(int idx) {
		return idx > 1; 
	}
	
	protected boolean hasLeftChild(int idx) {
		return leftChild(idx) <= heapSize;
	}
	
	protected boolean hasRightChild(int idx) {
		return rightChild(idx) <= heapSize;
	}
	protected T parent(int idx) {
		return heap[parentIndex(idx)];
	}
	
	//insert element into the heap
	public void insert(T x) {
		if(isFull()) {
			throw new NoSuchElementException("Overflow Exception");
		}
		
		//resize the array if needed
		if(heapSize > heap.length - 1) {
			heap = this.resizeArray();
		}
		
			heap[heapSize++] = x;
		percolateUp(heapSize - 1);
	}
	
	//delete from the heap
	public T delete(int idx) {
		if (isEmpty()) {
			throw new NoSuchElementException("Underflow Exception");
		}
		T key = heap[idx];
		heap[idx] = heap[heapSize - 1];
		heapSize--;
		percolateDown(idx);
		return key;
	}
	
	//remove the smallest element
	public T deleteMin() {
		T key = heap[0];
		delete(0);
		return key;
	}
	
	//return the minimum child
	public T findMin() {
		
		if(isEmpty()) {
			throw new NoSuchElementException("Underflow excpetion");
		}
		
		return heap[0];
	}
	
	//for insert
	public void percolateUp(int idx) {
		
		while (hasParent(idx) && (parent(idx).compareTo(heap[idx]) > 0)) {
			swap(idx, parentIndex(idx));
			idx = parentIndex(idx);		
		}
	}
	
	//for delete
	public void percolateDown(int idx) {
		
		
		while(hasLeftChild(idx)) {
			int minChild = leftChild(idx);
			
			if(hasRightChild(idx) && heap[leftChild(idx)].compareTo(heap[rightChild(idx)]) > 0 ) {
				minChild = rightChild(idx);
			}
			
			if(heap[idx].compareTo(heap[minChild]) > 0) {
				swap(idx, minChild);
			}
		}
	}
	
	
	
	public T[] resizeArray() {
		return Arrays.copyOf(heap, heap.length * 2);
		
	}
	
	//used in the percolate methods
	protected void swap(int index1, int index2) {
        T temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;        
    }
	
	//print out the heap
	public void printHeap() {
		System.out.print("\nHeap = ");
		for(int i = 0; i < heapSize; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}
}*/


