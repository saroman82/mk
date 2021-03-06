package com.santi.qr.service;

import java.util.List;

import com.santi.qr.model.Usuario;

public interface UsuarioService {

	public void creaUsuario(Usuario u);
	public void actualizaUsuario(Usuario u);
	public List<Usuario> listaUsuarios();
	public Usuario getUsuarioPorId(int id);
	public void eliminaUsuario(int id);
	
}
