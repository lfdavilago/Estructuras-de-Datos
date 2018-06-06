package BinaryTree;

public class Complete {
	
	public Complete()
	{
		
	}
	
	/**
	 * Reconstruir el arbol a partir del post-orden y el pre-orden
	 * @param pre Preorden del arbol
	 * @param post Post orden del arbol
	 * @return Tree   Arbol correspondiente al pre y post orden de entrada
	 */
	public Tree Pre_PostToin(String pre, String post)
	{
		Tree tree = new Tree();
		if(pre.length() == 0)
			return tree;
		else
		{	
			if(pre.length() ==1)
				tree.root = new Node(pre);
			else
			{
				tree.root = new Node(pre.charAt(0) + "");
				tree.root.left = this.Pre_PostToin(pre.substring(1, pre.indexOf(post.charAt(post.indexOf(pre.charAt(0)) - 1))), post).root;
				tree.root.right = this.Pre_PostToin(pre.substring(pre.indexOf(post.charAt(post.indexOf(pre.charAt(0)) - 1))), post).root;
			}
		
			return tree;
		}	
	}
	
	
	
	public Tree in_PostToPre(String pre, String in)
	{
		
		Tree tree = new Tree();
		if(in.length() == 0)
			return new Tree();
		else
		{	
			if(in.length() == 1)
				tree.root = new Node(in);
			else
			{
				int index = -1;
				int max = Integer.MIN_VALUE;
				for(int i = 0; i < in.length() ; i++)
				{	
					int temp  = pre.indexOf(in.charAt(i) + "");
					if(temp > max)
					{	
						max = temp;
						index = i;
					}
				}
			
				tree.root = new Node(in.charAt(index)+"");
				tree.root.left = this.in_PostToPre(pre, in.substring(0,index)).root;
				tree.root.right = this.in_PostToPre(pre, in.substring(index+1)).root;	
			}
			return tree;
				
		}		
				
				
				
	}
		
	public Tree in_PreToPost(String pre, String in)
	{
		if(in.length() == 0)
			return new Tree();	
		else
		{	
			Tree  temp = new Tree();
			if(in.length() == 1)
				temp.root = new Node(in);
			else
			{	
				int[] Arr = new int[in.length()];
			
				for(int i = 0; i < in.length() ; i++)
					Arr[i] = pre.indexOf(in.substring(i,i+1));
			
				int min = Integer.MAX_VALUE;
				int index = -1;
				for(int i = 0; i < Arr.length ; i++)
					if(Arr[i] < min)
					{	
						min = Arr[i];
						index = i;
					}
				String Dw = in.substring(0, index);
				String Up = in.substring(index + 1, in.length());
			
				temp.root = new Node(in.charAt(index) + "");
				temp.root.left = this.in_PreToPost(pre, Dw).root;
				temp.root.right = this.in_PreToPost(pre, Up).root;
			}	
			return temp;
		}
	}
	
	public static void main(String[] args)
	{
		Complete com = new Complete();
		
		Tree tre = com.Pre_PostToin("DBACEGF", "ACBFGED"); // Pre DBACEGF  post ACBFGED 
	
		tre.preorder_print(tre.root);
		System.out.println("----------------------");
		tre.postorder_print(tre.root);
		System.out.println("----------------------");
		tre.inorder_print(tre.root);
		System.out.print("----------------------");
	}	
}
