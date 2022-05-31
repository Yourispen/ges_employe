package models;

public class Salarier extends Employe{
    private double salaire, retenue, prime;
    private Service service;

    public Salarier() {
        type=Type.Salarier;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        service.addSalarier(this);
        this.service = service;
    }

    @Override
    public double salaireNet() {
        return salaire+prime-retenue;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public double getRetenue() {
        return retenue;
    }

    public void setRetenue(double retenue) {
        this.retenue = retenue;
    }

    public double getPrime() {
        return prime;
    }

    public void setPrime(double prime) {
        this.prime = prime;
    }

    @Override
    public String toString() {
        return "Salarier "+super.toString()+ " prime=" + prime + ", retenue=" + retenue + ", salaire=" + salaire + "]";
    }
    
}
