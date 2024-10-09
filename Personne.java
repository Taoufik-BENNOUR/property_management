public class Personne {
    private String nom;
    private String dateDeNaissance;
    private String CIN;

    public Personne(String nom, String dateDeNaissance, String CIN) {
        this.nom = nom;
        this.dateDeNaissance = dateDeNaissance;
        this.CIN = CIN;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public void afficher() {
        System.out.println("Nom: " + nom);
        System.out.println("Date de Naissance: " + dateDeNaissance);
        System.out.println("CIN: " + CIN);
    }
}
