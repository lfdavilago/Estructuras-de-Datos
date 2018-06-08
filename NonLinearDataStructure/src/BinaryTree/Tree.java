package BinaryTree;

public class Tree {
	
	public Node root;
	
	public Tree()
	{
		this.root = null;
	}
	
	public boolean isEmpty()
	{
		return this.root == null ? true:false;
	}
	
	public int offSpring(Node node)
	{
		return (node.left != null) ? (node.right != null ? 2 : 1) : (node.right != null ? 1 : 0);
	}
	
	public void insert(int value)
	{
		if(this.isEmpty())
			this.root = new Node(value);
		else
		{
			Node temp = this.root;
			Node padre = null;
			boolean left = false;
			while(temp != null)
			{	
				padre = temp;
				if(temp.value > value)
				{	
					temp = temp.left;
					left = true;
				}
				else
				{
					temp = temp.right;
					left = false;
				}
			}
			
			temp = new Node(value);
			
			if(left)
				padre.left = temp;
			else
				padre.right = temp;
		}
	}
	
	public void delete(int value)
	{
		Node temp = this.root;
		Node parent = this.root;
		boolean left = false;
		while(temp != null)
			if(temp.value == value)
				break;
			else
			{	
				parent = temp;
				if(value < temp.value)
				{
					temp = temp.left;
					left = true;
				}	
				else
				{
					temp = temp.right;
					left = false;
				}	
			}
		
		if(temp != null)
		{
			int count = this.offSpring(temp);
			
			if(count == 0)
			{	
				if(this.root.equals(temp))
					this.root = null;
				else
					if(left)
						parent.left = null;
					else
						parent.right = null;
			}
			else if(count == 1)
			{	
				if(temp.left != null)
				{	
					if(this.root.equals(temp))
						this.root = temp.left;
					else
					{	
						if(left)
							parent.left = temp.left;
						else
							parent.right = temp.left;
					}
				}
				else
					if(this.root.equals(temp))
						this.root = temp.right;
					else
					{
						if(left)
							parent.left = temp.right;
						else
							parent.right = temp.right;
					}
			}
			else
			{
				Node min = temp.right;
				Node minParent = min;
				
				while(min.left != null)
				{	
					minParent = min;
					min = min.left;
				}	
				
				if(!minParent.equals(min))
				{
					if(min.right != null)
						minParent.left = min.right;
					else
						minParent.left = null;
					min.right = temp.right;
				}
				
				min.left = temp.left;
				
				if(this.root.equals(temp))
				{
					System.out.println("PRUEBAAAAAAAAAA");
					this.root = min;
				}
				else
				{
					if(left)
						parent.left = min;
					else
						parent.right = min;	
				}
			}
		}
	}
	
	public Node search(int value)
	{
		Node temp = this.root;
		
		while(temp != null)
			if(temp.value == value)
				return temp;
			else
				if(value < temp.value)
					temp = temp.left;
				else
					temp = temp.right;
		
		return null;
	}
	
	public void inorder_print(Node node)
	{
		if(node != null)
		{
			this.inorder_print(node.left);
			System.out.print(node.toString2());
			this.inorder_print(node.right);
		}
	}
	
	public void postorder_print(Node node)
	{
		if(node != null)
		{
			this.postorder_print(node.left);
			this.postorder_print(node.right);
			System.out.print(node.toString2());
		}
	}
	
	public void preorder_print(Node node)
	{
		if(node != null)
		{
			System.out.print(node.toString2());
			this.preorder_print(node.left);
			this.preorder_print(node.right);
		}
	}
	
	
	
		
		
		
		
		
	public static void main(String[] args)
	{
		
		Tree test = new Tree();
		
		test.insert(52);
		test.insert(13);
		test.insert(74);
		test.insert(60);
		test.insert(87);
		test.insert(83);
		test.insert(100);
		test.insert(85);
		test.insert(53);
		
		test.delete(52);
		test.delete(74);
		test.preorder_print(test.root);

		

		
		
		
	}
}
