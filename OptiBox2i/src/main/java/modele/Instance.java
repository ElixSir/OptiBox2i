/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author felix
 */
@Table
@Entity
public class Instance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Type_Box> ensemble_type_box;
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Produit> ensemble_produit;

    public Instance(String nom, HashSet<Type_Box> ensemble_type_box, HashSet<Produit> ensemble_produit) {
        this.nom = nom;
        this.ensemble_type_box = ensemble_type_box;
        this.ensemble_produit = ensemble_produit;
    }

    
    
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    
public void display ()
{
    for (Type_Box Typeo : ensemble_type_box )
    {
           System.out.println(Typeo.toString());
    }
      for (Produit p : ensemble_produit )
    {
           System.out.println(p.toString());
    }
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
        if (!(object instanceof Instance)) {
            return false;
        }
        Instance other = (Instance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Instance{" + "nom=" + nom + ", ensemble_type_box=" + ensemble_type_box + ", ensemble_produit=" + ensemble_produit + '}';
    }
    
    
    
    
    
     public Instance() {
        this.nom = "Instance";
        this.ensemble_type_box = new HashSet<>();
        this.ensemble_produit = new HashSet<>();
    }
     
    public Instance(String nom) {
        this();
        if ( nom != null)
        this.nom = nom;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    

    

    public Set<Produit> getEnsemble_produit() {
        return ensemble_produit;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    

    public void setEnsemble_produit(HashSet<Produit> ensemble_produit) {
        this.ensemble_produit = ensemble_produit;
    }

    public Set<Type_Box> getEnsemble_type_box() {
        return ensemble_type_box;
    }
    
    
    
    public void addProd (Produit prod){
        this.ensemble_produit.add(prod);
    }
   public void addTypeBox (Type_Box box){
       this.ensemble_type_box.add(box);
   }
   
}

