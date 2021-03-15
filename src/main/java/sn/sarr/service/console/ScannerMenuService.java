package sn.sarr.service.console;

import sn.sarr.domaine.Entree;
import sn.sarr.domaine.Produit;
import sn.sarr.repository.EntreeRepository;
import sn.sarr.repository.ProduitRepository;
import sn.sarr.service.DisplayService;
import sn.sarr.service.MenuService;

import java.util.Scanner;

public class ScannerMenuService implements MenuService {
    private final DisplayService displayService;
    private final Scanner scanner;
    private final ProduitRepository produitRepository;
    private final EntreeRepository entreeRepository;

    public ScannerMenuService(DisplayService displayService,ProduitRepository produitRepository, EntreeRepository entreeRepository) {
        this.displayService = displayService;
        this.produitRepository = produitRepository;
        this.entreeRepository = entreeRepository;
        this.scanner = new Scanner(System.in);
    }
    private String lireChoix() {
        return scanner.next();
    }

    public void afficherMenu(String choix) {
        Produit produit=new Produit();

        Produit[] produits = produitRepository.findAll().toArray(new Produit[0]);
        if("1".equalsIgnoreCase(choix)){
            displayService.afficherListeProduit(produits);
        }
        if("2".equalsIgnoreCase(choix)){
            displayService.ajouterProduit();
            System.out.println("Ajout reussi avec succee");
        }
        if("3".equalsIgnoreCase(choix)){
            Entree[] entrees = entreeRepository.findAll().toArray(new Entree[0]);
            displayService.afficherlesEntree(entrees);
        }
        if("3".equalsIgnoreCase(choix)){
            displayService.ajouterEntre();
        }
        //afficher le menu inconnu
        else {
            displayService.afficherOptionInconnue();
        }
    }

    public void afficherMenu() {
        String choix = lireChoix();
        afficherMenu(choix );
    }

}
