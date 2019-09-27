import java.util.Scanner;
public class QueueViaStack {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Queue q1 = new Queue();
		int n = Integer.parseInt(scan.nextLine());
		int counter = 0;
		String cm;
		while(counter<n){
			cm = scan.nextLine();
			if(cm.startsWith("INSERT")){
				int g = Integer.parseInt(cm.substring(cm.indexOf(' ')+1));
				q1.insert(g);
			}
			else{
				if(!q1.isEmpty()) 
					q1.dequeue();
			}
			counter++;
		}
		System.out.println(q1.dequeue());	
	}
}
class Node{
	public Node next;
	public int data;
	
	public Node() {}
	public Node(int data){
		this.data = data;
	}
}
class Stack{
	public Node head=null;
	
	public Stack() {}
	
	public boolean isEmpty() {
		return head==null;
	}
	public void push(int n) {
		Node newNode = new Node(n);
		if(this.isEmpty()) {
			head = newNode;
		}
		else {
			newNode.next = head;
			head = newNode;
		}
	}
	public int pop() {
		if(this.isEmpty()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		else {
			Node oldhead = head;
			head = head.next;
			return oldhead.data;
		}
	}
	public int peek() {
		return head.data;
	}
}

class Queue{
	public Stack main;
	public Stack temp;
	
	public Queue() {
		main = new Stack();
		temp = new Stack();
	}
	public boolean isEmpty() {
		return main==null;
	}
	public void insert(int n) {
		main.push(n);
	}
	public int dequeue() {
		if(main.isEmpty()) {
			return Integer.MIN_VALUE;
		}
		else {
			Node current = main.head;
			while(current.next != null) {
				temp.push(main.pop());
				current = current.next;
			}
			int n = main.pop();
			current = temp.head;
			while(current!=null) {
				main.push(temp.pop());
				current = current.next;
			}
			return n;
		}
	}
}
