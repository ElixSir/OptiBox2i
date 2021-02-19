/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;



import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
/**
 *
 * @author Val
 */
public class Solution {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany (mappedBy = "solution",cascade = CascadeType.PERSIST) // cascade sert à enregistrer aussi les données dans ensemble box
    private Set<Box> ensemble_box;
    private double prix;
    

    public Solution( HashSet<Box> ensemble_box, int prix) {
        
        this.ensemble_box = ensemble_box;
        this.prix = prix;      
    }
    
    public Solution ( int prix)
    {
        this();
        this.prix = prix;
    }

    public Solution() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.prix =0;
        this.ensemble_box = new HashSet<Box>();
    }

    public Solution(HashSet<Box> ensemble_box) {
    this.ensemble_box = ensemble_box;
    }
            
    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    

    public long getId() {
        return id;
    }

    public Set<Box> getEnsemble_box() {
        return ensemble_box;
    }

    public double getPrix() {
        return prix;
    }

    /**
     * Calcul le prix de la solution
     */
    public double calculPrixSolution()
    {
        double prixTotal = 0;
        for (Box box:this.ensemble_box)
        {
            prixTotal += box.getTypeBox().getPrixBox();
        }
        this.prix = prixTotal;
        return prixTotal;
    }

    @Override
    public String toString() {
        String string = "Solution{" + "ensemble_box=";
        for(Box box:ensemble_box){
            string = string + box.toString();
            for (Pile p:box.getEnsemble_pile()){
                string = string + p.toString();
            }
        } 
        string =string + ", prix=" + prix + '}';
        return string;
    }
    
    public String afficher() {
        String string = "Solution: On a besoin de " + this.getEnsemble_box().size() 
                + "  boxes avec un prix total de " + prix + "\n";
        for(Box box:ensemble_box){
            string = string + box.getTypeBox(). toString() + "\n";
            
        } 
        return string;
    }

    
}
