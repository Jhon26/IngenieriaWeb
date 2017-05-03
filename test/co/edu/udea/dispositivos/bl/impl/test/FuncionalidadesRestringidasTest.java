package co.edu.udea.dispositivos.bl.impl.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.dispositivos.bl.FuncionalidadesRestringidas;
import co.edu.udea.dispositivos.exception.ExcepcionPrestamo;


/**
 * Se realizan las pruebas para las operaciones de la interfaz FuncionalidadesRestringidas
 * @author lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:configuracion.xml" })
public class FuncionalidadesRestringidasTest {
	@Autowired
	private FuncionalidadesRestringidas funcionalidadesRestringidas;
	
	@Test
	public void testRegistrarInvestigador(){
		try{
			funcionalidadesRestringidas.registrarInvestigador("10", 
					"Bairon", "Bolivar", "bbolivar", "123456", "1");
		}catch(ExcepcionPrestamo e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/*@Test
	public void testEliminarInvestigador(){
		try{
			funcionalidadesRestringidas.eliminarInvestigador("7", "1");
		}catch(ExcepcionPrestamo e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testActualizarInvestigador(){
		try{
			funcionalidadesRestringidas.actualizarInvestigador("1035228318", 
					"Bairon", "Bolivar", "bbolivar", "123456", "1");
		}catch(ExcepcionPrestamo e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testRegistrarDispositivo(){
		try{
			funcionalidadesRestringidas.registrarDispositivo("a45bt", "laptop", "1");
		}catch(ExcepcionPrestamo e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testELiminarDispositivo(){
		try{
			funcionalidadesRestringidas.eliminarDispositivo("a45bt", "1");
		}catch(ExcepcionPrestamo e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testActualizarDispositivo(){
		try{
			funcionalidadesRestringidas.actualizarDispositivo("a45bt", "tablet", "Ocupado", "1");
		}catch(ExcepcionPrestamo e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testListarPrestamosSinProcesar(){
		try{
			funcionalidadesRestringidas.listarPrestamosSinProcesar();
		}catch(ExcepcionPrestamo e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testResponderPrestamo(){
		try{
			funcionalidadesRestringidas.responderPrestamo(Long.valueOf(2), "Rechazado");
		}catch(ExcepcionPrestamo e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}*/
}
