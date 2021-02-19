/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;
import io.InstanceReader;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modele.Instance;
import io.InstanceReader;


/**
 *
 * @author alice
 */
public class BaseDeDonnee {
    static public  List <Instance> afficherInstance(){
         List <Instance> BaseReturn = new ArrayList<Instance>();
        final String query = "SELECT * FROM Instance" ;
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
        return BaseReturn;
    }
    
    static public boolean enregistrerInstance(String cheminInstance, String nomInstance)
    {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet");
            final EntityManager em = emf.createEntityManager();
            try{
                final EntityTransaction et = em.getTransaction();
                try{
                    
                    et.begin();
                    InstanceReader reader = new InstanceReader(cheminInstance);
                    Instance instance = reader.readInstance();
                    instance.setNom(nomInstance);
                    System.out.println("marche");
                    
                    em.merge(instance);
                    
                    et.commit();
                    
                }catch (Exception ex) {
                    et.rollback();
                    System.err.println("rollback");
                    System.out.println(ex);
                    return false;
                }
            } finally {
                if(em != null && em.isOpen()){
                System.err.println("closeas");
                em.close();
                }
                if(emf != null && emf.isOpen()){
                emf.close();
                }
            }
        return true;
    }
    
    public static List <String> getNameInstances()
    {
        List <String> nameInstances = new ArrayList<String>();
        //final String query = "SELECT * FROM instance" ;
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Projet");
        final EntityManager em = emf.createEntityManager();
        
        
        try{
           
           Query querySent = em.createNativeQuery("SELECT NOM FROM INSTANCE");
           nameInstances = querySent.getResultList();
           
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
        return nameInstances;
    }
      
}