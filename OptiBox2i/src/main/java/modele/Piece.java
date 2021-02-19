/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
/**
 *
 * @author Val
 */
public class Piece {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne (cascade = CascadeType.PERSIST)
    private Produit produit;

    public Piece(long id, Produit produit) {
        this.id=id;
        this.produit = produit;
    }

    public Piece() {
    }

    public Produit getProduit() {
        return produit;
    }
    
    
    
    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Piece{" + "id=" + id + '}';
    }

    
    
    
    
}
