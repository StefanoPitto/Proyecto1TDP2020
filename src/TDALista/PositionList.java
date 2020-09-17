package TDALista;

public interface PositionList<E> extends Iterable<E> {
	
	/**
	 * 
	 * @return Retorna el entero que representa el tama�o de la lista.
	 */
	public int size();
	/**
	 * 
	 * @return Devuelve verdadero si la lista est� vac�a, falso en caso contrario.
	 */
	public boolean isEmpty();
	/**
	 * 
	 * @return Devuelve la primerea posici�n de la lista.
	 * @throws EmptyListException Lanza excepci�n en caso de que la lista no tenga elementos.
	 */
	public Position<E> first()throws EmptyListException;
	/**
	 * 
	 * @return Devuelve la �ltima posici�n de la lista.
	 * @throws EmptyListException Lanza excepci�n si la lista est� vac�a.
	 */
	public Position<E> last()throws EmptyListException;
	/**
	 * 
	 * @param p Posici�n siguiente a la que se quiere obtener.
	 * @return Devuelve la posici�n previa a la pasada por par�metro.
	 * @throws BoundaryViolationException Lanza excepci�n en caso de que se solicite el previo de la primera posici�n.
	 * @throws InvalidPositionException Lanza excepci�n si la posici�n es inv�lida.
	 */
	public Position<E> prev(Position<E> p)throws BoundaryViolationException, InvalidPositionException;
	/**
	 * 
	 * @param p Posici�n anterior a la que se quiere obtener. 
	 * @return Devuelve la posici�n siguiente a la pasada por par�metro.
	 * @throws BoundaryViolationException Lanza excepci�n si se solicita el siguiente de la �ltima posici�n.
	 * @throws InvalidPositionException Lanza excepci�n si la posici�n pasada por par�metro es inv�lida.
	 */
	public Position<E>  next(Position<E> p)throws  BoundaryViolationException,InvalidPositionException;
	/**
	 * 
	 * @param e Elemento que se a�ade al principio de la lista.
	 */
	public void addFirst(E e);
	/**
	 * 
	 * @param e Elemento que se a�ade al final de la lista.
	 */
	public void addLast(E e);
	/**
	 * 
	 * @param p Representa la posici�n siguiente a la nueva posici�n a agregar.
	 * @param e Elemento de la posici�n nueva.
	 * @throws InvalidPositionException Lanza excepci�n si la posici�n es inv�lida.
	 */
	public void addBefore(Position<E> p, E e)throws  InvalidPositionException;
	/**
	 * 
	 * @param p Posici�n a la que se agregar� como siguiente el elemento pasado por par�metro.
	 * @param e Elemento de la posici�n a agregar.
	 * @throws InvalidPositionException Lanza excepci�n en caso de que la posici�n se inv�lida.
	 */
	public void addAfter(Position<E> p, E e)throws  InvalidPositionException;
	/**
	 * 
	 * @param p Posici�n que se desea eliminar de la lista.
	 * @return Devuelve el elemento de la posici�n que se elimin� de la lista.
	 * @throws InvalidPositionException Lanza Excepci�n en caso de que la posici�n sea inv�lida.
	 */
	public E remove(Position<E> p)throws  InvalidPositionException;
	/**
	 * 
	 * @param p Posici�n en la que se insertar� el nuevo elemento.
	 * @param e Elemento que se insertar� en la posici�n pasada por par�metro.
	 * @return Devuelve el elemento que estaba antes en la posici�n.
	 * @throws InvalidPositionException Lanza excepci�n si la posici�n pasada por par�metro en inv�lida.
	 */
	public E set(Position<E> p,E e)throws  InvalidPositionException;
	/**
	 * 
	 * @return devuelve un iterable de las posiciones de la lista.
	 */
	public Iterable<Position<E>> positions();
	
	
	

}
