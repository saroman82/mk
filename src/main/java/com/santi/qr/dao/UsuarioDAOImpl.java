package com.santi.qr.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.santi.qr.model.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void creaUsuario(Usuario u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(u);
		logger.info("Usuario creado de manera correcta, detalles ="+u);
	}

	@Override
	public void actualizaUsuario(Usuario u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(u);
		logger.info("Usuario actualizado de manera correcta, detalles =="+u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listaUsuarios() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Usuario> usuariosList = session.createQuery("from Usuario").list();
		for(Usuario u : usuariosList){
			logger.info("Usuarios List::"+u);
		}
		return usuariosList;
	}

	@Override
	public Usuario getUsuarioPorId(int id_user) {
		Session session = this.sessionFactory.getCurrentSession();		
		Usuario u = (Usuario) session.load(Usuario.class, new Integer(id_user));
		logger.info("Usuario cargado de manera correcta, detalles ==="+u);
		return u;
	}

	@Override
	public void eliminaUsuario(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Usuario u = (Usuario) session.load(Usuario.class, new Integer(id));
		if(null != u){
			session.delete(u);
		}
		logger.info("Persona eliminada de manera correcta, detalles="+u);
	}

}
