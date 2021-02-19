/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



/**
 *
 * @author felix
 */
@Entity
public class Pile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public List<Piece> liste_piece;

    public Pile(ArrayList<Piece> liste_piece) {
        this.liste_piece = liste_piece;
    }

    public Pile() {
        liste_piece=new ArrayList<Piece>();;
    }

    
    
    public Long getId() {
        return id;
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
        if (!(object instanceof Pile)) {
            return false;
        }
        Pile other = (Pile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    //calculer la hauteur de la pile afin de la placer dans une boxe
    public int getHPile(){
        int h = 0;
        for(Piece p:this.liste_piece){
            h+=p.getProduit().getHprod();
        }
        return h;
    }
    
    public int getLPileBase(){
        int L = this.liste_piece.get(0).getProduit().getLprod();
        for(Piece p:this.liste_piece){
            if (p.getProduit().getLprod() > L){
                L=p.getProduit().getLprod();
            }
        }
        return L;
    }
    
    public int getLPileSommet(){
        int L = this.liste_piece.get(0).getProduit().getLprod();
        for(Piece p:this.liste_piece){
            if (p.getProduit().getLprod() < L){
                L=p.getProduit().getLprod();
            }
        }
        return L;
    }
    
    public void addPiece(Piece piece){
        this.liste_piece.add(piece);
    }
    
    @Override
    public String toString() {
        String string = "\n\t\tpieces:\n";
        for(Piece p:this.liste_piece){
            string = string + "\t\t\t" + p.getProduit().toStringSimpl() + "\n";
        }
        return string ;
    }
}
