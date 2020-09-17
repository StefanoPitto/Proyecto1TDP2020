package TDALista;
/**
 *Clase que modela una exepci�n en el caso de que los limites hayan sido sobrepasados. 
 * @author Stefano Pitto | Gustavo Alaniz
 *
 */
@SuppressWarnings("serial")
public class BoundaryViolationException extends Exception {
	/**
	 * 
	 * @param msg Error, que proviene del origen de la excepci�n.
	 */
	public BoundaryViolationException(String msg) {
		super(msg);
	}
}
