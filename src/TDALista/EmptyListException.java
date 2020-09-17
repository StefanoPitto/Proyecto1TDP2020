package TDALista;
/**
 *Clase que modela la exepción de una lista vacía. 
 * @author Stefano Pitto | Gustavo Alaniz
 */
@SuppressWarnings("serial")
public class EmptyListException extends Exception {
	/**
	 * 
	 * @param msg Error, que proviene del origen de la excepción.
	 */
	public EmptyListException(String msg) {
		super(msg);
	}
}
