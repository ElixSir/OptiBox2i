/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author felix
 */
@Entity
public class Type_Box implements Serializable{

    
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private int Lbox;
    private int Hbox;
    private double prixBox;
    
    @OneToMany
    private Set<Box> ensemble_box;

    
    
    public Type_Box() {
    this.Lbox = 0;
    this.Hbox = 0;
    this.prixBox = 0;
    HashSet<Pile> hashset = new HashSet();
    }
    
    public Type_Box(int Lbox,int Hbox,double prixBox) {
        this.Lbox = Lbox;
        this.Hbox = Hbox;
        this.prixBox = prixBox;
   
    }
    
    public Type_Box(String id,int Lbox,int Hbox,double prixBox) {
    this.id = id;
    this.Lbox = Lbox;
    this.Hbox = Hbox;
    this.prixBox = prixBox;
   
    }

    public Type_Box(int Lbox, int Hbox, double prixBox, HashSet<Box> ensemble_box) {
        this.Lbox = Lbox;
        this.Hbox = Hbox;
        this.prixBox = prixBox;
        this.ensemble_box = ensemble_box;
    }
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    

    public int getLbox() {
        return Lbox;
    }

    public int getHbox() {
        return Hbox;
    }

    public double getPrixBox() {
        return prixBox;
    }

   
    
    @Override
    public String toString() {
       
       return "modele.Type_Box [ id=" + id + " Lbox ="+ Lbox + " Hbox =" + Hbox +" PrixBox = "+ prixBox +" ]";
    }
    
}
