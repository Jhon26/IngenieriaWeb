package co.edu.udea.dispositivos.dao.hibernate.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.dispositivos.dao.PrestamoDao;
import co.edu.udea.dispositivos.dto.Prestamo;
import co.edu.udea.dispositivos.exception.ExcepcionPrestamo;

/**
 * Pruebas para las operaciones de la interfaz PrestamoDao
 * @author lenovo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:configuracion.xml"})
public class PrestamoDaoTest{
    @Autowired
    private PrestamoDao prestamoDao;//Entidad que permite acceder a las operaciones de PrestamoDao

    /**
     * Prueba para registrar un prestamo
     */
    @Test
    public void testRegistrar(){
        try {
        	Prestamo prestamo = new Prestamo();
        	prestamo.setId(Long.valueOf(2));
        	prestamo.setInvestigador("1152451794");
        	prestamo.setDispositivo("T1BE2");
        	prestamo.setFechaInicio(new Date());
        	prestamo.setFechaFin(new Date());
        	prestamo.setEstado("Sin Procesar");
        	prestamoDao.registrar(prestamo);
        } catch(ExcepcionPrestamo e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    /**
    * Prueba para actualizar un prestamo
    */
    @Test
    public void testActualizar(){
        try {                        
        	Prestamo prestamo = new Prestamo();
        	prestamo.setId(Long.valueOf(2));
        	prestamo.setInvestigador("1152451794");
        	prestamo.setDispositivo("T1BE2");
        	prestamo.setFechaInicio(new Date());
        	prestamo.setFechaFin(new Date());
        	prestamo.setEstado("Aprovado");
        	prestamoDao.actualizar(prestamo);
        } catch (ExcepcionPrestamo e) {
            e.printStackTrace();
        }
    }
    
    /**
    * Prueba para eliminar un prestamo
    */
    @Test
    public void testEliminar(){
        try{
        	prestamoDao.eliminar(Long.valueOf(2));
        }catch(ExcepcionPrestamo e){
        	e.printStackTrace();
        }
    }
    
    /**
    * Prueba para listar todos los prestamos registrados
    */
    @Test
    public void testListarPrestamos(){
        try {
            prestamoDao.listar();
        }catch(ExcepcionPrestamo e){
        	e.printStackTrace();
        }
    }
    
    /**
    * Prueba para listar un prestamo específico
    */
    @Test
    public void testListar(){
        try {
            prestamoDao.listar(Long.valueOf(7));
        }catch(ExcepcionPrestamo e){
        	e.printStackTrace();
        }
    }
}
