import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choix, nbreHeure;
        String libelle, adresse, nom, prenom;
        double prixJour, retenue, prime, salaire;
        models.Service serv;
        services.Service service=new services.Service();

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
                    break;
            
                default:
                    break;
            }
        } while (choix!=6);
    }
}
