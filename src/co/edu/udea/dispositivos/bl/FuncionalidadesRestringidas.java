package co.edu.udea.dispositivos.bl;

import java.util.List;

import co.edu.udea.dispositivos.dto.Prestamo;
import co.edu.udea.dispositivos.exception.ExcepcionPrestamo;


/**
 * Presenta las funcionalidades de acceso restringido requeridas en el sistema
 * @author lenovo
 *
 */
public interface FuncionalidadesRestringidas{
	
	//RF-01 Registrar investigadores
	/***
	 * 
	 * @param id id del investigador a registrar
	 * @param nombres el(los) nombre(s) del investigador a registrar
	 * @param apellidos el(los) apellido(s) del investigador a registrar
	 * @param nombreUsuario el nombre de usuario que usar� el investigador para la autenticaci�n
	 * @param contrasena la contrasena que usar� el investigador para la autenticaci�n
	 * @param administrador id del administrador que registra al investigador
	 * @throws ExcepcionPrestamo
	 */
	public void registrarInvestigador(String id, String nombres, String apellidos, 
			String nombreUsuario, String contrasena, String administrador) 
					throws ExcepcionPrestamo;
	
	//RF-09 Eliminar investigadores 
	/***
	 * 
	 * @param id id del investigador a eliminar
	 * @param administrador id del administrador que elimina al investigador
	 * @throws MyException
	 */
	public void eliminarInvestigador(String id, String administrador) 
			throws ExcepcionPrestamo;

	//RF-11 Actualizar investigadores 
	/***
	 * 
	 * @param id id del investigador a actualizar
	 * @param nombres el(los) nombre(s) del investigador a actualizar
	 * @param apellidos el(los) apellido(s) del investigador a actualizar
	 * @param nombreUsuario el nombre de usuario que usar� el investigador para la autenticaci�n
	 * @param contrasena la contrasena que usar� el investigador para la autenticaci�n
	 * @param administrador id del administrador que actualiza al investigador
	 * @throws ExcepcionPrestamo
	 */
	public void actualizarInvestigador(String id, String nombres, String apellidos, 
			String nombreUsuario, String contrasena, String administrador) 
					throws ExcepcionPrestamo;
	
	//RF-02 Registrar Dispositivos
	/**
	 * 
	 * @param id id del dispositivo a registrar
	 * @param tipo categor�a del dispositivo a registrar
	 * @param administrador id del administrador registra el dispositivo
	 * @throws ExcepcionPrestamo
	 */
	public void registrarDispositivo(String id, String tipo, String administrador) 
			throws ExcepcionPrestamo;

	//RF-03 Eliminar Dispositivos
	/**
	 * 
	 * @param id id del dispositivo a eliminar
	 * @param administrador id del administrador que elimina el dispositivo
	 * @throws ExcepcionPrestamo
	 */
	public void eliminarDispositivo(String id, String administrador) 
			throws ExcepcionPrestamo;
	
	//RF-04 Actualizar el estado de un dispositivo
	/**
	 * 
	 * @param id id del dispositivo a actualizar
	 * @param tipo categor�a del dispositivo a actualizar
	 * @param estado etapa del proceso de pr�stamo en la cual se encuentra el dispositivo
	 * @param administrador id del administrador actualiza el dispositivo
	 * @throws ExcepcionPrestamo
	 */
	public void actualizarDispositivo(String id, String tipo, String estado, String administrador) 
			throws ExcepcionPrestamo;

	//RF-06 Mostrar Peticiones de Pr�stamo
	/**
	 * 
	 * @return lista con los pr�stamos que tienen estado "Sin Procesar"
	 * @throws ExcepcionPrestamo
	 */
	public List<Prestamo> listarPrestamosSinProcesar() throws ExcepcionPrestamo;

	//RF-07 Responder peticiones de pr�stamo
	/**
	 * 
	 * @param id id del pr�stamo a dar respuesta
	 * @param respuesta resoluci�n otorgada a la solicitud de pr�stamo (Aprovar o Rechazar)
	 * @param administrador id del administrador que respondi� al prestamo
	 * @throws ExcepcionPrestamo
	 */
	public void responderPrestamo(Long id, String respuesta) throws ExcepcionPrestamo;
		
}
