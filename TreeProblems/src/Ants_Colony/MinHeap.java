package Ants_Colony;

import java.util.ArrayList;

public class MinHeap {
	public Node[] nodos;
	public int size;
	
	public MinHeap(int maxSize)
	{
		this.nodos = new Node[maxSize];
		this.size = 0;
	}
	
	public boolean isEmpty()
	{
		return this.size == 0 ? true : false;
	}
	
	public int parent(int i)
	{
		return (i - 1)/2;	
	}
	
	public int leftChild(int i)
	{
		return i*2 + 1;
	}
	
	public int rightChlid(int i)
	{
		return i*2 + 2;
	}

	public void swapp(int i , int j)
	{
		Node temp = this.nodos[i];
		this.nodos[i] = this.nodos[j];
		this.nodos[j] = temp;
	}
	
	public void siftUp(int i)
	{
		while(i > 0 && this.nodos[i].weight < this.nodos[this.parent(i)].weight)
		{
			this.swapp(i, this.parent(i));
			i = this.parent(i);	
		}
	}
	
	public void siftDown(int i)
	{
		int minIndex = i;
		int left = this.leftChild(i);
		if(left <= this.size && this.nodos[left].weight < this.nodos[minIndex].weight)
			minIndex = left;
		int right = this.rightChlid(i);
		if(right <= this.size && this.nodos[right].weight < this.nodos[minIndex].weight)
			minIndex = right;
		if(i != minIndex)
		{	
			this.swapp(minIndex, i);
			this.siftDown(minIndex);
		}	
	}
	
	public void insert(Node newNode)
	{
		this.size = this.size + 1;
		this.nodos[this.size - 1] = newNode;
		this.siftUp(this.size - 1);
	}
	
	public void changeKey(int i, int p)
	{
		int old = this.nodos[i].weight;
		this.nodos[i].weight = p;
		
		if(old > this.nodos[i].weight)
			this.siftUp(i);
		else
			this.siftDown(i);
	}
	
	public Node getMin()
	{
		Node min = this.nodos[0];
		
		if(this.size != 0)
		{
			this.nodos[0] = this.nodos[this.size - 1];
			this.siftDown(0);
			this.size--;
			this.actualizarAdyacentes(min);
		}
		else
			this.nodos[0] = null;
		
		return min;
	}
	
	public void actualizarAdyacentes(Node root)
	{	
		ArrayList<Node> adyacente = root.ramas;
		for(int i = 0; i < this.nodos.length ; i++)
			if(adyacente.contains(this.nodos[i]) && this.nodos[i].weight > root.weight + this.nodos[i].linkWeight.get(this.nodos[i].ramas.indexOf(root)))
				this.changeKey(i, root.weight + this.nodos[i].linkWeight.get(this.nodos[i].ramas.indexOf(root)));	
	}
	
}
