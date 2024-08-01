package fr.maxime;

import fr.maxime.abstraites.CompteBancaire;
import fr.maxime.entity.Client;
import fr.maxime.entity.CompteCourant;
import fr.maxime.entity.CompteEpargne;
import fr.maxime.entity.ComptePayant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<CompteBancaire> comptes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Client client = new Client("Doe", "John", "001", "0123456789");

    public static void main(String[] args) {
        while (true) {
            afficherMenuPrincipal();
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    listerComptes();
                    break;
                case 2:
                    creerCompte();
                    break;
                case 3:
                    effectuerDepot();
                    break;
                case 4:
                    effectuerRetrait();
                    break;
                case 5:
                    afficherOperationsEtSolde();
                    break;
                case 0:
                    System.out.println("Au revoir!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    private static void afficherMenuPrincipal() {
        System.out.println("== Menu Principal ==");
        System.out.println("1. Lister les comptes bancaires");
        System.out.println("2. Créer un compte bancaire");
        System.out.println("3. Effectuer un dépôt");
        System.out.println("4. Effectuer un retrait");
        System.out.println("5. Afficher les opérations et le solde");
        System.out.println("0. Quitter le programme");
        System.out.print("Votre choix: ");
    }

    private static void listerComptes() {
        System.out.println("== Liste des Comptes ==");
        for (CompteBancaire compte : comptes) {
            compte.afficherInfos();
            System.out.println();
        }
    }

    private static void creerCompte() {
        System.out.println("== Création de Compte ==");
        System.out.println("1. Créer un compte courant");
        System.out.println("2. Créer un compte épargne");
        System.out.println("3. Créer un compte payant");
        System.out.println("0. Annuler la création de compte");
        System.out.print("Votre choix: ");
        int choix = scanner.nextInt();
        scanner.nextLine(); 

        switch (choix) {
            case 1:
                creerCompteCourant();
                break;
            case 2:
                creerCompteEpargne();
                break;
            case 3:
                creerComptePayant();
                break;
            case 0:
                System.out.println("Annulation de la création de compte.");
                break;
            default:
                System.out.println("Choix invalide.");
        }
    }

    private static void creerCompteCourant() {
        System.out.print("Solde initial: ");
        double soldeInitial = scanner.nextDouble();
        System.out.print("Découvert autorisé: ");
        double decouvertAutorise = scanner.nextDouble();
        scanner.nextLine(); 
        CompteCourant compte = new CompteCourant(client, soldeInitial, decouvertAutorise);
        comptes.add(compte);
        System.out.println("Compte courant créé avec succès.");
    }

    private static void creerCompteEpargne() {
        System.out.print("Solde initial: ");
        double soldeInitial = scanner.nextDouble();
        System.out.print("Taux d'intérêt: ");
        double tauxInteret = scanner.nextDouble();
        scanner.nextLine(); 
        CompteEpargne compte = new CompteEpargne(client, soldeInitial, tauxInteret);
        comptes.add(compte);
        System.out.println("Compte épargne créé avec succès.");
    }

    private static void creerComptePayant() {
        System.out.print("Solde initial: ");
        double soldeInitial = scanner.nextDouble();
        System.out.print("Frais par opération: ");
        double fraisOperation = scanner.nextDouble();
        scanner.nextLine(); 
        ComptePayant compte = new ComptePayant(client, soldeInitial, fraisOperation);
        comptes.add(compte);
        System.out.println("Compte payant créé avec succès.");
    }

    private static void effectuerDepot() {
        System.out.print("Numéro du compte: ");
        int numeroCompte = scanner.nextInt();
        System.out.print("Montant à déposer: ");
        double montant = scanner.nextDouble();
        scanner.nextLine(); 

        if (numeroCompte >= 0 && numeroCompte < comptes.size()) {
            comptes.get(numeroCompte).deposer(montant);
            System.out.println("Dépôt effectué avec succès.");
        } else {
            System.out.println("Numéro de compte invalide.");
        }
    }

    private static void effectuerRetrait() {
        System.out.print("Numéro du compte: ");
        int numeroCompte = scanner.nextInt();
        System.out.print("Montant à retirer: ");
        double montant = scanner.nextDouble();
        scanner.nextLine(); 

        if (numeroCompte >= 0 && numeroCompte < comptes.size()) {
            comptes.get(numeroCompte).retirer(montant);
            System.out.println("Retrait effectué avec succès.");
        } else {
            System.out.println("Numéro de compte invalide.");
        }
    }

    private static void afficherOperationsEtSolde() {
        System.out.print("Numéro du compte: ");
        int numeroCompte = scanner.nextInt();
        scanner.nextLine(); 

        if (numeroCompte >= 0 && numeroCompte < comptes.size()) {
            comptes.get(numeroCompte).afficherInfos();
        } else {
            System.out.println("Numéro de compte invalide.");
        }
    }
}