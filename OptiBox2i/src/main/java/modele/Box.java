/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




/**
 *
 * @author Val
 */
@Entity
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
   @ManyToOne (cascade = CascadeType.PERSIST)
   private Type_Box typeBox;
   public Set<Pile> ensemble_pile;
    

public Box( ) {
       
        this.typeBox =new Type_Box();
        this.ensemble_pile = new HashSet<Pile>();
    }
    public Box( Type_Box typeBox, HashSet<Pile> pile) {
       
        this.typeBox = typeBox;
        this.ensemble_pile = pile;
    }
    
    public Box(int Lbox, int Hbox, double prixBox ) {
       this();
        this.typeBox = new Type_Box(Lbox,Hbox,prixBox);
    }

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name="solution")
    public Solution solution;
    
 
    public int getLrestante(){
        int L = 0;
        for (Pile pile:this.getEnsemble_pile()){
            L = L + pile.getLPileBase();
        }
        int L1 = this.getTypeBox().getLbox() - L;
        return L1;
    }

    public Set<Pile> getEnsemble_pile() {
        return ensemble_pile;
    }

    public Type_Box getTypeBox() {
        return typeBox;
    }

    @Override
    public String toString() {
        return "Box{" + "id=" + this.getTypeBox().getId() + ", longueur=" + this.getTypeBox().getLbox() + ", hauteur=" + this.getTypeBox().getHbox() + ", prix=" + this.getTypeBox().getPrixBox() + "\n" + this.getEnsemble_pile().size() + "   piles";
    }

 

    public void setEnsemble_pile(HashSet<Pile> ensemble_pile) {
        this.ensemble_pile = ensemble_pile;
    }
    
    public void addPile(Pile pile){
        this.ensemble_pile.add(pile);
    }
}