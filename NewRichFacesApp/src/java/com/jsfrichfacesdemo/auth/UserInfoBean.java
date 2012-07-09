package com.jsfrichfacesdemo.auth;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author pangea
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class UserInfoBean implements Serializable {

    private String Nombre;
    private String Apellido;
    private String Cedula;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    public UserInfoBean()
    {
    
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public void guardar()
    {
        PersistencyController pc = new PersistencyController();
        boolean persist = pc.persist(this);
        System.out.print("Resultado: "+persist);
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
