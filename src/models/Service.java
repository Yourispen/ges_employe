package models;

import java.util.ArrayList;

public class Service {
    private int id;
    private String libelle, adresse;
    private static int nbService;
    private ArrayList<Salarier> salariers =  new ArrayList<>();

    public Service() {
        id = ++nbService;
    }
    public ArrayList<Salarier> getSalariers() {
        return salariers;
    }
    
    public int getId() {
        return id;
    }
    
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    @Override
    public String toString() {
        return "Service [adresse=" + adresse + ", id=" + id + ", libelle=" + libelle +"]";
    }
    @Override
    public boolean equals(Object obj) {
        return id == ((Service)obj).getId();  
    }
    public void addSalarier(Salarier salarier){
        //salarier.setService(this);
        salariers.add(salarier);
    }
    public Salarier employeMoinsPayeDuService(){
        if(salariers.size()==0)return null;
        Salarier salarierMin = salariers.get(0);
        for (Salarier salarier : salariers) {
            if(salarierMin.salaireNet()>salarier.salaireNet()){
                salarierMin = salarier;
            }
        }
        return salarierMin;
        
    }
    
}
