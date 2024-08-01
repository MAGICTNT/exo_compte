package fr.maxime.entity;

import fr.maxime.abstraites.CompteBancaire;
import fr.maxime.enums.StatusOperation;

public class ComptePayant extends CompteBancaire {
    private double fraisOperation;

    public ComptePayant(Client client, double soldeInitial, double fraisOperation) {
        super(client, soldeInitial);
        this.fraisOperation = fraisOperation;
    }

    @Override
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant - fraisOperation;
            operations.add(new Operation(montant - fraisOperation, StatusOperation.DEPOT));
        } else {
            System.out.println("Le montant à déposer doit être positif.");
        }
    }

    @Override
    public void retirer(double montant) {
        if (montant > 0 && (solde - montant - fraisOperation) >= 0) {
            solde -= montant + fraisOperation;
            operations.add(new Operation(montant + fraisOperation, StatusOperation.RETRAIT));
        } else {
            System.out.println("Retrait invalide.");
        }
    }

    @Override
    public void afficherInfos() {
        System.out.println("Compte Payant de " + getClient());
        System.out.println("Solde: " + getSolde() + " euros");
        System.out.println("Frais par opération: " + fraisOperation + " euros");
        System.out.println("Opérations: ");
        for (Operation operation : getOperations()) {
            System.out.println(operation);
        }
    }
}
