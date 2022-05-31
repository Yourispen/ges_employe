package services;

import java.util.ArrayList;

import models.Employe;
import models.Salarier;
import models.Type;

public class Service implements IService{
    ArrayList<models.Service> services = new ArrayList<>();
    ArrayList<Employe> employes = new ArrayList<>();

    @Override
    public void creerService(models.Service service) {
        services.add(service);
        
    }

    @Override
    public void listerService() {
        for (models.Service service : services) {
            System.out.println(service.toString());
        }
        
    }

    @Override
    public void ajouterEmploye(Employe employe, models.Service service) {
        if(employe.getType()==Type.Salarier){
            ((Salarier)employe).setService(service);
        }
        employes.add(employe);
        
    }


    @Override
    public void listerEmployerMoinsPayeDeChaqueService() {
        for (models.Service service : services) {
            System.out.println(service.employeMoinsPayeDuService());
        }
        
    }

    @Override
    public models.Service rechercheService(int id) {
        for (models.Service service : services) {
            if(service.getId()==id){
                return service;
            }
        }
        return null;
    }

    @Override
    public models.Service rechercheService(models.Service service) {
        for (models.Service serv : services) {
            if(serv.equals(service)){
                return serv;
            }
        }
        return null;
    }

  
}
