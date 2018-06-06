package How_to_Train_Your_Dragon;

public class Node {
	
	public int trainigDays;
	public int multa;
	public int sleepDays;
	public Node next;
	
	public Node(int Days, int multa)
	{
		this.multa = multa;
		this.trainigDays = Days;
		this.sleepDays = 0;
	}
	
	public void setSleepDays()
	{
		this.sleepDays++;
	}
	
	public void setTrainigDays()
	{
		this.trainigDays--;
	}
	
	public int calcularMulta()
	{
		return this.sleepDays * this.multa;
	}
	
	public double prioridad()
	{
		return 10000000 * this.trainigDays / this.multa;
	}
	
	public Node Clone()
	{
		Node Clone = new Node(this.trainigDays, this.multa);
		Clone.sleepDays = this.sleepDays;
		return Clone;
	}
}
