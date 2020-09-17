package TDALista;

public interface PositionList<E> extends Iterable<E> {
	
	/**
	 * 
	 * @return Retorna el entero que representa el tamaño de la lista.
	 */
	public int size();
	/**
	 * 
	 * @return Devuelve verdadero si la lista está vacía, falso en caso contrario.
	 */
	public boolean isEmpty();
	/**
	 * 
	 * @return Devuelve la primerea posición de la lista.
	 * @throws EmptyListException Lanza excepción en caso de que la lista no tenga elementos.
	 */
	public Position<E> first()throws EmptyListException;
	/**
	 * 
	 * @return Devuelve la última posición de la lista.
	 * @throws EmptyListException Lanza excepción si la lista está vacía.
	 */
	public Position<E> last()throws EmptyListException;
	/**
	 * 
	 * @param p Posición siguiente a la que se quiere obtener.
	 * @return Devuelve la posición previa a la pasada por parámetro.
	 * @throws BoundaryViolationException Lanza excepción en caso de que se solicite el previo de la primera posición.
	 * @throws InvalidPositionException Lanza excepción si la posición es inválida.
	 */
	public Position<E> prev(Position<E> p)throws BoundaryViolationException, InvalidPositionException;
	/**
	 * 
	 * @param p Posición anterior a la que se quiere obtener. 
	 * @return Devuelve la posición siguiente a la pasada por parámetro.
	 * @throws BoundaryViolationException Lanza excepción si se solicita el siguiente de la última posición.
	 * @throws InvalidPositionException Lanza excepción si la posición pasada por parámetro es inválida.
	 */
	public Position<E>  next(Position<E> p)throws  BoundaryViolationException,InvalidPositionException;
	/**
	 * 
	 * @param e Elemento que se añade al principio de la lista.
	 */
	public void addFirst(E e);
	/**
	 * 
	 * @param e Elemento que se añade al final de la lista.
	 */
	public void addLast(E e);
	/**
	 * 
	 * @param p Representa la posición siguiente a la nueva posición a agregar.
	 * @param e Elemento de la posición nueva.
	 * @throws InvalidPositionException Lanza excepción si la posición es inválida.
	 */
	public void addBefore(Position<E> p, E e)throws  InvalidPositionException;
	/**
	 * 
	 * @param p Posición a la que se agregará como siguiente el elemento pasado por parámetro.
	 * @param e Elemento de la posición a agregar.
	 * @throws InvalidPositionException Lanza excepción en caso de que la posición se inválida.
	 */
	public void addAfter(Position<E> p, E e)throws  InvalidPositionException;
	/**
	 * 
	 * @param p Posición que se desea eliminar de la lista.
	 * @return Devuelve el elemento de la posición que se eliminó de la lista.
	 * @throws InvalidPositionException Lanza Excepción en caso de que la posición sea inválida.
	 */
	public E remove(Position<E> p)throws  InvalidPositionException;
	/**
	 * 
	 * @param p Posición en la que se insertará el nuevo elemento.
	 * @param e Elemento que se insertará en la posición pasada por parámetro.
	 * @return Devuelve el elemento que estaba antes en la posición.
	 * @throws InvalidPositionException Lanza excepción si la posición pasada por parámetro en inválida.
	 */
	public E set(Position<E> p,E e)throws  InvalidPositionException;
	/**
	 * 
	 * @return devuelve un iterable de las posiciones de la lista.
	 */
	public Iterable<Position<E>> positions();
	
	
	

}
