package co.edu.udea.dispositivos.dao;

import java.util.List;

import co.edu.udea.dispositivos.dto.Usuario;
import co.edu.udea.dispositivos.exception.ExcepcionPrestamo;

/**
 * Permite acceder a los datos de un usuario
 * @author lenovo
 *
 */
public interface UsuarioDao {

	/**
	 * 
	 * @param usuario indica el usuario a guardar 
	 * @throws ExcepcionPrestamo
	 */
	public void registrar(Usuario usuario) throws ExcepcionPrestamo;
	
	/**
	 * 
	 * @param usuario indica el usuario que será modificado
	 * @throws ExcepcionPrestamo
	 */
	public void actualizar(Usuario usuario) throws ExcepcionPrestamo;
	
	/**
	 * 
	 * @param id indica la id del usuario que se desea eliminar
	 * @throws ExcepcionPrestamo
	 */
	public void eliminar(String id) throws ExcepcionPrestamo;
	
	/***
	 * 
	 * @return una lista con todos los dispositivos registrados
	 * @throws ExcepcionPrestamo
	 */
	public List<Usuario> listar() throws ExcepcionPrestamo;
	
		
	/**
	 * 
	 * @param id indica la id del usuario que se desea obtener
	 * @return un usuario cuya id coincide con la id ingresada como parámetro
	 * @throws ExcepcionPrestamo
	 */
	public Usuario listar(String id) throws ExcepcionPrestamo;
	
	/**
	 * 
	 * @param usuario indica el nombre de usuario del usuario que se desea obtener
	 * @return un usuario cuya id coincide con la id ingresada como parámetro
	 * @throws ExcepcionPrestamo
	 */
	public Usuario listarNombreUsuario(String usuario) throws ExcepcionPrestamo;
}
