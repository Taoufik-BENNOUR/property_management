public class Habitation {
    private Personne proprietaire;
    private String adresse;
    private double surface;
    private int nombreDeChambres;
    private boolean aPiscine;

    public Habitation(Personne proprietaire, String adresse, double surface, int nombreDeChambres, boolean aPiscine) {
        this.proprietaire = proprietaire;
        this.adresse = adresse;
        this.surface = surface;
        this.nombreDeChambres = nombreDeChambres;
        this.aPiscine = aPiscine;
    }

    public Personne getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Personne proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public int getNombreDeChambres() {
        return nombreDeChambres;
    }

    public void setNombreDeChambres(int nombreDeChambres) {
        this.nombreDeChambres = nombreDeChambres;
    }

    public boolean aPiscine() {
        return aPiscine;
    }

    public void setPiscine(boolean aPiscine) {
        this.aPiscine = aPiscine;
    }

    public void afficher() {
        System.out.println("Informations du Propriétaire: ");
        proprietaire.afficher();
        System.out.println("Adresse: " + adresse);
        System.out.println("Surface (en mètres carrés): " + surface);
        System.out.println("Nombre de Chambres: " + nombreDeChambres);
        System.out.println("Possède une Piscine: " + (aPiscine ? "Oui" : "Non"));
    }

    public double calculerImpot() {
        double impot = surface * 1.5; // Taxe de base
        impot += nombreDeChambres * 50; // Taxe par chambre
        if (aPiscine) {
            impot += 250; // Taxe pour piscine
        }
        return impot;
    }
}
