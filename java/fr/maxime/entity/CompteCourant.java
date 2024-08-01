package fr.maxime.entity;

import fr.maxime.abstraites.CompteBancaire;
import fr.maxime.enums.StatusOperation;


public class CompteCourant extends CompteBancaire {
    private double decouvertAutorise;

    public CompteCourant(Client client, double soldeInitial, double decouvertAutorise) {
        super(client, soldeInitial);
        this.decouvertAutorise = decouvertAutorise;
    }

    public double getDecouvertAutorise() {
        return decouvertAutorise;
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
        if (montant > 0 && solde - montant >= -decouvertAutorise) {
            solde -= montant;
            operations.add(new Operation(montant, StatusOperation.RETRAIT));
        } else {
            System.out.println("Retrait invalide.");
        }
    }

    @Override
    public void afficherInfos() {
        System.out.println("Compte Courant de " + client.getNom() + " " + client.getPrenom());
        System.out.println("Solde: " + solde + " euros");
        System.out.println("Découvert autorisé: " + decouvertAutorise + " euros");
        System.out.println("Opérations: " + operations);
    }
}

