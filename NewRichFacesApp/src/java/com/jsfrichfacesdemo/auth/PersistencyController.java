/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfrichfacesdemo.auth;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pangea
 */
public class PersistencyController {
    
    public boolean persist(UserInfoBean NewUser)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewRichFacesAppPU");
        EntityManager em = emf.createEntityManager();
        
        try{
        em.getTransaction().begin();
        em.persist(NewUser);
        em.getTransaction().commit();
        return true;
        }catch(Exception e)
        {
            System.out.print(e.getMessage());
            return false;
        }
    }
    
}
