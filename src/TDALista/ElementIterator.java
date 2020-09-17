package TDALista;

import java.util.NoSuchElementException;
/**
 * Clase que modela un iterador.
 * @author Stefano Pitto | Gustavo Alaniz	
 * @param <E> Tipo del elemento de la estructura sobre la cual itera.
 */
public class ElementIterator<E> implements java.util.Iterator<E> {
	
	private PositionList<E> lista;
	
	private Position<E> cursor;
	/**
	 * Constructor del iterador, el cual se encarga de inicializar los atributos.
	 * @param l Lista sobre la cual iterará el iterador.
	 */
	public ElementIterator(PositionList<E> l) {
		lista=l;
		try {
			cursor= lista.first();
		} catch (EmptyListException e) {}
	}
	@Override
	public boolean hasNext() {
		return cursor!=null;		
	}

	@Override
	public E next()throws NoSuchElementException{
		if(cursor==null) {
			throw new NoSuchElementException("Error: no hay siguiente.");
		}
		E toReturn=cursor.element();
		try {
			cursor= cursor==lista.last()? null : lista.next(cursor);
		} catch (EmptyListException | BoundaryViolationException | InvalidPositionException e) {
		}
		return toReturn;
	}

}
