package co.edu.udea.dispositivos.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.dispositivos.dao.DispositivoDao;
import co.edu.udea.dispositivos.dto.Dispositivo;
import co.edu.udea.dispositivos.exception.ExcepcionPrestamo;


/**
 * Se presenta la implementación de los métodos de la interfaz DispositivoDao
 * @author lenovo
 *
 */
public class DispositivoDaoHibernate implements DispositivoDao{
	
	private SessionFactory sessionFactory;

	/**
	 * @return retorna el sessionFactory que permite acceder a la base de datos
	 */
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}

	/**
	 * Recibe el sessionFactory que permitirá el acceso a la base de datos
	 * @param sessionFactory 
	 */
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void registrar(Dispositivo dispositivo) throws ExcepcionPrestamo{
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			session.save(dispositivo);
		}catch(HibernateException e){
			throw new ExcepcionPrestamo(e);
		}
	}
	
	@Override
	public void actualizar(Dispositivo dispositivo) throws ExcepcionPrestamo{
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			session.update(dispositivo);
		}catch(HibernateException e){
			throw new ExcepcionPrestamo(e);
		}
	}
	
	@Override
	public void eliminar(String id) throws ExcepcionPrestamo{
		Session session = null;
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setId(id);
		try{
			session = sessionFactory.getCurrentSession();
			session.delete(dispositivo);
		} catch (HibernateException e){
			throw new ExcepcionPrestamo(e);
		}
	}
	
	@Override
	public List<Dispositivo> listar() throws ExcepcionPrestamo{
		List<Dispositivo> lista = null;
		Session session = null;		
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Dispositivo.class);
			lista = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionPrestamo(e);
		}
		return lista;
	}
	
	@Override
	public List<Dispositivo> listarDisponibles() throws ExcepcionPrestamo{
		Session session = null;
		List<Dispositivo> lista = null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Dispositivo.class).add(Restrictions.eq("estado", "disponible"));
			lista = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionPrestamo(e);
		}
		return lista;
	}

	@Override
	public Dispositivo listar(String id) throws ExcepcionPrestamo{
		Session session = null;
		Dispositivo dispositivo = null;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Dispositivo.class).add(Restrictions.eq("id", id));
			dispositivo = (Dispositivo)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionPrestamo(e);
		}
		return dispositivo;
	}
}
