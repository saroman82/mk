package com.santi.qr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 *
 * @author pankaj
 *
 */
@Entity
@Table(name = "Muestrarios")
public class Muestrario {

    @Id
    @Column(name = "id_qr")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_qr;

    private int id_proveedor;

    private String tipo_mueble;

    private String ruta;

    public int getId_qr() {
        return id_qr;
    }

    public void setId_qr(int id_qr) {
        this.id_qr = id_qr;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    
    public String getTipo_mueble() {
       return tipo_mueble;
    }


    public void setTipo_mueble(String tipo_mueble) {
        this.tipo_mueble = tipo_mueble;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }


    @Override
    public String toString() {
        return "id_qr=" +id_qr + ", id_proveedor=" + id_proveedor + " , tipo_mueble="+tipo_mueble+ ", ruta=" + ruta;
          
    }

   
}
