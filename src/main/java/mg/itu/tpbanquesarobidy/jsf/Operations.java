/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpbanquesarobidy.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import mg.itu.tpbanquesarobidy.entity.CompteBancaire;
import mg.itu.tpbanquesarobidy.entity.OperationBancaire;
import mg.itu.tpbanquesarobidy.service.GestionnaireCompte;

/**
 *
 * @author Sarobidy
 */
@Named(value = "operations")
@ViewScoped
public class Operations implements Serializable {
    
    private Long id;
    private CompteBancaire comptebancaire;
    private List<OperationBancaire> operationbancaire;
    
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
    
    public List<OperationBancaire> getOperationbancaire() {
        return operationbancaire;
    }
    
    public void loadCompte(){
        this.comptebancaire= gestionnaireCompte.getCompte(id);
        this.operationbancaire=comptebancaire.getOperations();
    }
    
    /**
     * Creates a new instance of Operations
     */
    public Operations() {
    }
    
}
