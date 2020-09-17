package TDALista;

import java.util.Iterator;

/**
 * Clase que modela una lista Doblemente Enlazada.
 * @author Stefano Pitto | Gustavo Alaniz
 * @param <E> Tipo del elemento de la lista.
 */
public class DoubleLinkedList<E> implements PositionList<E> {

	protected Nodo<E> head;
	protected Nodo<E> last;
	protected int tamaño;
	/**
	 * Constructor de la lista, el cual inicializa los atributos.
	 */
	public DoubleLinkedList() {
		head=new Nodo<E>(null,null,null);
		last=new Nodo<E>(null,head,null);
		head.setSiguiente(last);
		tamaño=0;
	}
	/**
	 * Checkea la validez de una posición.
	 * @param p Posición a checkear
	 * @return Devuelve un nodo de la posición pasada por parámetro.
	 */
	private Nodo<E> checkPosition( Position<E> p )throws InvalidPositionException{
		try {
			return (Nodo<E>) p;
			} catch( ClassCastException e ) {
				throw new InvalidPositionException("Error, posición inválida.");
			}
	}
	
	public Iterator<E> iterator() {
		
		return new ElementIterator<E>(this );
		
	}

	
	public int size() {
		
		return tamaño;
	}

	@Override
	public boolean isEmpty() {
		if(tamaño==0)
			return true;
		else return false;
	}

	
	public Position<E> first() throws EmptyListException {
		if(size()==0) {
			throw new EmptyListException("error, lista vacía");
		}
		return head.getSiguiente();
	}

	
	public Position<E> last() throws EmptyListException {
		if(size()==0) {
			throw new EmptyListException("error, lista vacía");
		}
		return last.getAnterior();
	}
	

	
	public Position<E> prev(Position<E> p) throws BoundaryViolationException, InvalidPositionException {
		Nodo<E> aux= null;		
		if(p==null) {
			throw new InvalidPositionException("Error, posición nula.");
		}
		Nodo<E>pos=checkPosition(p);
		if(pos.getAnterior().element()==null) {
			throw new BoundaryViolationException("error, posición invalida.");
		}
		else { aux= pos.getAnterior();}
		return aux;
	}

	
	public Position<E> next(Position<E> p) throws BoundaryViolationException, InvalidPositionException {
      Nodo<E> aux= null;
      if(p==null) {
			throw new InvalidPositionException("Error, posición nula.");
		}
      Nodo<E>pos=this.checkPosition(p);
		if(pos.getSiguiente().element()==null) {
			throw new BoundaryViolationException("error, posición invalida.");
		}
		else { aux=(Nodo<E>) pos.getSiguiente();}
		return aux;
	}

	public void addFirst(E e) {
		Nodo<E> nuevo=new Nodo<E>(head.getSiguiente(),head,e);
		head.getSiguiente().setAnterior(nuevo);
		head.setSiguiente(nuevo);
		tamaño++;		
	}

	
	public void addLast(E e) {
		Nodo<E> nuevo=new Nodo<E>(last,last.getAnterior(),e);
		last.getAnterior().setSiguiente(nuevo);
		last.setAnterior(nuevo);
		tamaño++;
			
	}

	
	public void addBefore(Position<E> p, E e) throws InvalidPositionException {
		if(p==null||tamaño==0) {
			throw new InvalidPositionException("Error, posición nula.");
		}
		Nodo<E>pos=this.checkPosition(p);
		Nodo<E> nuevo= new Nodo<E>(pos,pos.getAnterior(),e);
		pos.setAnterior(nuevo);
		nuevo.getAnterior().setSiguiente(nuevo);
		tamaño++;
		}
		
		
	



	public void addAfter(Position<E> p, E element) throws InvalidPositionException {
			if(p==null) {
				throw new InvalidPositionException("Error, posición nula.");
			}
			Nodo<E>pos=this.checkPosition(p);
			Nodo<E> nuevo=new Nodo<E>(pos.getSiguiente(),pos,element);
			nuevo.getAnterior().setSiguiente(nuevo);
			nuevo.getSiguiente().setAnterior(nuevo);
			tamaño++;	
			   
		   }
		   

	
	public E remove(Position<E> p) throws InvalidPositionException {
		if(p==null) {
			throw new InvalidPositionException("Error, posición nula.");
		}
		if(this.tamaño==0) {
			throw new InvalidPositionException("Error, lista vacía.");
		}
		Nodo<E>pos=this.checkPosition(p);
		E elemento=pos.element();
		pos.getSiguiente().setAnterior(pos.getAnterior());
		pos.getAnterior().setSiguiente(pos.getSiguiente());
		pos.setAnterior(null);
		pos.setSiguiente(null);	
		tamaño--;
		return elemento;
	}

	
	public E set(Position<E> p, E e) throws InvalidPositionException {
		if(p==null||tamaño==0) {
			throw new InvalidPositionException("Error, posición nula.");
		}
		E elemento=null;
		Nodo<E>pos=this.checkPosition(p);
		if(pos.element()!=null) {
			elemento=pos.element();
			pos.setElement(e);
		}	
		return elemento;
	}


	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> l= new DoubleLinkedList<Position<E>>();
		if(tamaño==0) {
			return l;
		}
		Nodo<E> p=head.getSiguiente();
		while(p.element()!=null) {
			l.addLast(p);
			p=p.getSiguiente();
		}
		return l ;
	}
}
