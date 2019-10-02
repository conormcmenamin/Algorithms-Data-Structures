import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class GraphAL {
	//Adjacency list
	private LinkedList<Integer> array[];
	private int V;								//number of vertices
	
	public GraphAL(int numVertices) {
		V=numVertices;
		array = new LinkedList[numVertices+1];
		
		for(int i  =0;i<=array.length-1;i++) {
			array[i] = new LinkedList();
		}
	}
	
	 public String BFS(int s) 
	    { 
	        String ans="";
	        boolean visited[] = new boolean[V+1]; 
	        LinkedList<Integer> queue = new LinkedList<Integer>(); 
	        visited[s]=true; 
	        queue.add(s); 
	  
	        while (queue.size() != 0) 
	        { 
	            
	            s = queue.poll(); 
	            ans+= s+" "; 
	  
	           
	            Iterator<Integer> i = array[s].listIterator(); 
	            while (i.hasNext()) 
	            { 
	                int n = i.next(); 
	                if (!visited[n]) 
	                { 
	                    visited[n] = true; 
	                    queue.add(n); 
	                } 
	            } 
	        }
	        return ans;
	    } 
	
	public String DFS(int v) {
		 return DFSUtil(v, new boolean[V+1]);
	}
	private String DFSUtil(int v, boolean visited[]) {
		visited[v]=true;
		
		Iterator<Integer> i = array[v].listIterator();
		
		while(i.hasNext()) {
			int newNode = i.next();
			
			if(!visited[newNode]) {
				 return v + "" + DFSUtil(newNode,visited);
			}
		}
		return v+"";
		
	}
	
	public void addEdge(int node1, int node2) {
		
		array[node1].add(node2);
		array[node2].add(node1);
	}
	
	
	
	
	
	public void printGraph() {
		System.out.println("===================================================");
		for(int i=1;i<=array.length-1;i++) {
			LinkedList<Integer> current= array[i];
			
			System.out.print(i + " ");
			
			Iterator <Integer> iterator = current.listIterator();
			while(iterator.hasNext()) {
				System.out.print("-> " + iterator.next());
			}
			System.out.println("");
		}
		System.out.println("===================================================");
	}
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		GraphAL graph = new GraphAL(6);
		
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(2, 4);
		graph.addEdge(5,6);
		graph.addEdge(4, 5);
		graph.printGraph();
		
		
		System.out.println(graph.DFS(1));
		System.out.println(graph.BFS(1));
	}

}
