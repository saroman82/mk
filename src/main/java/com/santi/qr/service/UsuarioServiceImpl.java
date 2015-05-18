package com.santi.qr.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santi.qr.dao.UsuarioDAO;
import com.santi.qr.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioDAO usuarioDAO;

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@Override
	@Transactional
	public void creaUsuario(Usuario u) {
		this.usuarioDAO.creaUsuario(u);
        }

	@Override
	@Transactional
	public void actualizaUsuario(Usuario u) {
		this.usuarioDAO.actualizaUsuario(u);
	}

	@Override
	@Transactional
	public List<Usuario> listaUsuarios() {
		return this.usuarioDAO.listaUsuarios();
	}

	@Override
	@Transactional
	public Usuario getUsuarioPorId(int id_user) {
		return this.usuarioDAO.getUsuarioPorId(id_user);
	}

	@Override
	@Transactional
	public void eliminaUsuario(int id_user) {
		this.usuarioDAO.eliminaUsuario(id_user);
	}

}
