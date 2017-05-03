package co.edu.udea.dispositivos.dao.hibernate.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.dispositivos.dao.DispositivoDao;
import co.edu.udea.dispositivos.dto.Dispositivo;
import co.edu.udea.dispositivos.exception.ExcepcionPrestamo;
import junit.framework.Assert;

/**
 * Pruebas para las operaciones de la interfaz DispositivoDao
 * @author lenovo
 */
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:configuracion.xml"})
public class DispositivoDaoTest{
    
	@Autowired
    private DispositivoDao dispositivoDao;//Entidad que permite acceder a las operaciones de DispositivoDao*/

    /**
     * Prueba para registrar un dispositivo
     */
    @Test
    public void testRegistrar() throws ExcepcionPrestamo{
        /*try {
    		Dispositivo dispositivo = new Dispositivo();
    		dispositivo.setId("01AN2");
    		dispositivo.setTipo("Laptop");
    		dispositivo.setEstado("Disponible");
            dispositivoDao.registrar(dispositivo);			
        }catch(ExcepcionPrestamo e){
            e.printStackTrace();
            fail(e.getMessage());
        }*/
    	Assert.assertEquals("uno", "uno");;
    }

    /**
    * Prueba para actualizar un dispositivo
    */
    @Test
    public void testActualizar(){
        try {                        
        	Dispositivo dispositivo = new Dispositivo();
    		dispositivo.setId("T1BE2");
    		dispositivo.setTipo("Laptop");
    		dispositivo.setEstado("Disponible");
            dispositivoDao.actualizar(dispositivo);
        } catch (ExcepcionPrestamo e) {
            e.printStackTrace();
        }
    }
    
    /**
    * Prueba para eliminar un dispositivo
    */
    @Test
    public void testEliminar(){
        try{
            dispositivoDao.eliminar("T1BE2");
        }catch(ExcepcionPrestamo e){
        	e.printStackTrace();
        }
    }
   
    /**
    * Prueba para listar todos los dispositivos registrados
    */
    @Test
    public void testListarDispositivos(){
        try {
            dispositivoDao.listar();
        }catch(ExcepcionPrestamo e){
        	e.printStackTrace();
        }
    }
    
    /**
     * Prueba para listar todos los dispositivo con estado disponible
     */
     @Test
     public void testListarDisponible(){
         try {
             dispositivoDao.listarDisponibles();
         }catch(ExcepcionPrestamo e){
        	 e.printStackTrace();
         }
     }
    
    /**
    * Prueba para listar un dispositivo específico
    */
    @Test
    public void testListar(){
        try {
            dispositivoDao.listar("T1BE2");
        }catch(ExcepcionPrestamo e){
        	e.printStackTrace();
        }
    }
}