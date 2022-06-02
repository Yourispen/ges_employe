package services;

import models.Employe;

public interface IService {
    void creerService(models.Service service);
    void listerService();
    void ajouterEmploye(Employe employe);
    models.Service rechercheService(int id);
    models.Service rechercheService(models.Service service);
    void listerEmployerMoinsPayeDeChaqueService();
}
