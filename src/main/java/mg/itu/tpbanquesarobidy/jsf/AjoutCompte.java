/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquesarobidy.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.constraints.PositiveOrZero;
import mg.itu.tpbanquesarobidy.entity.CompteBancaire;
import mg.itu.tpbanquesarobidy.jsf.util.Util;
import mg.itu.tpbanquesarobidy.service.GestionnaireCompte;

/**
 *
 * @author Sarobidy
 */
@Named(value = "ajoutCompte")
@RequestScoped
public class AjoutCompte {
    private String nom;
    
    @PositiveOrZero
    private int solde;
    
    @Inject
    private GestionnaireCompte gestionnaireCompte;
    /**
     * Creates a new instance of AjoutCompte
     */
    
    public AjoutCompte() {
        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }
    
    public String creerCompte(){
        CompteBancaire nouveau= new CompteBancaire(nom,solde);
        gestionnaireCompte.creerCompte(nouveau);
        Util.addFlashInfoMessage("Le compte a été créé avec succès");
        return "listeComptes?faces-redirect=true";
    }
    
    
    
}
