package co.edu.udea.dispositivos.exception;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
* Manejo de excepciones relacionadas a la ejecuci�n de la l�gica de negocio de pr�stamos
* @author lenovo
*
*/
public class ExcepcionPrestamo extends Exception{
	private static final long serialVersionUID = 1L;//A�adido autom�ticamente por Eclipse
	private static final Logger logger = Logger.getLogger(Exception.class.getName());

	/*
	 *@param message el mensaje que se mostrar� en la excepci�n
	 *@param cause la causa de la excepci�n representada por un booleano 
	 */
	public ExcepcionPrestamo(String message, Throwable cause){
		super(message, cause);
		guardarExcepcionesLog4j();
	}
	
	/**
	 * Escribe el log de la excepci�n en el archivo generado por log4j 
	 **/
	private void guardarExcepcionesLog4j(){
		//PropertyConfigurator.configure("/src/log4j.properties");
		logger.error("Se ha producido un error en el pr�stamo [log4j]:  "+getMessage());		
	}

	/*
	 *
	 *@param cause la causa de la excepci�n representada por un booleano 
	 */
	public ExcepcionPrestamo(Throwable cause){
		super(cause);
		logger.error(cause.getMessage());
	}

	@Override
	public void printStackTrace() {
		System.out.println("Error pr�stamo: "+ getMessage());
	}
}

