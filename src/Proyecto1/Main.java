package Proyecto1;

public class Main {

	public static void main(String[] args) {
		
		Graph g = new Graph();
		
		g.addNode(1);
		g.addNode(2);
		g.addNode(2);
		g.addNode(3);
		g.addNode(-1);
		g.addEdge(1,2);
		g.addEdge(2,1);
		g.addEdge(2,3);
		g.removeNode(1);
		g.removeNode(1);
		g.removeEdge(2,3);
		
		g.addNode(6);
		g.addNode(7);
		g.removeNode(7);
		g.addEdge(6,7);
	}

}
