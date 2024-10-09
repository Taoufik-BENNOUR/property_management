import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Habitation> habitations = new ArrayList<>();

    public static void main(String[] args) {
        int choix;

        do {
            System.out.println("\n===== Menu de Gestion des Taxes Immobilières =====");
            System.out.println("1. Ajouter une nouvelle habitation");
            System.out.println("2. Afficher toutes les habitations");
            System.out.println("3. Afficher la liste des propriétaires");
            System.out.println("4. Calculer la taxe pour une habitation");
            System.out.println("5. Quitter");
            System.out.print("Veuillez choisir une option : ");

            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    ajouterNouvelleHabitation();
                    break;
                case 2:
                    afficherToutesLesHabitations();
                    break;
                case 3:
                    afficherListeDesProprietaires();
                    break;
                case 4:
                    calculerTaxePourHabitation();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    break;
            }
        } while (choix != 5);

        scanner.close();
    }

    private static void ajouterNouvelleHabitation() {
        System.out.print("Entrez le nom du propriétaire : ");
        String nom = scanner.nextLine();

        System.out.print("Entrez la date de naissance du propriétaire (aaaa-mm-jj) : ");
        String dateDeNaissance = scanner.nextLine();

        System.out.print("Entrez le numéro CIN du propriétaire : ");
        String CIN = scanner.nextLine();

        System.out.print("Entrez l'adresse de l'habitation : ");
        String adresse = scanner.nextLine();

        System.out.print("Entrez la surface habitable de l'habitation (en mètres carrés) : ");
        double surface = scanner.nextDouble();

        System.out.print("Entrez le nombre de chambres : ");
        int nombreDeChambres = scanner.nextInt();

        System.out.print("Y a-t-il une piscine ? (true/false) : ");
        boolean aPiscine = scanner.nextBoolean();

        Personne proprietaire = new Personne(nom, dateDeNaissance, CIN);
        Habitation habitation = new Habitation(proprietaire, adresse, surface, nombreDeChambres, aPiscine);
        habitations.add(habitation);

        System.out.println("Nouvelle habitation ajoutée avec succès !");
    }

    private static void afficherToutesLesHabitations() {
        if (habitations.isEmpty()) {
            System.out.println("Aucune habitation à afficher.");
            return;
        }

        System.out.println("\nListe des habitations :");
        for (Habitation habitation : habitations) {
            habitation.afficher();
            System.out.println("---------------------------");
        }
    }

    private static void afficherListeDesProprietaires() {
        if (habitations.isEmpty()) {
            System.out.println("Il n'y a aucun propriétaire à afficher.");
            return;
        }

        System.out.println("\nListe des propriétaires :");
        for (Habitation habitation : habitations) {
            habitation.getProprietaire().afficher();
            System.out.println("------------------------------");
        }
    }

    private static void calculerTaxePourHabitation() {
        if (habitations.isEmpty()) {
            System.out.println("Aucune habitation disponible pour le calcul des taxes.");
            return;
        }

        System.out.println("Sélectionnez le numéro de l'habitation pour laquelle vous souhaitez calculer la taxe :");
        for (int i = 0; i < habitations.size(); i++) {
            System.out.println((i + 1) + ". " + habitations.get(i).getProprietaire().getNom() + " - "
                    + habitations.get(i).getAdresse());
        }

        int numeroHabitation = scanner.nextInt();
        if (numeroHabitation < 1 || numeroHabitation > habitations.size()) {
            System.out.println("Numéro d'habitation invalide.");
            return;
        }

        Habitation habitationSelectionnee = habitations.get(numeroHabitation - 1);
        double taxe = habitationSelectionnee.calculerImpot();
        System.out.println("\nLa taxe pour l'habitation de " + habitationSelectionnee.getProprietaire().getNom()
                + " est de : " + taxe + " DT");
    }
}
