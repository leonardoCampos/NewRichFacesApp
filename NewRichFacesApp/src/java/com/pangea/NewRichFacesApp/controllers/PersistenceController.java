/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pangea.NewRichFacesApp.controllers;

import com.pangea.NewRichFacesApp.Entities.cliente;
import com.pangea.NewRichFacesApp.Entities.usuario;
import java.util.*;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author pangea
 */
public class PersistenceController {
    
    public EntityManager getEntityManager()
    {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("NewRichFacesAppPU");
        EntityManager em = emf.createEntityManager();
        return em;
    }
    
    public boolean save(Object NewObject)
    {
        try{
            EntityManager EM = getEntityManager();
        EM.getTransaction().begin();
        EM.persist(NewObject);
        EM.getTransaction().commit();
        EM.close();
        return true;
        }catch(Exception e)
        {
            System.out.print(e.getMessage());
        return false;
        }
    }
    @SuppressWarnings("CallToThreadDumpStack")
    public List getUsuarios()
    {
    EntityManager em = getEntityManager();
    List options;
    options= new ArrayList();
    SelectItem option = new SelectItem("ch1", "choice1", "This bean is for selectItems tag", true);
    options.add(option);
    Object aux = new Object();
    usuario actual=null;
    try{
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT st FROM USERS st");
        List lst = query.getResultList();
        Iterator it = lst.iterator();
        while (it.hasNext()){
           aux =  it.next();
           actual = (usuario) aux;
           option = new SelectItem(actual.getId(),actual.getNombre());
          options.add(option);
        }
        em.getTransaction().commit();
         }
        catch(Exception e){
        e.printStackTrace();
        }finally{}
            em.close();
        return options;
    
    }
    public usuario getCompleteInfo(long id){
    EntityManager em = getEntityManager();
    usuario user= null;
    try{
    em.getTransaction().begin();
    user = em.find(usuario.class,id);
    em.getTransaction().commit();
    em.close();
    }catch(Exception e)
    {
        e.printStackTrace();
    }
    return user;
    }
    
    public void updateUser(usuario newUser)
    {
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            usuario oldUser = em.find(usuario.class,newUser.getId());
            oldUser.setNombre(newUser.getNombre());
            oldUser.setCedula(newUser.getCedula());
            oldUser.setDireccion(newUser.getDireccion());
            em.merge(oldUser);
            em.getTransaction().commit();
            em.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void delUser(Long id){
        EntityManager em = getEntityManager();
        
        try{
        em.getTransaction().begin();
        usuario deleter = em.find(usuario.class, id);
        em.remove(deleter);
        em.getTransaction().commit();
        em.close();}catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void addClient(cliente newclient,Long id)
    {
        EntityManager em = getEntityManager();
        EntityManager em2 = getEntityManager();
        usuario user;
        try{
        em.getTransaction().begin();
        user = em.find(usuario.class,id);
        user.agregarCliente(newclient);
        newclient.setMyusuario(user);
        em.persist(newclient);
        em.merge(user);
        em.getTransaction().commit();
        em.close();
        
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
