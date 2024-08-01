package fr.maxime.entity;

import fr.maxime.enums.StatusOperation;

public class Operation {
    private static int compteur = 0;
    private int numero;
    private double montant;
    private StatusOperation status;

    public Operation(double montant, StatusOperation status) {
        this.numero = ++compteur;
        this.montant = montant;
        this.status = status;
    }

    public int getNumero() {
        return numero;
    }

    public double getMontant() {
        return montant;
    }

    public StatusOperation getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "numero=" + numero +
                ", montant=" + montant +
                ", status=" + status +
                '}';
    }
}