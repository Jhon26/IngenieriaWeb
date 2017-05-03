package co.edu.udea.dispositivos.bl.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.dispositivos.bl.FuncionalidadesRestringidas;
import co.edu.udea.dispositivos.dao.DispositivoDao;
import co.edu.udea.dispositivos.dao.PrestamoDao;
import co.edu.udea.dispositivos.dao.UsuarioDao;
import co.edu.udea.dispositivos.dto.Dispositivo;
import co.edu.udea.dispositivos.dto.Prestamo;
import co.edu.udea.dispositivos.dto.Usuario;
import co.edu.udea.dispositivos.exception.ExcepcionPrestamo;

/**
 * Se implementan los métodos de la interfaz FuncionalidadesRestringidas
 * @author lenovo
 *
 */
@Transactional
public class FuncionalidadesRestringidasImpl implements FuncionalidadesRestringidas{
	private UsuarioDao usuarioDao;
	private PrestamoDao prestamoDao;
	private DispositivoDao dispositivoDao;
	
	public UsuarioDao getUsuarioDao(){
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao){
		this.usuarioDao = usuarioDao;
	}
	
	public PrestamoDao getPrestamoDao(){
		return prestamoDao;
	}

	public void setPrestamoDao(PrestamoDao prestamoDao){
		this.prestamoDao = prestamoDao;
	}
	
	public DispositivoDao getDispositivoDao(){
		return dispositivoDao;
	}

	public void setDispositivoDao(DispositivoDao dispositivoDao){
		this.dispositivoDao = dispositivoDao;
	}
	
	@Override
	public void registrarInvestigador(String id, String nombres, String apellidos, 
			String nombreUsuario, String contrasena, String administrador) 
					throws ExcepcionPrestamo{
		//Validaciones invetigador a registrar
		if(id.trim().equals("") || id == null){
			throw new ExcepcionPrestamo("Falta el id del investigador a registrar", null);
		}else if(usuarioDao.listar(id)!=null){
			throw new ExcepcionPrestamo("El id ingresado ya corresponde a un investigador registrado", null);
		}
		if(nombres.trim().equals("") || nombres == null){
			throw new ExcepcionPrestamo("Falta el(los) nombre(s) del investigador a registrar", null);
		}
		if(apellidos.trim().equals("") || apellidos == null){
			throw new ExcepcionPrestamo("Falta el(los) apellido(s) del investigador a registrar", null);
		}
		if(nombreUsuario.trim().equals("") || nombreUsuario == null){
			throw new ExcepcionPrestamo("Falta el nombre de usuario del investigador a registrar", null);
		}else if(usuarioDao.listarNombreUsuario(nombreUsuario)!=null){
			throw new ExcepcionPrestamo("El nombre de usuario ingresado ya existe", null);
		}
		if(contrasena.trim().equals("") || contrasena == null){
			throw new ExcepcionPrestamo("Falta la contrasena del investigador a registrar", null);
		}
		//Validaciones administrador que registra
		validarAdministrador(administrador);
		
		//Construcción de DTO a guardar
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNombres(nombres);
		usuario.setApellidos(apellidos);
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setContrasena(contrasena);
		usuario.setRol("investigador");

		//Se realiza el registro del investigador
		usuarioDao.registrar(usuario);
	}
	
	@Override
	public void eliminarInvestigador(String id, String administrador) 
			throws ExcepcionPrestamo{
		//Validaciones investigador a eliminar
		if(id.trim().equals("") || id == null){
			throw new ExcepcionPrestamo("Falta el id del investigador a registrar", null);
		}else if(usuarioDao.listar(id)==null){
			throw new ExcepcionPrestamo("El investigador con id "+id+" no está registrado", null);
		}else if(usuarioDao.listar(id).getRol()!="Investigador"){
			throw new ExcepcionPrestamo("El usuario con id "+id+" no es un investigador", null);
		}

		//Validaciones administrador que elimina
		validarAdministrador(administrador);
		
		//Se ejecuta la eliminación
		usuarioDao.eliminar(id);
	}
	
