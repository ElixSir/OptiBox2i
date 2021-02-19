/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_algorithme;


import static algorithme.Algorithme_rangement.solution3;
import io.InstanceReader;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modele.Instance;

import modele.Solution;

/**
 *
 * @author felix
 */
public class test_algorithme_rangement {
    public static void main(String[] args) {
        
        
        
        for (int i = 8; i<9; i++){
            Instance instance = new Instance();
            final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet");
            final EntityManager em = emf.createEntityManager();
            try{
                final EntityTransaction et = em.getTransaction();
                try{
                    
                    et.begin();
                    InstanceReader reader = new InstanceReader("../instances/instance_" + i + ".csv");
                    instance = reader.readInstance();
                
                    
                }catch (Exception ex) {
                    et.rollback();
                    System.err.println("rollback");
                    System.out.println(ex);
                }
            } finally {
                if(em != null && em.isOpen()){
                    System.err.println("close");
                    em.close();
                }
            if(emf != null && emf.isOpen()){
                emf.close();
            }
            }
        
        System.out.println("\n\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n\n");
            
        System.out.println("instance en cours de traitement:\n" + instance.toString() + "\n");
        
        System.out.println("résultats instance 4 :\n\n");
        
        
        System.out.println("test triL");
        Solution solutionL = solution3(instance, 1);
        System.out.println(solutionL.afficher());
        
        
        System.out.println("\n\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
        }
          
        
}
    
}
