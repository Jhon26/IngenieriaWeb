package co.edu.udea.dispositivos.bl.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.dispositivos.bl.FuncionalidadesGenerales;
import co.edu.udea.dispositivos.dao.DispositivoDao;
import co.edu.udea.dispositivos.dao.PrestamoDao;
import co.edu.udea.dispositivos.dao.UsuarioDao;
import co.edu.udea.dispositivos.dto.Dispositivo;
import co.edu.udea.dispositivos.dto.Prestamo;
import co.edu.udea.dispositivos.dto.Usuario;
import co.edu.udea.dispositivos.exception.ExcepcionPrestamo;

/**
 * Se implementan los métodos de la interfaz FuncionalidadesGenerales
 * @author lenovo
 *
 */
@Transactional
public class FuncionalidadesGeneralesImpl implements FuncionalidadesGenerales{
	private UsuarioDao usuarioDao;
	private DispositivoDao dispositivoDao;
	private PrestamoDao prestamoDao;
	
	public UsuarioDao getUsuarioDao(){
		return usuarioDao;
	}
	
	public void setUsuarioDao(UsuarioDao usuarioDao){
		this.usuarioDao = usuarioDao;
	}
	
	public DispositivoDao getDispositivoDao() {
		return dispositivoDao;
	}

	public void setDispositivoDao(DispositivoDao dispositivoDao) {
		this.dispositivoDao = dispositivoDao;
	}

	public PrestamoDao getPrestamoDao() {
		return prestamoDao;
	}

	public void setPrestamoDao(PrestamoDao prestamoDao) {
		this.prestamoDao = prestamoDao;
	}

	@Override
	public Usuario loguear(String nombreUsuario, String contrasena) throws ExcepcionPrestamo{
		Usuario usuario = null;
		//Validar datos ingresados
		if((nombreUsuario.trim().equals(""))||(nombreUsuario == null)){
			throw new ExcepcionPrestamo("Falta el nombre de usuario.", null);	
		}		
		if((contrasena.trim().equals(""))||(contrasena == null)){
			throw new ExcepcionPrestamo("Falta la contraseña.", null);		
		}
		try{
			usuario = usuarioDao.listarNombreUsuario(nombreUsuario);
		}catch(ExcepcionPrestamo e){
			e.printStackTrace();
		}
		if(usuario == null){
			throw new ExcepcionPrestamo("No se encuentra un usuario con el nombre de usuario especificado.", null);
		}else if((contrasena.equals(usuario.getContrasena()))&&(contrasena!=null)){
			return usuario;
		}else{
			throw new ExcepcionPrestamo("Usuario encontrado, pero no coincide con la contraseña ingresada.", null);
		}
	}
	
	@Override
	public List<Dispositivo> listarDispositivosDisponibles() throws ExcepcionPrestamo{
		List<Dispositivo> respuesta = null;
		respuesta = dispositivoDao.listarDisponibles();
		if((respuesta == null)||(respuesta.isEmpty())){
			throw new ExcepcionPrestamo("No se encontraron dispositivos disponibles.", null);
		}
		return respuesta;
	}
	
	@Override
	public void solicitarPrestamoDispositivo(String investigador, String dispositivo, 
		String fechaInicioS, String fechaFinS) throws ExcepcionPrestamo{
		
		//Validaciones para el investigador
		if((investigador.trim().equals(""))||(investigador == null)){
			throw new ExcepcionPrestamo("Falta la id del investigador.", null);
		}else if(usuarioDao.listar(investigador)==null){
			throw new ExcepcionPrestamo("El investigador con id "+investigador+" no está registrado", null);
		}else if(!"investigador".equals(usuarioDao.listar(investigador).getRol())){
			throw new ExcepcionPrestamo("El usuario con id "+investigador+" no es investigador", null);
		}
		//Validaciones para el dispositivo
		if((dispositivo.trim().equals(""))||(dispositivo == null)){
			throw new ExcepcionPrestamo("Falta la id del dispositivo.", null);
		}else if(dispositivoDao.listar(dispositivo)==null){
			throw new ExcepcionPrestamo("El dispositivo con id "+dispositivo+" no está registrado", null);
		}
		//Validaciones para las fechas
		if("".equals(fechaInicioS)||fechaInicioS==""){
			throw new ExcepcionPrestamo("Debe ingresar la fecha de inicio del préstamo.", null);
		}else if("".equals(fechaFinS)||fechaFinS==""){
			throw new ExcepcionPrestamo("Debe ingresar la fecha de finalización del préstamo.", null);
		}
		
		//Conversion de las fechas
		Date fechaInicio = convertirFecha(fechaInicioS);
		Date fechaFin = convertirFecha(fechaFinS);
		
		if(fechaInicio.before(new Date())){
			throw new ExcepcionPrestamo("La fecha de inicio del préstamo debe ser posterior "
					+ "a la fecha actual", null);
		}else if(fechaFin.before(fechaInicio)){
			throw new ExcepcionPrestamo("La fecha de finalización del préstamo debe ser posterior "
					+ "a la fecha de inicio del préstamo", null);
		}else if((fechaFin.getTime()-fechaInicio.getTime())>28800000){//28800000 son la cantidad de milisegundos en 8 horas
			throw new ExcepcionPrestamo("El dispositivo no puede ser prestado por más de "
					+ "8 horas.", null);
		}
		//Construcción del objeto DTO a guardar
		Prestamo prestamo = new Prestamo();
		prestamo.setId(Long.valueOf(0));//Se guarda 0 porque hibernate hace a la id autoincrement
		prestamo.setInvestigador(investigador);
		prestamo.setDispositivo(dispositivo);
		prestamo.setFechaInicio(fechaInicio);
		prestamo.setFechaFin(fechaFin);
		prestamo.setEstado("sin procesar");		
		//Guardado del préstamo
		prestamoDao.registrar(prestamo);
	}
	
	/**
	 * Metodo para convertir fechas de String a Date
	 * @param fechaS la fecha en formato String a convertir
	 * @return fecha la fecha convertida a Date
	 */
	public static Date convertirFecha(String fechaS){
		String[] partes = fechaS.split("/");
		String parteFecha = partes[0];
		String parteHora = partes[1];
		String[] partesFecha = parteFecha.split("-");
		int ano = Integer.valueOf(partesFecha[0]);
		int mes = Integer.valueOf(partesFecha[1]);
		int dia = Integer.valueOf(partesFecha[2]);
		String[] partesHora = parteHora.split(":");
		int hora = Integer.valueOf(partesHora[0]);
		int minuto = Integer.valueOf(partesHora[1]);
		int segundo = Integer.valueOf(partesHora[2]);

		Date fecha = new Date();
		fecha.setYear(ano-1900);
		fecha.setMonth(mes-1);
		fecha.setDate(dia);			
		fecha.setHours(hora);
		fecha.setMinutes(minuto);
		fecha.setSeconds(segundo);
		
		return fecha;
	}
}
