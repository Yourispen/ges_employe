import java.util.ArrayList;
import java.util.Scanner;

import models.Employe;
import models.Journalier;
import models.Salarier;

public class App {
    static Scanner sc = new Scanner(System.in);
    static services.Service service=new services.Service();

    
    public static models.Service getService(){
        System.out.println("Saisir l'id du service :");
        int id = sc.nextInt();
        return service.rechercheService(id);
    }
    public static void main(String[] args) throws Exception {
        int choix, nbreHeure, type;
        String libelle, adresse, nom, prenom;
        double prixJour, retenue, prime, salaire;
        models.Service serv;
        Employe employe;

        do {
            System.out.println("1-Créer un service");
            System.out.println("2-Lister tous les service");
            System.out.println("3-Créer un employe");
            System.out.println("4-Lister les employes d'un service");
            System.out.println("5-Lister l'employe le moins de chaque service ");
            System.out.println("6-Quitter");
            System.out.println("Choisissez une option : ");
            choix=sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                        System.out.println("Saisir le libelle :");
                        libelle=sc.nextLine();
                        System.out.println("Saisir l'adresse :");
                        adresse=sc.nextLine();
                        serv = new models.Service();
                        serv.setLibelle(libelle);
                        serv.setAdresse(adresse);
                        service.creerService(serv);
                    break;
                case 2:
                        service.listerService();
                    break;
                case 3:
                        System.out.println("Saisir le nom de l'employe :");
                        nom=sc.nextLine();
                        System.out.println("Saisir le prenom de l'employe :");
                        prenom=sc.nextLine();
                        do {
                            System.out.println("1-Journalier\n2-Salarier");
                            type=sc.nextInt();
                        } while (type<1 || type>2);
                        if(type==1){
                            System.out.println("Saisir le prix du jour :");
                            prixJour = sc.nextDouble();
                            System.out.println("Saisir le nombre d'heures :");
                            nbreHeure = sc.nextInt();
                            employe = new Journalier(nom,prenom,prixJour,nbreHeure);
                            //((Journalier)employe).setPrixJour(prixJour);
                            //((Journalier)employe).setNbreHeure(nbreHeure);

                        }
                        else{
                            System.out.println("Saisir le salaire :");
                            salaire = sc.nextDouble();
                            System.out.println("Saisir la prime :");
                            prime = sc.nextDouble();
                            System.out.println("Saisir la retenue :");
                            retenue = sc.nextDouble();
                            employe = new Salarier(nom,prenom,salaire,retenue,prime);
                            serv = getService();
                            if(serv!=null){
                                ((Salarier)employe).setService(serv);
                            }
                            else{
                                System.out.println("Ce service n'existe pas.");
                            }
                            service.ajouterEmploye(employe);
                        }
                    break;
                    case 4:
                            serv = getService();
                            if(serv!=null){
                                ArrayList<Salarier> salariers = serv.getSalariers();
                                for (Salarier salarier : salariers) {
                                    System.out.println(salarier);
                                }
                            }
                            else{
                                System.out.println("Ce service n'existe pas.");
                            }
                        break;
                    case 5:
                            service.listerEmployerMoinsPayeDeChaqueService();
                        break;
            
            }
        } while (choix!=6);
    }
}
