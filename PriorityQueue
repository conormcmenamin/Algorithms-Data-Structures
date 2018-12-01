package Lab_work;
/*Given an integer for the number of commands on the first line of input, with commands in the form("INSERT " + some string) or ("REMOVE") 
*on n new lines, write a program that will insert these strings into a priority queue and sort them such that the smallest-length strings 
*are at the front and if strings of the same length, they are sorted such that the String earliest in the dictionary, gets put 
*further to the front. If the queue is empty and the program is asked to remove simply do nothing. Print out the front pf the queue on a new line*/


public class Lab8
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();                                   //Take in our number of commands on the first line
		PriorityQueue PQ = new PriorityQueue();
		int counter = 0;
		String cm;
		while(counter<=n)                                         //Count up to m and each time:
		{
                       cm = scan.nextLine();                                  //Take in a new command
			if(cm.startsWith("INSERT"))                             //If it starts with the prefix "INSERT"
			{
				String g = cm.substring(cm.indexOf(' ')+1);           //Substring after the space to pull out the string to insert
				PQ.insertSorted(g);                                   //Insert that into the priority queue based on the question's criteria
			}
			else                                                    //If it didn't start with that prefix, assume it's a REMOVE command
			{
				if(!PQ.isEmpty())                                     //If our priority queue is not empty we can dequeue
				{
					PQ.dequeue();
				}                                                     //If it's not then we don't have to do anything
			}
			counter++;                                              //Update our conter after every command is taken
		}
		
		
		System.out.println(PQ.dequeue());                         //After everything is inserted and removed simply print out the front of the queue
		
		Node js = PQ.head;
		
		
		
		
	}


}

class Node
{
	public String data;
	public Node next;
	
	public Node(String s){
		this.data = s;
	}
	public Node() {
		
	}
}
class PriorityQueue 
{
	public Node head = null;                                            //Make head null so we can check if it's empty later on
	public Node tail;
	
	public PriorityQueue () {                                           //We don't really meed any parameters for our constructor
		
	}
	
	public void insertSorted(String s)
	{
		Node newNode = new Node(s);
		if(head == null) {
			head = newNode;                                                 //If our queue id empty to start, then make our head and tail refer to this first node
			tail = newNode;
		}
		else{
			Node current = head;                                            //Make our counter for the current node refer to head to start here
			Node prev = null;                                               //Make the previous to the head null as there is no previous to the head
			while(current != null && check(current.data, newNode.data)){    //While you're not at the end of the linked list and we must keep sorting
				prev = current;                                               //Set previous to the previous value of current
				current = current.next;                                       //Make current refer to the node next to current
			}
			
			if(prev == null){                                               //If previous is still null, we're still at the start of the linked list and the node we're trying to insert needs to be at the front of the queue
				newNode.next = head;                                          //Make our new node's nexg attribute refer to the head 
				head = newNode;                                               //Make head refer to our new node
			}
			else{                                                           //Otherwise if the node needs to be inserted in the middle or at the end, then
				prev.next = newNode;                                          //The node previous to the place we're inserting has to refer to our new node as it's next 
				newNode.next = current;                                       //Our new node's next must refer to the current node we are on (If it must be at the back of the queue, this will refer to null and the tail will refer to this new node)
			}
		}
	}
	public boolean check(String current, String newNode )               //Method to check if we need to keep sorting through the queue
	{
		if(newNode.length() > current.length())                           //If the length of newNode's string is greater than that of the current one we're looking at
		{
			return true;                                                    //Return true, i.e, we need to keep sorting as we want the smallest strings at the front of the queue
		}
		else if(newNode.length() == current.length())                     //Or if the lengths of these strings are the same
		{
			if(current.compareTo(newNode) <0)                               //And id the current is lexicographically further in the ascii table
			{
				return true;                                                  //Return true because we want the strings earliest in the dictionary to come first priority
			}
			else
			{
				return false;                                                 //Otherwise, return false as this is where we stop
			}
		}
		else                                                              //And in any other case: 
		{
			return false;                                                   //We don't have to sort, so we return false to catch all cases
		}
	}
	public String dequeue() {                                           //If we are dequeuing
		if(head==null) {                                                  //If the linked list is empty
			return null;                                                    //return a nulll value
		}else {                                                           //Otherwise
			Node prevHead = head;                                           //Store a reference to the head
			head = head.next;                                               //Make head refer to the next in the list
			return prevHead.data;                                           //Return the stored reference to out previous head's data
		}
	}
	public boolean isEmpty(){
		return(head == null);
	}
	
}
