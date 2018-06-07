package Logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;

import Data.Node;

public class List {

	
	public Node head;
	
	public List()
	{
		this.head = null;
	}
	/**
	 * isEmpty
	 * @return True if the Node is Empty. 
	 */
	public boolean isEmpty() 
	{
		return head==null? true : false;
	}
	
	public int Size()
	{
		Node temp = this.head;
	    int Size = 0;
	    while(temp != null)
	    {
	    	temp = temp.next;
	    	Size++;
	    }
	    return Size;
	}
	
	public void insertAtBegin(Node newNode)
	{
		newNode.next = this.head;
		this.head = newNode;
	}
	
	public void printList() throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Node temp = this.head;
		while(temp !=null)
		{
			bw.write(temp.toString());
			temp = temp.next;
		}
		bw.flush();
	}
	
	public void insertAtEnd(Node newNode)
	{
		if(isEmpty())
			this.head = newNode;
		else
		{
			Node temp = head;
			
			while(temp.next != null)
				temp = temp.next;
			
			temp.next = newNode;
		}
	}
	
	public void deleteAtBegin()
	{   
		Node temp = this.head; 
		this.head = this.head.next;
		temp = null;
		System.gc();
	}
	
	public void updateAll(Node oldNode, Node newNode)
	{
		Node temp = head;
		Node previous = head;
		
		while(temp != null)
		{
			if(temp.isEqual(oldNode))
			{
				newNode.setNext( temp.getNext() );
				previous.setNext(newNode);
				temp = null;
				previous = newNode;
				temp = newNode.getNext();
			}
			else
			{
				previous = temp;
				temp = temp.getNext();
			}
		}
	}
	
	public void updateFirst(Node oldNode, Node newNode)
	{
		Node temp = head;
		Node previous = head;
		
		while(temp != null)
		{
			if(temp.isEqual(oldNode))
			{
				newNode.setNext( temp.getNext() );
				previous.setNext(newNode);
				temp = null;
				break;
			}
			
			previous = temp;
			temp = temp.getNext();
		}
	}
	 
		public int indexOf(Node node)
		{
			int index = -1;
			Node temp = head;
			
			while(temp != null)
			{
				index += 1;
				if(temp.isEqual(node))
					return index;
				
				temp = temp.getNext();
			}
			 
			index = -1;
			return index;
		}
	public List searchAll(Node node)
	{
		Node temp = head;
		List results = new List();
		
		while(temp != null)
		{
			if(temp.isEqual(node))
			{	
				results.insertAtEnd(temp.clone());
			}
			
			temp = temp.getNext();
		}
		
		return results;
	}
	
	public Node linealSearch(Node node)
	{
		Node temp = head;
		Node result = null;
		
		while(temp != null)
			if(temp.isEqual(node))
			{	
				result =  temp;
				break;
			}
			else
				temp = temp.getNext();
			
		return result;
	}
	
	public boolean insertAtIndex(Node newNode, int location)
	{
		if(location < 0 || location > this.Size()) return false;
		
		if(location == 0)
		{
			this.insertAtBegin(newNode);
			return true;
		}
		
		if(location == this.Size())
		{
			this.insertAtEnd(newNode);
			return true;
		}
        Node temp = this.head;
	    for(int i = 0 ; i < location - 1 ; i++)
	    	temp = temp.next;
		newNode.next = temp.next;
		temp.next = newNode;
		return true;	
	}
	
	public void deleteAtEnd()
	{
		Node temp = this.head;
		while(temp.next.next != null)
			temp = temp.next;
		temp.next = null;
		System.gc();
	}
	
	public boolean deleteAtIndex(int Index) 
	{
		if(Index < 0 || Index >= this.Size()) return false;
		
		if(Index == 0)
		{
			this.deleteAtBegin();
			return true;
		}
		
		if(Index == this.Size()-1)
		{
			this.deleteAtEnd();
			return true;
		}
		Node temp = this.head;
		for(int i = 0; i < Index - 1; i++)
			temp = temp.next;
		Node toDelete = temp.next;
		temp.next = toDelete.next;
		toDelete = null;
		System.gc();
		return true;
	}
	
	public List reverse()
	{
		Stack pila = new Stack();
		Node temp = this.head;
		List reverse= new List();
		while(temp != null)
		{
			pila.push(temp.clone());
			temp = temp.next;
		}
		
		reverse.head = pila.head;
		
		return reverse;
	}
	
	public int length()
	{
		int length = 0;
		Node temp = this.head;
		while(temp != null)
		{
			length++;
			temp = temp.next;
		}
		return length;
	}
	
	public Node get(int index)
	{
		if(index < this.length())
		{
			Node temp = this.head;
			for(int i = 0; i < index; i++)
				temp = temp.next;
			return temp;
		}
		else
			return null;
	}
	public List sublist(int begin)
	{
		List subList = new List();
		
		if(begin < this.length())
		{
			Node temp = head;
			
			for(int i = 0; i < begin; i++)
				temp = temp.next;
			
			while(temp != null)
			{
				subList.insertAtEnd(temp.clone());
				temp = temp.next;
			}
		}
		
		return subList;
	}
	public List sublist(int begin, int end)
	{
		List subList = new List();
		Node temp = this.head;
		for(int i = 0; i < begin ; i++)
			temp=temp.next;
		int iterar = end - begin;
		for(int j = 0 ; j < iterar ; j++)
		{
			subList.insertAtEnd(temp.clone());
			temp = temp.next;
		}
		
		return subList;
	}
	
	public Node BinarySearch(int value, int Dw, int Up)
	{
		int MidPoint = (Dw + Up)/2;
		Node temp = this.get(MidPoint);
		if(Dw == Up)
			if(temp.value == value)
				return temp;
			else
				return null;
		else
			if(value > temp.value)
				return BinarySearch(value, MidPoint + 1, Up);
			else if(value < temp.value)
				return BinarySearch(value, Dw, MidPoint - 1);
			else 
				return temp;
	}
	
	public List QuickSort()
	{
		if(this.length() <= 1)
			return this;
		else
		{
			Node pivot = this.head;
			List less_sublist = new List();
			List greater_sublist = new List();
			
			Node temp = this.head.next;
			while(temp != null)
			{
				if(temp.value < pivot.value)
					less_sublist.insertAtEnd(temp.clone());
				else
					greater_sublist.insertAtEnd(temp.clone());
				temp = temp.next;
			}
			
			less_sublist = less_sublist.QuickSort();
			greater_sublist = greater_sublist.QuickSort();
			
			pivot.next = greater_sublist.head;
			less_sublist.insertAtEnd(pivot);
			
			return less_sublist;
		}
	} 
	
	
	public boolean isEqual(List list)
	{
		boolean isEqual = true;
		Node tempCurrent = head;
		Node tempList = list.head;
		
		while(tempCurrent != null && tempList != null)
			if(tempCurrent.isEqual(tempList))
			{
				tempCurrent = tempCurrent.next;
				tempList = tempList.next;
			}
			else
			{
				isEqual = false;
				break;
			}
		return isEqual;
	}
	
	public List cloneList()
	{
		List clone = new List();
		Node temp = this.head;
		while(temp != null)
		{
			clone.insertAtEnd(temp.clone());
			temp = temp.next;
		}
		return clone;
	}
	
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in)); 
		
		List Unsorted = new List();
		
		Random rd = new Random();
		
		for(int i = 0 ; i < 1000 ; i++)
			Unsorted.insertAtBegin(new Node(rd.nextInt(100)));
		Unsorted.printList();
		System.out.print("fin lista en desorten \n Inici lista ordenda");
		Unsorted = Unsorted.QuickSort();
	    Unsorted.printList();
	
	    ArrayList<List> lista = new ArrayList<>();
	    lista.add(new List());
	    
	}

}
