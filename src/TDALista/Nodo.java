package TDALista;

import TDALista.Position;
/**
 *Clase que modela un nodo.
 * @author Stefano Pitto | Gustavo Alaniz
 * @param <E> Tipo del elemento del nodo.
 */
public class Nodo<E> implements Position<E> {

	private E elemento; //Elemento del nodo.
	private Nodo<E> siguiente; // Siguiente del nodo.
	private Nodo<E> anterior; // Anterior del nodo.
	/**
	 * 
	 * @param elem Elemento del nodo.
	 */
	public Nodo(E elem) {
		elemento=elem;
		siguiente=null;
	}
	/**
	 * Constructor de la clase nodo, el cual inicializa los atributos.
	 * @param elem Elemento del nodo.
	 * @param s Nodo que representa el siguiente de este.
	 */
	public Nodo(Nodo<E> s, Nodo<E> a,E elem) {
		elemento=elem;
		siguiente=s;
		anterior=a;
	}
	
	@Override
	public E element() {
			return elemento;
	}

	/**
	 *Setea el elemento del nodo
	 * @param elem Elemento del nodo.
	 */
	public void setElement(E elem) {
		elemento=elem;

	}
	/**
	 * Setea el siguiente del nodo.
	 * @param s Nodo el cual representa el siguiente de este.
	 */
	public void setSiguiente(Nodo<E> s) {
		siguiente=s;
	}
	/**
	 * 
	 * @return retorna el siguiente del nodo.
	 */
	public Nodo<E> getSiguiente(){
		return siguiente;
	}
	/**
	 * Setea el anterior al nodo.
	 * @param a anterior al nodo.
	 */
	public void setAnterior(Nodo<E> a) {
		anterior=a;
	}
	/**
	 * 
	 * @return retorna el anterior del nodo.
	 */
	public Nodo<E> getAnterior(){
		return anterior;
	}
	
}