	@Override
	public void actualizarInvestigador(String id, String nombres, String apellidos, 
			String nombreUsuario, String contrasena, String administrador) 
					throws ExcepcionPrestamo{
		//Validaciones invetigador a actualizar
		if(id.trim().equals("") || id == null){
			throw new ExcepcionPrestamo("Falta el id del investigador a actualizar", null);
		}else if(usuarioDao.listar(id)==null){
			throw new ExcepcionPrestamo("El id ingresado no corresponde con un investigador registrado", null);
		}
		if(nombres.trim().equals("") || nombres == null){
			throw new ExcepcionPrestamo("Falta el(los) nombre(s) del investigador a actualizar", null);
		}
		if(apellidos.trim().equals("") || apellidos == null){
			throw new ExcepcionPrestamo("Falta el(los) apellido(s) del investigador a actualizar", null);
		}
		if(nombreUsuario.trim().equals("") || nombreUsuario == null){
			throw new ExcepcionPrestamo("Falta el nombre de usuario del investigador a actualizar", null);
		}else if(usuarioDao.listarNombreUsuario(nombreUsuario)!=null){
			throw new ExcepcionPrestamo("El nombre de usuario ingresado ya existe", null);
		}
		if(contrasena.trim().equals("") || contrasena == null){
			throw new ExcepcionPrestamo("Falta la contrasena del investigador a actualizar", null);
		}
		//Validaciones administrador que actualiza
		validarAdministrador(administrador);
		
		//Construcción de DTO a actualizar
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNombres(nombres);
		usuario.setApellidos(apellidos);
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setContrasena(contrasena);
		usuario.setRol("Investigador");

		//Se realiza la actualización del investigador
		usuarioDao.actualizar(usuario);
	}
	
	@Override
	public void registrarDispositivo(String id, String tipo, String administrador) 
			throws ExcepcionPrestamo{
		//Validaciones dispositivo a registrar
		if(id.trim().equals("") || id == null){
			throw new ExcepcionPrestamo("Falta el id del dispositivo a registrar", null);
		}else if(dispositivoDao.listar(id)!=null){
			throw new ExcepcionPrestamo("El id ingresado ya corresponde a un dispositivo registrado", null);
		}
		if(tipo.trim().equals("") || tipo == null){
			throw new ExcepcionPrestamo("Falta el tipo del dispositivo a registrar", null);
		}
		
		//Validaciones administrador que registra
		validarAdministrador(administrador);
		
		//Construcción del DTO a registrar
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setId(id);
		dispositivo.setTipo(tipo);
		dispositivo.setEstado("Disponible");

		//Se realiza el registro del dispositivo
		dispositivoDao.registrar(dispositivo);
	}

	@Override
	public void eliminarDispositivo(String id, String administrador) 
			throws ExcepcionPrestamo{
		if(id.trim().equals("") || id == null){
			throw new ExcepcionPrestamo("Falta el id del dispositivo a eliminar", null);
		}else if(dispositivoDao.listar(id)==null){
			throw new ExcepcionPrestamo("El id ingresado no corresponde con un dispositivo registrado", null);
		}

		//Validaciones administrador que elimina
		validarAdministrador(administrador);

		//Se realiza la eliminación del dispositivo
		dispositivoDao.eliminar(id);
	}
	
	@Override
	public void actualizarDispositivo(String id, String tipo, String estado, String administrador) 
			throws ExcepcionPrestamo{
		//Validaciones dispositivo a actualizar
		if(id.trim().equals("") || id == null){
			throw new ExcepcionPrestamo("Falta el id del dispositivo a actualizar", null);
		}else if(dispositivoDao.listar(id)==null){
			throw new ExcepcionPrestamo("El id ingresado no corresponde con un dispositivo registrado", null);
		}
		if(tipo.trim().equals("") || tipo == null){
			throw new ExcepcionPrestamo("Falta el tipo del dispositivo a actualizar", null);
		}
		if(estado.trim().equals("") || estado == null){
			throw new ExcepcionPrestamo("Falta el estado del dispositivo a actualizar", null);
		}
		
		//Validaciones administrador que actualiza
		validarAdministrador(administrador);
		
		//Construcción del DTO a actualizar
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setId(id);
		dispositivo.setTipo(tipo);
		dispositivo.setEstado("Disponible");

		//Se realiza la actualización del dispositivo
		dispositivoDao.actualizar(dispositivo);
	}
	
