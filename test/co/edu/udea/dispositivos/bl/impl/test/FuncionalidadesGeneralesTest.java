package co.edu.udea.dispositivos.bl.impl.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.dispositivos.bl.FuncionalidadesGenerales;
import co.edu.udea.dispositivos.dto.Usuario;
import co.edu.udea.dispositivos.exception.ExcepcionPrestamo;


/**
 * Se realizan las pruebas para las operaciones de la interfaz FuncionalidadesGenerales
 * @author lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:configuracion.xml" })
public class FuncionalidadesGeneralesTest {
	@Autowired
	private FuncionalidadesGenerales funcionalidadesGenerales;
	
	
	@Test
	public void testLoguear() {
		try{
			Assert.assertNotNull(funcionalidadesGenerales.loguear("bbolivar", "123456"));
		}catch(ExcepcionPrestamo e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/*
	@Test
	public void testListarDispositivosDisponibles(){
		try{
			funcionalidadesGenerales.listarDispositivosDisponibles();
		}catch(ExcepcionPrestamo e) {
			e.printStackTrace();
			fail(e.getMessage());
		}		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSolicitarPrestamoDispositivo(){
		try{
			funcionalidadesGenerales.solicitarPrestamoDispositivo("1", "1", "2017-10-22/21:00:00", "2017-10-22/21:45:00");
		}catch(ExcepcionPrestamo e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
	}*/
}