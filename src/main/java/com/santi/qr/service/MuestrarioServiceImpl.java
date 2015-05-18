package com.santi.qr.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santi.qr.dao.MuestrarioDAO;
import com.santi.qr.model.Muestrario;

@Service
public class  MuestrarioServiceImpl implements MuestrarioService {
	
	private MuestrarioDAO muestrarioDAO;

	public void setMuestrarioDAO(MuestrarioDAO muestrarioDAO) {
		this.muestrarioDAO = muestrarioDAO;
	}

	@Override
	@Transactional
	public void creaMuestrario(Muestrario m) {
		this.muestrarioDAO.creaMuestrario(m);
        }

	@Override
	@Transactional
	public void actualizaMuestrario(Muestrario m) {
		this.muestrarioDAO.actualizaMuestrario(m);
	}

	@Override
	@Transactional
	public List<Muestrario> listaMuestrarios() {
		return this.muestrarioDAO.listaMuestrarios();
	}

	@Override
	@Transactional
	public Muestrario getMuestrarioPorId(int id_qr) {
		return this.muestrarioDAO.getMuestrarioPorId(id_qr);
	}

	@Override
	@Transactional
	public void eliminaMuestrario(int id_qr) {
		this.muestrarioDAO.eliminaMuestrario(id_qr);
	}

}