	@Override
	public List<Prestamo> listarPrestamosSinProcesar() throws ExcepcionPrestamo{
		List<Prestamo> respuesta = null;
		respuesta = prestamoDao.listarPrestamosSinProcesar();
		if ((respuesta.size() <= 0)||(respuesta == null)) {
			throw new ExcepcionPrestamo("No hay préstamos sin procesar", null);
		}
		return respuesta;
	}
	
	@Override
	public void responderPrestamo(Long id, String respuesta) throws ExcepcionPrestamo{
		//Validaciones préstamo a responder
		if(id.equals(null) || id == null || id==0L || id.equals(0L)){
			throw new ExcepcionPrestamo("Falta el id del préstamo a responder", null);
		}else if(!respuesta.trim().toLowerCase().equals("aprobado")&&
				!respuesta.trim().toLowerCase().equals("rechazado")&&
				!respuesta.trim().toLowerCase().equals("finalizado")){
			throw new ExcepcionPrestamo("La respuesta ingresada no es válida", null);
		}else if(prestamoDao.listar(id)==null){
			throw new ExcepcionPrestamo("El id ingresado no corresponde con un préstamo registrado", null);
		}else if(("aprobado".equals(respuesta.trim().toLowerCase()))&&
				((dispositivoDao.listar(prestamoDao.listar(id).getDispositivo()).getEstado().trim().toLowerCase()=="ocupado")||
				("ocupado".equals(dispositivoDao.listar(prestamoDao.listar(id).getDispositivo()).getEstado().trim().toLowerCase())))){
			throw new ExcepcionPrestamo("El dispositivo a prestar está ocupado", null);
		}else if(prestamoDao.listar(id).getEstado()=="Rechazado"||
				"rechazado".equals(prestamoDao.listar(id).getEstado().trim().toLowerCase())||
				prestamoDao.listar(id).getEstado()=="Finalizado"||
				"finalizado".equals((prestamoDao.listar(id).getEstado().trim().toLowerCase()))){
			throw new ExcepcionPrestamo("No se puede responder a este prestamo, ya que está finalizado o fue rechazado", null);
		}else if("rechazado".equals(respuesta.trim().toLowerCase())&&
				("aprobado".equals(prestamoDao.listar(id).getEstado().trim().toLowerCase()))||
				prestamoDao.listar(id).getEstado().trim().toLowerCase()=="aprobado"){
			throw new ExcepcionPrestamo("No se puede rechazar un préstamo aprobado.", null);
		}else if("finalizado".equals(respuesta.trim().toLowerCase())&&
				"sin procesar".equals(prestamoDao.listar(id).getEstado().trim().toLowerCase())){
			throw new ExcepcionPrestamo("No se puede finalizar un préstamo sin procesar. Debe aprobarlo o rechazarlo", null);
		}
		
		//Se cambia el estado del préstamo
		prestamoDao.listar(id).setEstado(respuesta);
		prestamoDao.actualizar(prestamoDao.listar(id));
		
		//Si la respuesta fue "Aprobado", se cambia también el estado del dispositivo a "Ocupado"
		if(("aprobado".equals(respuesta.trim().toLowerCase()))||(respuesta=="Aprobado")){
			dispositivoDao.listar(prestamoDao.listar(id).getDispositivo()).setEstado("ocupado");
		}
		
		//Si la respuesta fue "Finalizado", se cambia también el estado del dispositivo a "Disponible"
		if(("finalizado".equals(respuesta.trim().toLowerCase()))||(respuesta=="Finalizado")){
			dispositivoDao.listar(prestamoDao.listar(id).getDispositivo()).setEstado("disponible");
		}
		
	}
	
	public void validarAdministrador(String administrador) throws ExcepcionPrestamo{
		if(administrador.trim().equals("") || administrador == null){
			throw new ExcepcionPrestamo("Falta el id del administrador que actualizar al investigador", null);
		}else if(usuarioDao.listar(administrador)==null){
			throw new ExcepcionPrestamo("El administrador con id "+administrador+" no está registrado", null);
		}else if(!"administrador".equals(usuarioDao.listar(administrador).getRol())){
			throw new ExcepcionPrestamo("El usuario con id "+administrador+" no es un administrador", null);
		}
	}
}
