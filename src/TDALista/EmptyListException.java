package TDALista;
/**
 *Clase que modela la exepci�n de una lista vac�a. 
 * @author Stefano Pitto | Gustavo Alaniz
 */
@SuppressWarnings("serial")
public class EmptyListException extends Exception {
	/**
	 * 
	 * @param msg Error, que proviene del origen de la excepci�n.
	 */
	public EmptyListException(String msg) {
		super(msg);
	}
}
