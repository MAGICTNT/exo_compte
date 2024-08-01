package fr.maxime.entity;

import fr.maxime.abstraites.CompteBancaire;

import java.util.ArrayList;
import java.util.List;


public class Client {
    private String nom;
    private String prenom;
    private String identifiant;
    private List<CompteBancaire> comptes;
    private String numeroTelephone;

    public Client(String nom, String prenom, String identifiant, String numeroTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.numeroTelephone = numeroTelephone;
        this.comptes = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public List<CompteBancaire> getComptes() {
        return comptes;
    }

    public void ajouterCompte(CompteBancaire compte) {
        comptes.add(compte);
    }
}

