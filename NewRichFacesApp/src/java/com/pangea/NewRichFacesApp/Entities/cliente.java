/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.NewRichFacesApp.Entities;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

/**
 *
 * @author pangea
 */
@Entity
@ManagedBean
@RequestScoped
public class cliente implements Serializable {
    
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
    
    @Column(name="CEDULA")
    private String cedula;
    
    @Column(name="NUMERO_CUENTA")
    private String nro_cuenta;

    
    
    @ManyToOne
    usuario myusuario;

    public usuario getMyusuario() {
        return myusuario;
    }

   
    
    
    
    
    //MYCODE------------------------------------------------------

  public void setMyusuario(usuario myusuario) {
        this.myusuario = myusuario;
    }
  
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNro_cuenta() {
        return nro_cuenta;
    }

    public void setNro_cuenta(String nro_cuenta) {
        this.nro_cuenta = nro_cuenta;
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
        if (!(object instanceof cliente)) {
            return false;
        }
        cliente other = (cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pangea.NewRichFacesApp.Entities.cliente[ id=" + id + " ]";
    }
    
}
