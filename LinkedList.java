
public class LinkedList 
{
	Node head;
	
	public LinkedList()
	{
		head = null;
	}
	public void insertHead(int data)
	{
		if(head == null)
		{
			head = new Node(data);
		}
		else
		{
			Node newHead = new Node(data);
			newHead.next = head;
			head = newHead;

		}
	}
	public int deleteHead()
	{
		if(head == null)
		{
			System.out.println("List is empty");
			throw new NullPointerException();
		}
		
		else
		{
			int n = head.data;				//Store the integer data at the head to later return
			head.data = head.next.data;		//Overwrite the head's current data with our new data from our new head which is the item previous to head
			head = head.next;					//Make the name "head" refer to the node with 
			return n;
			
		}
	}
	public boolean isEmpty()
	{
		return head == null;
	}
	
	

}
class Node 
{
	int data;
	Node next;
	
	public Node(int data){
		this.data = data;
	}
}
