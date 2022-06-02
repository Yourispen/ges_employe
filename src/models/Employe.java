package models;

public abstract class Employe {
    protected int id;
    protected String nom, prenom;
    protected Type type;
    private static int nbEmploye;
    public Employe(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        id=++nbEmploye;
    }
    public Employe() {
        id=++nbEmploye;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Type getType() {
        return type;
    }
    @Override
    public String toString() {
        return " [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", type=" + type ;
    }
    public abstract double salaireNet();
   
}
