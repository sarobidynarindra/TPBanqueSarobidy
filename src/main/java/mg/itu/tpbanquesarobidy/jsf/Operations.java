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
    private CompteBancaire compteBancaire;
    private List<OperationBancaire> operationBancaires;
    
    @Inject
    private GestionnaireCompte gestionnaireCompte;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteBancaire getCompteBancaire() {
        return compteBancaire;
    }
    
    public List<OperationBancaire> getOperationBancaires() {
        return operationBancaires;
    }
    
    public void loadCompte(){
        this.compteBancaire= gestionnaireCompte.getCompte(id);
        this.operationBancaires=compteBancaire.getOperations();
    }
    
    /**
     * Creates a new instance of Operations
     */
    public Operations() {
    }
    
}
