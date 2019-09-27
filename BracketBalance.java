import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BracketBalance {

	
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
    	String s = scanner.nextLine();
    	System.out.println(isBalanced(s));
        scanner.close();
    }
 
 	static boolean isBalanced(String s) {
 		Stack stk = new Stack();
 		for (int i = 0; i <= s.length() - 1; i++) {

 			if (isLeft(s.charAt(i))) {
 				stk.push(s.charAt(i));
 			} else if (isRight(s.charAt(i))) {
 				if (stk.head == null) {
 					return false;
 				} else {
 					if (s.charAt(i) == '}') {
 						if (stk.head.data == '{') {
 							stk.pop();
 						} else {
 							return false;
 						}
 					} else if (s.charAt(i) == ']') {
 						if (stk.head.data == '[') {
 							stk.pop();
 						} else {
 							return false;
 						}
 					} else if (s.charAt(i) == ')') {
 						if (stk.head.data == '(') {
 							stk.pop();
 						} else {
 							return false;
 						}
 					}
 				}
 			}
 		}

         return (stk.isEmpty())? true:false;
         

     }
     static boolean isRight(char c){
         return(c == '}') || (c == ')') || (c == ']');
     }
     static boolean isLeft(char c){
         return (c == '{') || (c == '(') || (c == '[');
     }
}
class Node{
    public Node next;
    public char data;
    
    public Node() {}
    public Node(char data){
        this.data = data;
    }
}
class Stack{
    public Node head=null;
    
    public Stack() {}
    
    public boolean isEmpty() {
        return head==null;
    }
    public void push(char n) {
        Node newNode = new Node(n);
        if(this.isEmpty()) {
            head = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
    }
    public char pop() {
        if(this.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        else {
            Node oldhead = head;
            head = head.next;
            return oldhead.data;
        }
    }
    public char peek() {
        return head.data;
    }
}
