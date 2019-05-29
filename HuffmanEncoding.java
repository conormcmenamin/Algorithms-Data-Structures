package Solutions;

import java.util.*;

public class HuffmanEncoding {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        String sentence = in .nextLine();

        int[] array = new int[256]; //an array to store all the frequencies

        for (int i = 0; i < sentence.length(); i++) { //go through the sentence
            array[(int) sentence.charAt(i)]++; //increment the appropriate frequencies
        }

        PriorityQueue < Tree > PQ = new PriorityQueue < Tree > (); //make a priority queue to hold the group of trees    

        for (int i = 0; i < array.length; i++) { //go through frequency array
            if (array[i] > 0) { //print out non-zero frequencies - cast to a char
               
            	Node current = new Node();
            	current.letter = (char)i;
            	current.smallestLetter = (char)i;
            	Tree tree = new Tree();
            	tree.root = current;
            	tree.frequency = array[i];
            	PQ.add(tree);

            }
        }

        while (PQ.size() > 1) { //while there are two or more Trees left in the queue
        	Tree left = PQ.poll();
        	Tree right = PQ.poll();
        	Tree tree = new Tree();
        	Node current = new Node();
        	current.leftChild = left.root;
        	current.rightChild = right.root;
        	tree.frequency = left.frequency + right.frequency;
        	tree.root = current;
        	PQ.add(tree);
        }

        Tree HuffmanTree = PQ.poll(); //now there's only one tree left - get its codes
        double r = 0.0;
        String s = "";
        for(int i = 0; i<=sentence.length()-1;i++){
        	s+=HuffmanTree.getCode(sentence.charAt(i));
        	
        	
        }
        System.out.println(s);
   
        
    }
}

class Node {


    public char letter = '@'; //stores letter
    public char smallestLetter = '@'; 
				
    public Node leftChild; // this node's left child
    public Node rightChild; // this node's right child


} // end class Node





class Tree implements Comparable < Tree > {
    public Node root; // first node of tree
    public int frequency = 0;

    public Tree() // constructor
    {
        root = null;
    } // no nodes in tree yet

    

    public int compareTo(Tree object) {
        if (frequency - object.frequency > 0) { //compare the cumulative frequencies of the tree
            return 1;
        } else if (frequency - object.frequency < 0) {
            return -1; //return 1 or -1 depending on whether these frequencies are bigger or smaller
        } else {
            // Sort based on letters
            char a = this.root.smallestLetter;
            char b = object.root.smallestLetter;

            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
            return 0;
        }
    }

    String path = "error"; 
    public String getCode(char letter) { 

        return this._getCode(letter, this.root, ""); //return the path that results
    }

    private String _getCode(char letter, Node current, String path) {
        if (current == null) {
            return null;
        }
        if (current.letter == letter) {
            return path;
        }

        String leftPath = this._getCode(letter, current.leftChild, path + "0");
        if (leftPath != null) {
            return leftPath;
        }

        String rightPath = this._getCode(letter, current.rightChild, path + "1");
        return rightPath;
    }

}
