/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import io.InstanceReader;
import io.ReaderException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modele.Instance;

/**
 *
 * @author alice
 */
public class Main {
    
      
     public static void main(String[] args) {
         for (int i = 1; i < 11; i++){
            Instance Instance1 = new Instance();
            try {
                //user.dir normalement répertoire netbeans project
                String currentDirectory = System.getProperty("user.dir") + "/../instances/instance_" + i + ".csv";
                System.out.println("The current working directory is " + currentDirectory);
                InstanceReader InstanceTest= new InstanceReader(currentDirectory);
                Instance1 = InstanceTest.readInstance();
                Instance1.display();
            } catch (ReaderException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            List <Instance> BaseReturn = new ArrayList<Instance>();
            final String query = "SELECT * FROM ROOT.INSTANCE" ;
            final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet");
            final EntityManager em = emf.createEntityManager();
            try{
            Query querySent = em.createQuery(query);
            BaseReturn = querySent.getResultList();
            } catch(Exception ie){
            System.out.println(ie.getMessage());}
            finally {
                if(em != null && em.isOpen()){
                    System.err.println("close");
                    em.close();
                }
                if(emf != null && emf.isOpen()){
                    emf.close();
                }
            }
          
         }
      
    }
             
    
}
