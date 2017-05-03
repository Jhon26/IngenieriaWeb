package co.edu.udea.dispositivos.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.dispositivos.dao.UsuarioDao;
import co.edu.udea.dispositivos.dto.Usuario;
import co.edu.udea.dispositivos.exception.ExcepcionPrestamo;

/**
 * Se presenta la implementación de los métodos de la interfaz UsuarioDao
 * @author lenovo
 *
 */
public class UsuarioDaoHibernate implements UsuarioDao{
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
	public void registrar(Usuario usuario) throws ExcepcionPrestamo{
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.save(usuario);
		}catch(HibernateException e){
			throw new ExcepcionPrestamo(e);
		}
	}
	
	@Override
	public void actualizar(Usuario usuario) throws ExcepcionPrestamo{
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			session.update(usuario);
		}catch(HibernateException e){
			throw new ExcepcionPrestamo(e);
		}
	}
	
	@Override
	public void eliminar(String id) throws ExcepcionPrestamo{
		Session session = null;
		Usuario usuario = new Usuario();
		usuario.setId(id);
		try{
			session = sessionFactory.getCurrentSession();
			session.delete(usuario);
		} catch (HibernateException e){
			throw new ExcepcionPrestamo(e);
		}
	}
	
	@Override
	public List<Usuario> listar() throws ExcepcionPrestamo{
		List<Usuario> lista = null;
		Session session = null;		
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Usuario.class);
			lista = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionPrestamo(e);
		}
		return lista;
	}
	

	@Override
	public Usuario listar(String id) throws ExcepcionPrestamo{
		Session session = null;
		Usuario usuario = null;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Usuario.class).add(Restrictions.eq("id", id));
			usuario = (Usuario)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionPrestamo(e);
		}
		return usuario;
	}
	
	public Usuario listarNombreUsuario(String nombreUsuario) throws ExcepcionPrestamo{
		Session session = null;
		Usuario usuario = null;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Usuario.class).add(Restrictions.eq("nombreUsuario", nombreUsuario));
			usuario = (Usuario)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionPrestamo(e);
		}
		return usuario;
	}
}
