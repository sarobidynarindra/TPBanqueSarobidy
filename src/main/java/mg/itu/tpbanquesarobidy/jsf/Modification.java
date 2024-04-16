/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquesarobidy.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import mg.itu.tpbanquesarobidy.entity.CompteBancaire;
import mg.itu.tpbanquesarobidy.jsf.util.Util;
import mg.itu.tpbanquesarobidy.service.GestionnaireCompte;

/**
 *
 * @author Sarobidy
 */
@Named(value = "modification")
@ViewScoped
public class Modification implements Serializable {
    
    private Long id;
    private CompteBancaire comptebancaire;
    private String ancienNom;
    
    @Inject
    private GestionnaireCompte gestionnaireCompte;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteBancaire getComptebancaire() {
        return comptebancaire;
    }

    
    public void loadCompte() {
        this.comptebancaire = gestionnaireCompte.getCompte(id);
        ancienNom=comptebancaire.getNom();
    }
    
    public String update(){
        comptebancaire=gestionnaireCompte.update(comptebancaire);
         Util.addFlashInfoMessage("Nom " + ancienNom + " changé en " + comptebancaire.getNom());
         return "listeComptes?faces-redirect=true";
    }
}
