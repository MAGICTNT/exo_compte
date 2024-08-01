package fr.maxime.abstraites;

import fr.maxime.entity.Client;
import fr.maxime.entity.Operation;
import fr.maxime.enums.StatusOperation;

import java.util.ArrayList;
import java.util.List;

abstract public class CompteBancaire {
    protected double solde;
    protected Client client;
    protected List<Operation> operations;

    public CompteBancaire(Client client, double soldeInitial) {
        this.client = client;
        this.solde = soldeInitial;
        this.operations = new ArrayList<>();
    }

    public double getSolde() {
        return solde;
    }

    public Client getClient() {
        return client;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public abstract void deposer(double montant);

    public abstract void retirer(double montant);

    public abstract void afficherInfos();
}
