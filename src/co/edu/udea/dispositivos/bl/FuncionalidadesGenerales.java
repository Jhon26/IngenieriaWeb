package co.edu.udea.dispositivos.bl;

import java.util.List;

import co.edu.udea.dispositivos.dto.Dispositivo;
import co.edu.udea.dispositivos.dto.Usuario;
import co.edu.udea.dispositivos.exception.ExcepcionPrestamo;


/**
 * Presenta las funcionalidades generales requeridas en el sistema
 * @author lenovo
 *
 */
public interface FuncionalidadesGenerales{
	
	//RF-10 Logueo de usuario
	/**
	 * 
	 * @param nombreUsuario nombre de usuario del usuario que desea loguearse
	 * @param contrasena contrasena del usuario que desea loguearse
	 * @return true si el logueo es satisfactorio o false en caso contrario
	 * @throws ExcepcionPrestamo
	 */
	public Usuario loguear(String nombreUsuario, String contrasena) throws ExcepcionPrestamo;
	
	//RF-08 Mostrar dispositivos disponibles
	/***
	 * 
	 * @return lista de dispositivos con estado "Disponible"
	 * @throws ExcepcionPrestamo
	 */
	public List<Dispositivo> listarDispositivosDisponibles() throws ExcepcionPrestamo;
	
	//RF-05 Solicitar préstamo de un dispositivo
	/***
	 * 
	 * @param investigador id del investigador que solicita el préstamo
	 * @param dispositivo id del dispositivo que desea prestar
	 * @param fechaInicio fecha en la cual se desea prestar el dispositivo
	 * @param fechaFin fecha en la cual finalizará el préstamo. No puede estar a más de 8 horas
	 * 		  después de fechaInicio
	 * @throws ExcepcionPrestamo
	 */
	public void solicitarPrestamoDispositivo(String investigador, String dispositivo, 
			String fechaInicio, String fechaFin) throws ExcepcionPrestamo;
}

