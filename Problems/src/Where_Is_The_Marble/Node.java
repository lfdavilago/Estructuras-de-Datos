package Where_Is_The_Marble;

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
}
