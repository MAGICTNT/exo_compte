package fr.maxime.entity;

import fr.maxime.abstraites.CompteBancaire;
import fr.maxime.entity.Client;
import fr.maxime.enums.StatusOperation;

public class CompteEpargne extends CompteBancaire {
    private double tauxInteret;

    public CompteEpargne(Client client, double soldeInitial, double tauxInteret) {
        super(client, soldeInitial);
        this.tauxInteret = tauxInteret;
    }
    public double getTauxInteret() {
        return tauxInteret;
    }

    @Override
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            operations.add(new Operation(montant, StatusOperation.DEPOT));
        } else {
            System.out.println("Le montant à déposer doit être positif.");
        }
    }

    @Override
    public void retirer(double montant) {
        if (montant > 0 && solde >= montant) {
            solde -= montant;
            operations.add(new Operation(montant, StatusOperation.RETRAIT));
        } else {
            System.out.println("Retrait invalide.");
        }
    }

    @Override
    public void afficherInfos() {
        System.out.println("Compte Epargne de " + getClient());
        System.out.println("Solde: " + solde + " euros");
        System.out.println("Taux d'intérêt: " + tauxInteret + "%");
        System.out.println("Opérations: " + operations);
    }
}

