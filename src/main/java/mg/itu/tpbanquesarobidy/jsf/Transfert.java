/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquesarobidy.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import mg.itu.tpbanquesarobidy.entity.CompteBancaire;
import mg.itu.tpbanquesarobidy.service.GestionnaireCompte;

/**
 *
 * @author Sarobidy
 */
@Named(value = "transfert")
@RequestScoped
public class Transfert {
    private Long idSource;
    private Long idDestination;
    private int montant;

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    public Long getIdSource() {
        return idSource;
    }

    public void setIdSource(Long idSource) {
        this.idSource = idSource;
    }

    public Long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(Long idDestination) {
        this.idDestination = idDestination;
    }

    

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
    
    
    /**
     * Creates a new instance of transfert
     */
    public Transfert() {
    }
    
    public String transfertArgent(){
        CompteBancaire source=gestionnaireCompte.findByid(idSource);
        CompteBancaire destination=gestionnaireCompte.findByid(idDestination);
        gestionnaireCompte.transferer(source, destination, montant);
        return "listeComptes?faces-redirect=true";
    }
    
}
