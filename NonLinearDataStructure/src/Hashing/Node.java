package Hashing;

public class Node {
	
	public int value;
	
	public Node next; // Pointer
    /**
     * Non - Parameters
     */
	public Node() {}
	
	/**
	 * Constructor of Node
	 * @param grade
	 * @param value
	 */
	public Node(int value) 
	{
		this.value = value;
		this.next = null;
	}
	
	/**
	* Return String of all atributes of Node class
	*/ 
	public String toString() 
	{
		return   this.value + " ";
	}
	
	public Node clone() 
	{
		Node temp = new Node(this.value);
		return temp;
	}

	public Node getNext() {
		// TODO Auto-generated method stub
		return this.next;
	}

	public boolean isEqual(Node tempList) {
		// TODO Auto-generated method stub
		if(this.value == tempList.value)
			return true;
		return false;
	}

	public void setNext(Node next2) {
		// TODO Auto-generated method stub
		this.next = next2;
	}
}
