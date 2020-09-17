package TDALista;
/**
 *Clase que modela la exepción de una posición inválida.
 * @author Stefano Pitto | Gustavo Alaniz
 */
@SuppressWarnings("serial")
public class InvalidPositionException extends Exception {
	/**
	 * 
	 * @param msg Error, que proviene del origen de la excepción.
	 */
	public InvalidPositionException(String msg){
		super(msg);
	}

}
