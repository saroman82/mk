/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santi.qr.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.santi.qr.model.Muestrario;


@Repository
public class MuestrarioDAOImpl implements MuestrarioDAO {
    
    private static final Logger logger = LoggerFactory.getLogger(MuestrarioDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void creaMuestrario(Muestrario m) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(m);
		logger.info("Muestrario creado de manera correcta, detalles ="+m);
	}

	@Override
	public void actualizaMuestrario(Muestrario m) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(m);
		logger.info("Muestrario actualizado de manera correcta, detalles =="+m);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Muestrario> listaMuestrarios() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Muestrario> muestrariosList = session.createQuery("from Muestrario").list();
		for(Muestrario m : muestrariosList){
			logger.info("Muestrarios List::"+m);
		}
		return muestrariosList;
	}

	@Override
	public Muestrario getMuestrarioPorId(int id_qr) {
		Session session = this.sessionFactory.getCurrentSession();		
		Muestrario m = (Muestrario) session.load(Muestrario.class, new Integer(id_qr));
		logger.info("Muestrario cargado de manera correcta, detalles ==="+m);
		return m;
	}

	@Override
	public void eliminaMuestrario(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Muestrario m = (Muestrario) session.load(Muestrario.class, new Integer(id));
		if(null != m){
			session.delete(m);
		}
		logger.info("Muestrario eliminada de manera correcta, detalles="+m);
	}

    
}
