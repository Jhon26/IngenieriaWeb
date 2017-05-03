package co.edu.udea.dispositivos.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.dispositivos.dao.PrestamoDao;
import co.edu.udea.dispositivos.dto.Prestamo;
import co.edu.udea.dispositivos.exception.ExcepcionPrestamo;

/**
 * Se presenta la implementación de los métodos de la interfaz PrestamoDao
 * @author lenovo
 *
 */
public class PrestamoDaoHibernate implements PrestamoDao{
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
	public void registrar(Prestamo prestamo) throws ExcepcionPrestamo{
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.save(prestamo);
		}catch(HibernateException e){
			throw new ExcepcionPrestamo(e);
		}
	}
	
	@Override
	public void actualizar(Prestamo prestamo) throws ExcepcionPrestamo{
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			session.update(prestamo);
		}catch(HibernateException e){
			throw new ExcepcionPrestamo(e);
		}
	}
	
	@Override
	public void eliminar(Long id) throws ExcepcionPrestamo{
		Session session = null;
		Prestamo prestamo = new Prestamo();
		prestamo.setId(id);
		try{
			session = sessionFactory.getCurrentSession();
			session.delete(prestamo);
		} catch (HibernateException e){
			throw new ExcepcionPrestamo(e);
		}
	}
	
	@Override
	public List<Prestamo> listar() throws ExcepcionPrestamo{
		List<Prestamo> lista = null;
		Session session = null;		
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Prestamo.class);
			lista = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionPrestamo(e);
		}
		return lista;
	}
	
	@Override
	public Prestamo listar(Long id) throws ExcepcionPrestamo{
		Session session = null;
		Prestamo prestamo = null;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Prestamo.class).add(Restrictions.eq("id", id));
			prestamo = (Prestamo)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionPrestamo(e);
		}
		return prestamo;
	}
	
	@Override
	public List<Prestamo> listarPrestamosSinProcesar() throws ExcepcionPrestamo{
		Session session = null;
		List<Prestamo> lista = null;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Prestamo.class).add(Restrictions.eq("estado", "Sin Procesar"));
			lista = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionPrestamo(e);
		}
		return lista;
	}
}