package co.edu.udea.dispositivos.dao;

import java.util.List;

import co.edu.udea.dispositivos.dto.Dispositivo;
import co.edu.udea.dispositivos.exception.ExcepcionPrestamo;

/**
 * Permite acceder a los datos de un dispositivo
 * @author lenovo
 *
 */
public interface DispositivoDao {

	/**
	 * 
	 * @param dispositivo indica el dispositivo a guardar 
	 * @throws ExcepcionPrestamo
	 */
	public void registrar(Dispositivo dispositivo) throws ExcepcionPrestamo;
	
	/**
	 * 
	 * @param dispositivo indica el dispositivo que será modificado
	 * @throws ExcepcionPrestamo
	 */
	public void actualizar(Dispositivo dispositivo) throws ExcepcionPrestamo;
	
	/**
	 * 
	 * @param id indica la id del dispositivo que se desea eliminar
	 * @throws ExcepcionPrestamo
	 */
	public void eliminar(String id) throws ExcepcionPrestamo;
	
	/***
	 * 
	 * @return una lista con todos los dispositivos registrados
	 * @throws ExcepcionPrestamo
	 */
	public List<Dispositivo> listar() throws ExcepcionPrestamo;
	
	/**
	 * 
	 * @return una lista con todos dispositivos registrados que se encuentran disponibles
	 * @throws ExcepcionPrestamo
	 */
	public List<Dispositivo> listarDisponibles() throws ExcepcionPrestamo;
	
	/**
	 * 
	 * @param id indica la id del dispositivo que se desea obtener
	 * @return un dispositivo cuya id coincide con la id ingresada como parámetro
	 * @throws ExcepcionPrestamo
	 */
	public Dispositivo listar(String id) throws ExcepcionPrestamo;
}
