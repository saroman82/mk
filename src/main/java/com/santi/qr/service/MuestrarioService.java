/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santi.qr.service;

import java.util.List;
import com.santi.qr.model.Muestrario;
/**
 *
 * @author santi
 */
public interface MuestrarioService {
    
    public void creaMuestrario(Muestrario m);
	public void actualizaMuestrario(Muestrario m);
	public List<Muestrario> listaMuestrarios();
	public Muestrario getMuestrarioPorId(int id);
	public void eliminaMuestrario(int id);
	
    
}
