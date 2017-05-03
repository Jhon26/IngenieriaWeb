package co.edu.udea.dispositivos.dao.hibernate.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.dispositivos.dao.UsuarioDao;
import co.edu.udea.dispositivos.dto.Usuario;
import co.edu.udea.dispositivos.exception.ExcepcionPrestamo;

/**
 * Pruebas para las operaciones de la interfaz UsuarioDao
 * @author lenovo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:configuracion.xml"})
public class UsuarioDaoTest{
    @Autowired
    private UsuarioDao usuarioDao;//Entidad que permite acceder a las operaciones de UsuarioDao

    /**
     * Prueba para registrar un usuario
     */
    @Test
    public void testRegistrar(){
        try {
            Usuario usuario = new Usuario();
            usuario.setId("1035228318");
            usuario.setNombres("Jhon");
            usuario.setApellidos("Alvarez");
            usuario.setNombreUsuario("jalvarez");
            usuario.setContrasena("ingweb");
            usuario.setRol("investigador");
            usuarioDao.registrar(usuario);
        } catch(ExcepcionPrestamo e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    /**
    * Prueba para actualizar un usuario
    */
    @Test
    public void testActualizar(){
        try {                        
            Usuario usuario = new Usuario();
            usuario.setId("1152451794");
            usuario.setNombres("Bairon");
            usuario.setApellidos("Bolivar");
            usuario.setNombreUsuario("bbolivar");
            usuario.setContrasena("ingweb");
            usuario.setRol("investigador");
            usuarioDao.actualizar(usuario);
        } catch (ExcepcionPrestamo e) {
            e.printStackTrace();
        }
    }
    
    /**
    * Prueba para eliminar un usuario
    */
    @Test
    public void testEliminar(){
        try{
            usuarioDao.eliminar("1152451794");
        }catch(ExcepcionPrestamo e){
        	e.printStackTrace();
        }
    }
    
    /**
    * Prueba para listar todos los usuarios registrados
    */
    @Test
    public void testListarUsuarios(){
        try {
            usuarioDao.listar();
        }catch(ExcepcionPrestamo e){
        	e.printStackTrace();
        }
    }
    
    /**
    * Prueba para listar un usuario específico
    */
    @Test
    public void testListar(){
        try {
            usuarioDao.listar("1152451794");
        }catch(ExcepcionPrestamo e){
        	e.printStackTrace();
        }
    }
}

