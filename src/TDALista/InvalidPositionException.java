package TDALista;
/**
 *Clase que modela la exepci�n de una posici�n inv�lida.
 * @author Stefano Pitto | Gustavo Alaniz
 */
@SuppressWarnings("serial")
public class InvalidPositionException extends Exception {
	/**
	 * 
	 * @param msg Error, que proviene del origen de la excepci�n.
	 */
	public InvalidPositionException(String msg){
		super(msg);
	}

}
