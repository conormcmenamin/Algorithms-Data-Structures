//This was a simple exercise to find an O(1) solution to finding the minimum value on a stack. 
//The regular O(n) method is to have an instance method that, when called, creates a new temporary 
//stack to pop everything off the "main" stack onto this one and tracking the minimum value you observe
//as this is being done, then returning everything back to the main stack again and returning the smallest value observed.
//This approach is both time and memory inefficient (O(n) spatial and time complexity).

//A much more efficient approach is to have a stack that has two attributes, a head node and a stack that tracks the 
//minimum value at any point, a "minStack". It does this by making the initial value added to the stack, the minimum 
//(because the minimum value of a list of 1 number is simply that number) and as values are added, we check if they 
//are less than or equal to the head of the minStack, if they are, we push that value onto the minStack as this is our 
//new minimum. The reason you check if the value is equal to the current minimum is because we can always push two nodes 
//with the same minimum value on the main stack, in which case we want to have two copies of this on our minStack also for 
//popping this off later on. If we pop off the minimum value on the stack then we pop this off our minStack, as it is no 
//longer our minimum. This method allows us to return the minimum value on the main stack at any point with O(1) efficiency
//and O(n) spatial complexity (in the worst case).

//Note: This program takes n instructions, each on a new line from stdin in the form of a command followed by a value 
//e.g. "PUSH 7" or "POP".

Input:
7
PUSH 7
PUSH 23
PUSH -1
POP
PUSH -4
PUSH 10
POP

Output:
-4

import java.util.Scanner;

public class Lab {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		
		
		Stack s = new Stack();
		String cmd;
		int n = Integer.parseInt(scan.nextLine());
		for(int i = 0; i< n; i++){
			cmd = scan.nextLine();
			if(cmd.startsWith("PUSH")){
				s.push(Integer.parseInt(cmd.substring(cmd.indexOf(" ") +1)));
			}
			else{
				s.pop();
			}
		}
		
		if(s.isEmpty()){
			System.out.println("empty");
		}
		else{
			System.out.println(s.min());
		}
			
	}

}
public class Stack {
	private Link head;
	private Stack2 minStack;
	public Stack(){
		minStack = new Stack2();
	}
	
	public void push(int n){
		Link newLink = new Link(n);
		if(head == null){
			head = newLink;
			minStack.push(n);
		}
		else{
			Link prev = head; 			//Store the head object as the previous
			head = newLink; 			//make the head be a new link with the value n
			head.next = prev; 			//Make head.next refer to the previous head
			if(newLink.data <= minStack.peek()) {
				minStack.push(newLink.data);
			}
		}
		
		
	}
	public int pop(){
		if(head == null){
			return Integer.MIN_VALUE;
		}
		else{
			Link tempLink = head;
			head = head.next;
			if(tempLink.data == minStack.peek()) {
				minStack.pop();
			}
			return(tempLink.data);
		}
	}
	public int peek(){
			return(head.data);
	}
	public boolean isEmpty(){
		return (head == null);
	}
	public int min() {
		return (minStack.peek());
	}
}
class Link{
	public int data;
	public Link next;
	
	public Link(int data){
		this.data = data;	
	}
	public Link() {}
}
class Stack2{
	
	public Link head = new Link();
	
	public Stack2() {}
	public boolean isEmpty() {
		return head==null;
	}
  
	public void push(int n) {
		Link newLink = new Link(n);
		if(isEmpty()) {
			head = new Link(n);
		}
		else{
			newLink.next = head;
			head = newLink;
		}
	}
	
	public int pop() {
		if(isEmpty()){
			return Integer.MIN_VALUE;
		}
		else{
			Link s = head;
			head = head.next;
			return s.data;
		}
	}
	public int peek(){
		if(isEmpty()){
			return Integer.MIN_VALUE;
		}
		else{
			return head.data;
		}
	}
}
