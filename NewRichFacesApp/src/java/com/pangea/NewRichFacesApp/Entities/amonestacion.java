/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.NewRichFacesApp.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author pangea
 */
@Entity
public class amonestacion implements Serializable {
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
    
    @Column(name="DESCRIPCION")
    private String descripcion;
    
    @Column(name="FECHA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    @ManyToOne
    usuario myusuario;

   
    
    //MYCODE------------------------------------------------------
 public usuario getMyusuario() {
        return myusuario;
    }

    public void setMyusuario(usuario myusuario) {
        this.myusuario = myusuario;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        if (!(object instanceof amonestacion)) {
            return false;
        }
        amonestacion other = (amonestacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pangea.NewRichFacesApp.Entities.amonestacion[ id=" + id + " ]";
    }
    
}
