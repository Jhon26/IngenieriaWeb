package co.edu.udea.dispositivos.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Especifica el DTO Usuario con sus setters y getters
 * @author lenovo
 *
 */
//@XmlRootElement
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String nombres;
	private String apellidos;
	private String nombreUsuario;
	private String contrasena;
	private String rol;//{Administrador, Investigador}
	/**
	 * @return la identificación del usuario
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id la identificación o DNI del usuario
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return el(los) nombre(s) del usuario
	 */
	public String getNombres() {
		return nombres;
	}
	/**
	 * @param nombres el(los) nombre(s) del usuario
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	/**
	 * @return el(los) apellido(s) del usuario
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * @param apellidos el(los) apellido(s) del usuario
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * @return el nombre de usuario que tendrá cada usuario para autenticarse en el sistema
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * @param nombreUsuario el nombre de usuario que tendrá cada usuario para autenticarse en el sistema
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * @return la contraseña que tendrá cada usuario para autenticarse en el sistema
	 */
	public String getContrasena() {
		return contrasena;
	}
	/**
	 * @param contrasena la contraseña que tendrá cada usuario para autenticarse en el sistema
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	/**
	 * @return el rol al cual pertenece el usuario
	 */
	public String getRol() {
		return rol;
	}
	/**
	 * @param rol el rol al cual pertenece el usuario
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
}
