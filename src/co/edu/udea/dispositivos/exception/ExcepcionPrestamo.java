package co.edu.udea.dispositivos.exception;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
* Manejo de excepciones relacionadas a la ejecución de la lógica de negocio de préstamos
* @author lenovo
*
*/
public class ExcepcionPrestamo extends Exception{
	private static final long serialVersionUID = 1L;//Añadido automáticamente por Eclipse
	private static final Logger logger = Logger.getLogger(Exception.class.getName());

	/*
	 *@param message el mensaje que se mostrará en la excepción
	 *@param cause la causa de la excepción representada por un booleano 
	 */
	public ExcepcionPrestamo(String message, Throwable cause){
		super(message, cause);
		guardarExcepcionesLog4j();
	}
	
	/**
	 * Escribe el log de la excepción en el archivo generado por log4j 
	 **/
	private void guardarExcepcionesLog4j(){
		//PropertyConfigurator.configure("/src/log4j.properties");
		logger.error("Se ha producido un error en el préstamo [log4j]:  "+getMessage());		
	}

	/*
	 *
	 *@param cause la causa de la excepción representada por un booleano 
	 */
	public ExcepcionPrestamo(Throwable cause){
		super(cause);
		logger.error(cause.getMessage());
	}

	@Override
	public void printStackTrace() {
		System.out.println("Error préstamo: "+ getMessage());
	}
}

