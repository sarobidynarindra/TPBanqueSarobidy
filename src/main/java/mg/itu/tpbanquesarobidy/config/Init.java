/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpbanquesarobidy.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import mg.itu.tpbanquesarobidy.entity.CompteBancaire;
import mg.itu.tpbanquesarobidy.service.GestionnaireCompte;

/**
 *
 * @author Sarobidy
 */
public class Init {

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    public void init(
            @Observes
            @Initialized(ApplicationScoped.class) ServletContext context) {
        if (gestionnaireCompte.nbComptes() == 0) {
            gestionnaireCompte.creerCompte(new CompteBancaire("John Lennon", 150000));
            gestionnaireCompte.creerCompte(new CompteBancaire("Paul McCartney", 950000));
            gestionnaireCompte.creerCompte(new CompteBancaire("Ringo Starr", 20000));
            gestionnaireCompte.creerCompte(new CompteBancaire("Georges Harrisson", 100000));
        }
    }
}
