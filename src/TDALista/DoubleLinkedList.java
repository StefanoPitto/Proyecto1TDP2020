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
	protected int tama�o;
	/**
	 * Constructor de la lista, el cual inicializa los atributos.
	 */
	public DoubleLinkedList() {
		head=new Nodo<E>(null,null,null);
		last=new Nodo<E>(null,head,null);
		head.setSiguiente(last);
		tama�o=0;
	}
	/**
	 * Checkea la validez de una posici�n.
	 * @param p Posici�n a checkear
	 * @return Devuelve un nodo de la posici�n pasada por par�metro.
	 */
	private Nodo<E> checkPosition( Position<E> p )throws InvalidPositionException{
		try {
			return (Nodo<E>) p;
			} catch( ClassCastException e ) {
				throw new InvalidPositionException("Error, posici�n inv�lida.");
			}
	}
	
	public Iterator<E> iterator() {
		
		return new ElementIterator<E>(this );
		
	}

	
	public int size() {
		
		return tama�o;
	}

	@Override
	public boolean isEmpty() {
		if(tama�o==0)
			return true;
		else return false;
	}

	
	public Position<E> first() throws EmptyListException {
		if(size()==0) {
			throw new EmptyListException("error, lista vac�a");
		}
		return head.getSiguiente();
	}

	
	public Position<E> last() throws EmptyListException {
		if(size()==0) {
			throw new EmptyListException("error, lista vac�a");
		}
		return last.getAnterior();
	}
	

	
	public Position<E> prev(Position<E> p) throws BoundaryViolationException, InvalidPositionException {
		Nodo<E> aux= null;		
		if(p==null) {
			throw new InvalidPositionException("Error, posici�n nula.");
		}
		Nodo<E>pos=checkPosition(p);
		if(pos.getAnterior().element()==null) {
			throw new BoundaryViolationException("error, posici�n invalida.");
		}
		else { aux= pos.getAnterior();}
		return aux;
	}

	
	public Position<E> next(Position<E> p) throws BoundaryViolationException, InvalidPositionException {
      Nodo<E> aux= null;
      if(p==null) {
			throw new InvalidPositionException("Error, posici�n nula.");
		}
      Nodo<E>pos=this.checkPosition(p);
		if(pos.getSiguiente().element()==null) {
			throw new BoundaryViolationException("error, posici�n invalida.");
		}
		else { aux=(Nodo<E>) pos.getSiguiente();}
		return aux;
	}

	public void addFirst(E e) {
		Nodo<E> nuevo=new Nodo<E>(head.getSiguiente(),head,e);
		head.getSiguiente().setAnterior(nuevo);
		head.setSiguiente(nuevo);
		tama�o++;		
	}

	
	public void addLast(E e) {
		Nodo<E> nuevo=new Nodo<E>(last,last.getAnterior(),e);
		last.getAnterior().setSiguiente(nuevo);
		last.setAnterior(nuevo);
		tama�o++;
			
	}

	
	public void addBefore(Position<E> p, E e) throws InvalidPositionException {
		if(p==null||tama�o==0) {
			throw new InvalidPositionException("Error, posici�n nula.");
		}
		Nodo<E>pos=this.checkPosition(p);
		Nodo<E> nuevo= new Nodo<E>(pos,pos.getAnterior(),e);
		pos.setAnterior(nuevo);
		nuevo.getAnterior().setSiguiente(nuevo);
		tama�o++;
		}
		
		
	



	public void addAfter(Position<E> p, E element) throws InvalidPositionException {
			if(p==null) {
				throw new InvalidPositionException("Error, posici�n nula.");
			}
			Nodo<E>pos=this.checkPosition(p);
			Nodo<E> nuevo=new Nodo<E>(pos.getSiguiente(),pos,element);
			nuevo.getAnterior().setSiguiente(nuevo);
			nuevo.getSiguiente().setAnterior(nuevo);
			tama�o++;	
			   
		   }
		   

	
	public E remove(Position<E> p) throws InvalidPositionException {
		if(p==null) {
			throw new InvalidPositionException("Error, posici�n nula.");
		}
		if(this.tama�o==0) {
			throw new InvalidPositionException("Error, lista vac�a.");
		}
		Nodo<E>pos=this.checkPosition(p);
		E elemento=pos.element();
		pos.getSiguiente().setAnterior(pos.getAnterior());
		pos.getAnterior().setSiguiente(pos.getSiguiente());
		pos.setAnterior(null);
		pos.setSiguiente(null);	
		tama�o--;
		return elemento;
	}

	
	public E set(Position<E> p, E e) throws InvalidPositionException {
		if(p==null||tama�o==0) {
			throw new InvalidPositionException("Error, posici�n nula.");
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
		if(tama�o==0) {
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
