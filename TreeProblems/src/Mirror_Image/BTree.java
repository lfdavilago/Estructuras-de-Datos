package Mirror_Image;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BTree {
	
	private Node root;
		
	private Node[] nodos;

	public BTree()
	{
		this.nodos = new Node[1];
		this.root = this.nodos[0];
	}
	
	public void addLink(int src, int dest, String Addto)
	{
		this.nodos[src - 1].setChild(this.nodos[dest - 1], Addto);
	}
	
	public void getPath(int j, Node[] n, ArrayList<Integer> x)
	{
		if(j != 0)
		{
			if(n[(j - 1)/2].left != null)
				if(n[(j - 1)/2].left.equals(n[j]))
					x.add(1);
				else
					x.add(0);
			else
				x.add(0);
			
			this.getPath((j-1)/2, n, x);
		}
	}
			
	public Node mirrorTo(int i, Node[] n)
	{
		int j = 0;
		for(j = 0; j < n.length; j++)
			if(n[j] != null)
				if(n[j].value == i)
					break;

		ArrayList<Integer> path = new ArrayList<>();
		this.getPath(j, n, path);
		
		Node temp = this.root;
		
		for(int x = path.size() - 1; x >= 0 ; x--)
		{
			if(temp == null)
				return new Node(-1);
			
			if(path.get(x) == 1)
				temp = temp.right;
			else
				temp = temp.left;
		}
		if(temp == null)
			return new Node(-1);
		return temp;
	}
	
	public void solveMirror() throws IOException
	{
		File input = new File("input.txt");
		if(!input.exists())
			input.createNewFile();
		BufferedReader br = new BufferedReader(new FileReader(input));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] line = br.readLine().split(" ");
		
		int N = Integer.parseInt(line[0]);
		int Q = Integer.parseInt(line[1]);
		
		this.nodos = new Node[N];
	
		for(int i = 0; i < N ; i++)
			this.nodos[i] = new Node(i + 1);
		
		this.root = this.nodos[0];
		
		for(int i = 0; i < N - 1  ; i++)
		{
			line = br.readLine().split(" ");
			this.addLink(Integer.parseInt(line[0]), Integer.parseInt(line[1]), line[2]);
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < this.nodos.length ; i++)
			if(this.nodos[i].id > max)
				max = this.nodos[i].id;
	
		Node[] n = new Node[max + 1];
		for(Node node : this.nodos)
			n[node.id] = node;
		
		for(int i = 0; i < Q ; i++)		
		{
			String lne = br.readLine();
			if(this.mirrorTo(Integer.parseInt(lne), n) == null)
				System.out.println("NULL");
			else
				bw.write(this.mirrorTo(Integer.parseInt(lne), n).value + "\n");
		}
		br.close();
		bw.flush();
	}
	
	public static void main(String[] agrs) throws IOException
	{
		BTree tree = new BTree();
		tree.solveMirror();
	}
	
}
