package co.edu.udea.dispositivos.dao;

import java.util.List;

import co.edu.udea.dispositivos.dto.Prestamo;
import co.edu.udea.dispositivos.exception.ExcepcionPrestamo;

/**
 * Permite acceder a los datos de un préstamo
 * @author lenovo
 *
 */
public interface PrestamoDao {

	/**
	 * 
	 * @param prestamo indica el prestamo a guardar 
	 * @throws ExcepcionPrestamo
	 */
	public void registrar(Prestamo prestamo) throws ExcepcionPrestamo;
	
	/**
	 * 
	 * @param prestamo indica el prestamo que será modificado
	 * @throws ExcepcionPrestamo
	 */
	public void actualizar(Prestamo prestamo) throws ExcepcionPrestamo;
	
	/**
	 * 
	 * @param id indica la id del prestamo que se desea eliminar
	 * @throws ExcepcionPrestamo
	 */
	public void eliminar(Long id) throws ExcepcionPrestamo;
	
	/***
	 * 
	 * @return una lista con todos los prestamos registrados
	 * @throws ExcepcionPrestamo
	 */
	public List<Prestamo> listar() throws ExcepcionPrestamo;
	
	/**
	 * 
	 * @param id indica la id del prestamo que se desea obtener
	 * @return un prestamo cuya id coincide con la id ingresada como parámetro
	 * @throws ExcepcionPrestamo
	 */
	public Prestamo listar(Long id) throws ExcepcionPrestamo;
	
	/**
	 * 
	 * @return una lista con todos los prestamos sin procesar
	 * @throws ExcepcionPrestamo
	 */
	public List<Prestamo> listarPrestamosSinProcesar() throws ExcepcionPrestamo;
}
