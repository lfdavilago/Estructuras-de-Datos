package Data;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class List {

	
	public Secuencia head;
	
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
		Secuencia temp = this.head;
	    int Size = 0;
	    while(temp != null)
	    {
	    	temp = temp.next;
	    	Size++;
	    }
	    return Size;
	}
	
	public void insertAtBegin(Secuencia newNode)
	{
		newNode.next = this.head;
		this.head = newNode;
	}
	
	public void printList() throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Secuencia temp = head;
		bw.write("Grades: \n");
		while(temp !=null)
		{
			bw.write(temp.toString()+"\n");
			temp= temp.next;
		}
		bw.flush();
	}
	
	public void insertAtEnd(Secuencia newNode)
	{
		if(isEmpty())
			this.head = newNode;
		else
		{
			Secuencia temp = head;
			
			while(temp.next != null)
				temp = temp.next;
			
			temp.next = newNode;
		}
	}
	
	public void deleteAtBegin()
	{   
		Secuencia temp = this.head; 
		this.head = this.head.next;
		temp = null;
		System.gc();
	}
	
	public boolean insertAtIndex(Secuencia newNode, int location)
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
        Secuencia temp = this.head;
	    for(int i = 0 ; i < location - 1 ; i++)
	    	temp = temp.next;
		newNode.next = temp.next;
		temp.next = newNode;
		return true;	
	}
	
	public void deleteAtEnd()
	{
		Secuencia temp = this.head;
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
		Secuencia temp = this.head;
		for(int i = 0; i < Index - 1; i++)
			temp = temp.next;
		Secuencia toDelete = temp.next;
		temp.next = toDelete.next;
		toDelete = null;
		System.gc();
		return true;
	}
	
/**public void Inversa()
	{
		Stack pila = new Stack();
		Node temp = this.head;
		
		while(temp != null)
		{
			pila.push(temp.clone());
			temp = temp.next;
		}
		
		this.head = pila.head;
	}
	*/
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
	}

}
