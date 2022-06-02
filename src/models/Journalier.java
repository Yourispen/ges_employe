package models;

public class Journalier extends Employe{
    private double prixJour, taxe;
    private int nbreHeure;
    public static final double PER=0.05;
    public Journalier(String nom, String prenom, double prixJour, int nbreHeure) {
        super(nom, prenom);
        this.prixJour = prixJour;
        this.nbreHeure = nbreHeure;
        type=Type.Journalier;
    }
    public Journalier() {
        type=Type.Journalier;
    }
    public double getPrixJour() {
        return prixJour;
    }
    public void setPrixJour(double prixJour) {
        this.prixJour = prixJour;
    }
    public double getTaxe() {
        taxe = sBrut()*PER;
        return taxe;
    }
    
    public int getNbreHeure() {
        return nbreHeure;
    }
    public void setNbreHeure(int nbreHeure) {
        this.nbreHeure = nbreHeure;
    }
    private double sBrut(){
        return prixJour*nbreHeure;
    }
    @Override
    public double salaireNet() {
        return sBrut() - taxe;
    }
    @Override
    public String toString() {
        return "Journalier " + super.toString()+ " nbreHeure=" + nbreHeure + ", prixJour=" + prixJour + ", taxe=" + taxe + "]";
    }
}
