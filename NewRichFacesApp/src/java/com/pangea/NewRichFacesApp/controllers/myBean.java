/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.NewRichFacesApp.controllers;

import com.pangea.NewRichFacesApp.Entities.usuario;
import java.io.IOException;
import java.util.Collection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
//this is MY BEAN!! No it is not!!!
/**
 *
 * @author pangea
 */
@ManagedBean
@RequestScoped
public class myBean {
    PersistenceController PC;
    String usuarioNombre;
    String usuarioDireccion;
    String usuarioCedula;
    String ajxName;
    String ajxNombre;
    String ajxDireccion;
    String ajxCedula;
    Collection<SelectItem> usuarios;

    public myBean(){
    PC= new PersistenceController();
    }
    
    public String getUsuarioCedula() {
        return usuarioCedula;
    }

    public void setUsuarioCedula(String usuarioCedula) {
        this.usuarioCedula = usuarioCedula;
    }

    public String getUsuarioDireccion() {
        return usuarioDireccion;
    }

    public void setUsuarioDireccion(String usuarioDireccion) {
        this.usuarioDireccion = usuarioDireccion;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }
    
    public void añadirUsuario() throws IOException
    {   
        usuario myusuario = new usuario();
        myusuario.setNombre(usuarioNombre);
        myusuario.setDireccion(usuarioDireccion);
        myusuario.setCedula(usuarioCedula);
        PC.save(myusuario);
        FacesContext.getCurrentInstance().getExternalContext().dispatch("../index.xhtml");
    }
    
    public void ConsultarUsuario()
    {
        System.out.print("entro");
    }

    public Collection<SelectItem> getUsuarios() {
        usuarios = PC.getUsuarios();
        return usuarios;
    }

    public void setUsuarios(Collection<SelectItem> usuarios) {
        this.usuarios = usuarios;
    }

    public String getAjxName() {
        return ajxName;
    }

    public void setAjxName(String ajxName) {
        usuario ajxuser = PC.getCompleteInfo(Long.parseLong(ajxName));
        this.ajxNombre = ajxuser.getNombre();
        this.ajxDireccion = ajxuser.getDireccion();
        this.ajxCedula = ajxuser.getCedula();
        this.ajxName = ajxName;
        
    }
    
    public void actualizarUsuario()
    {
        usuario newUser = new usuario();
        newUser.setCedula(this.usuarioCedula);
        newUser.setDireccion(this.usuarioDireccion);
        newUser.setNombre(this.usuarioNombre);
        newUser.setId(Long.parseLong(getAjxName()));
        PC.updateUser(newUser);
    }
    
    public void EliminarUsuario()
    {
        PC.delUser(Long.parseLong(this.ajxName));
    }

    public String getAjxCedula() {
        return ajxCedula;
    }

    public void setAjxCedula(String ajxCedula) {
        this.ajxCedula = ajxCedula;
    }

    public String getAjxDireccion() {
        return ajxDireccion;
    }

    public void setAjxDireccion(String ajxDireccion) {
        this.ajxDireccion = ajxDireccion;
    }

    public String getAjxNombre() {
        return ajxNombre;
    }

    public void setAjxNombre(String ajxNombre) {
        this.ajxNombre = ajxNombre;
    }
    
    
}
