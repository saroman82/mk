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
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;

    private String login;

    private String pass;

    private String nombre;

    private String apellidos;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getPass() {
       return pass;
    }


    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    @Override
    public String toString() {
        return "id_user=" +id_user + ", login=" + login + " , pass="+pass+ ", nombre=" + nombre +
                " , apellidos="+apellidos; 
    }

   
}
