/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import static algorithme.Algorithme_rangement.solution3;
import io.InstanceReader;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modele.Instance;
import modele.Solution;

/**
 *
 * @author alice
 */
public class TestBdd {
    
    public static void main(String[] args) 
    {
        //for (int i = 1; i < 11; i++){
        List <String> nameInstances = new ArrayList<String>();
            final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet");
            final EntityManager em = emf.createEntityManager();
            //final String query ="SELECT * FROM INSTANCE";
            try{
                final EntityTransaction et = em.getTransaction();
                try{
                    
                    
                    et.begin();
                    InstanceReader reader = new InstanceReader("../instances/instance_3.csv");
                    Instance instance = reader.readInstance();
                    Solution solution = new Solution();
                    solution = solution3( instance, 1);
                    solution.afficher();
                    em.persist(instance);
                    
        
            
                   
                    for(Object name:nameInstances)
                    {
                        System.out.println(name);
                    }
                    
                    et.commit();
                    
                    
                    
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
        //}
        
        
            
    }
    
}
    
