/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.NewRichFacesApp.Entities;

import com.pangea.NewRichFacesApp.controllers.PersistenceController;
import com.sun.org.apache.bcel.internal.generic.Select;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.*;

/**
 *
 * @author pangea
 */
@ManagedBean
@RequestScoped
@Entity(name="USERS")
public class usuario implements Serializable {
    
    @OneToMany(mappedBy = "myusuario")
    private List<amonestacion> amonestacions;
    @OneToMany(mappedBy = "myusuario")
    private List<cliente> clientes;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    //MYCODE------------------------------------------------------
    
    
    
    @Column(name="NOMBRE")
    private String nombre;
    
    @Column(name="DIRECCION")
    private String direccion;
    
    @Column(name="CEDULA")
    private String cedula;
    
    //MYCODE------------------------------------------------------
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }



    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<amonestacion> getAmonestacions() {
        return amonestacions;
    }

    public void setAmonestacions(List<amonestacion> amonestacions) {
        this.amonestacions = amonestacions;
    }

    public List<cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<cliente> clientes) {
        this.clientes = clientes;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof usuario)) {
            return false;
        }
        usuario other = (usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pangea.NewRichFacesApp.Entities.usuario[ id=" + id + " ]";
    }
    
}
