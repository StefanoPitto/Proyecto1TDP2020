package Proyecto1;

import TDALista.BoundaryViolationException;
import TDALista.DoubleLinkedList;
import TDALista.EmptyListException;
import TDALista.InvalidPositionException;
import TDALista.Position;
import TDALista.PositionList;
import java.util.logging.*;
public class Graph{
	
	private PositionList<Edge> arcos;
	
	private PositionList<Node> nodos;
	
	private Logger logger;
	public Graph() {
		arcos= new DoubleLinkedList<Edge>();
		nodos= new DoubleLinkedList<Node>();
		
		Handler handler= new ConsoleHandler();
		handler.setLevel(Level.INFO);
		logger = Logger.getLogger(Graph.class.getName());
		logger.addHandler(handler);
		logger.setLevel(Level.INFO);
	}	
	
	
	public void addNode(int node) {
		if(node<0) {
			logger.warning("El nodo ingresado es nulo.");
		}else {
			if(!pertenece(node)) {
				Node nodo = new Node(node);
				nodos.addLast(nodo);
				logger.info("El nodo "+node+" fue agregado al grafo.");
			}else {
				logger.info("El nodo "+node+" ya pertenece al grafo.");
			}
		}
	}	
	
	public void addEdge(int node1,int node2){
		Position<Edge> arco=null;
		boolean encontre=false;
		if(pertenece(node1)&&pertenece(node2)) {
			if(!arcos.isEmpty()) {
				try {
					arco=arcos.first();
				} catch (EmptyListException e1) {}
				while(arco!=null&&!encontre) {
					if(arco.element().getNode1()==node1&& arco.element().getNode2()==node2) {
						encontre=true; 
					}else {
						try {
							arco= arco==arcos.last() ? null : arcos.next(arco);
						} catch (EmptyListException | BoundaryViolationException | InvalidPositionException e) {}
					}
				
				}
			}
			if(!encontre) {
				arcos.addLast(new Edge(node1,node2));
				logger.info("Se agregó el arco a los nodos "+node1+" y "+node2);
			}else {
				logger.info("El arco ya existía");
			}
		}else {
			logger.warning("Alguno de los nodos no pertenece al grafo.");
		}
	}	
	
	private boolean pertenece(int n) {
		Position<Node> nodo=null;
		if(!nodos.isEmpty()) {
			try {
				nodo=nodos.first();
			} catch (EmptyListException e1) {}
			while(nodo!=null) {
				if(nodo.element().getElement()==n) {
					return true;
				}else {
					try {
						nodo= nodo==nodos.last() ? null : nodos.next(nodo);
					} catch (EmptyListException | BoundaryViolationException | InvalidPositionException e) {}
				}
				
			}
		}
		return false;
	}
	
	public void removeNode(int node) {
		Position<Edge> arco=null;
		Position<Node> nodo=null;
		boolean elimine=false;
		if(!nodos.isEmpty()) {
			try {
				nodo=nodos.first();
			} catch (EmptyListException e1) {}
			while(nodo!=null) {
				if(nodo.element().getElement()==node) {
					try {
						nodos.remove(nodo);
						elimine=true;
						logger.info("El nodo "+node+" fue eliminado.");
					} catch (InvalidPositionException e) {}
					nodo=null;
				}else {
					try {
						nodo= nodo==nodos.last() ? null : nodos.next(nodo);
					} catch (EmptyListException | BoundaryViolationException | InvalidPositionException e) {}
				}
				
			}
		}
		if(!elimine) {
			logger.warning("Error, se está queriendo eliminar un nodo inexistente.");
		}
		
		if(!arcos.isEmpty()&&elimine) {
			try {
				arco=arcos.first();
			} catch (EmptyListException e) {}
			while(arco!=null) {
				if(arco.element().getNode1()==node||arco.element().getNode2()==node) {
					try {
						logger.info("Se eliminó el arco de los nodos "+arco.element().getNode1()+" "+arco.element().getNode2());
						arcos.remove(arco);
						arco=null;
					} catch (InvalidPositionException e) {}
				}else {
					try {
						arco= arco==arcos.last()? null : arcos.next(arco);
					} catch (EmptyListException | BoundaryViolationException | InvalidPositionException e) {}
				}
			}
		}
		
	}	
	
	public void removeEdge(int node1, int node2) {
		Position<Edge> arco=null;
		boolean elimine=true;
		if(pertenece(node1)&&pertenece(node2)) {
			if(!arcos.isEmpty()) {
				try {
					arco=arcos.first();
				} catch (EmptyListException e1) {}
				while(arco!=null&&!elimine) {
					if(arco.element().getNode1()==node1&&arco.element().getNode2()==node2) {
						try {
							arcos.remove(arco);
							logger.info("Se elimino el arco de los nodos "+arco.element().getNode1()+" "+arco.element().getNode2());
							elimine=true;
						} catch (InvalidPositionException e) {}
					}
				}
			}
			if(!elimine) {
				logger.warning("Se está queriendo eliminar un arco inexistente en el grafo.");
			}
			}else {
			logger.warning("Se está queriendo eliminar un arco el cual no tiene nodos existentes en el grafo.");
		}
	}
	
	
}
