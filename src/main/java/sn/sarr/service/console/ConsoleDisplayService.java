package sn.sarr.service.console;

import sn.sarr.domaine.Entree;
import sn.sarr.domaine.Produit;
import sn.sarr.repository.ProduitRepository;
import sn.sarr.repository.jdbc.DataSource;
import sn.sarr.repository.jdbc.MysqlDataSource;
import sn.sarr.repository.jdbc.jdbcBaseProduitRepository;
import sn.sarr.service.DisplayService;

import java.util.Scanner;

public class ConsoleDisplayService implements DisplayService {

    @Override
    public void afficherBienvenu() {
        System.out.println("Bienvenu sur notre plateforme de vente pour produit informatique !");
    }

    @Override
    public void afficherMenuPrincipal() {
        System.out.println("> -------------------------- ");
        System.out.println("> 1 pour lister les produits disponibles ");
        System.out.println("> #################### ");
        System.out.println("> 2 pour ajouter des produit ");
        System.out.println("> #################### ");
        System.out.println("> 3 pour lister les entrees  ");
        System.out.println("> #################### ");
        System.out.println("> 4 pour ajouter un entree ");
        System.out.println("> -------------------------- ");

    }

    @Override
    public void afficherListeProduit(Produit[] produits) {
        System.out.println("Les Produit disponibles sont:");
        for (int i = 0; i < produits.length; i++) {
            Produit produit = produits[i];
            System.out.println(String.format(">Identifient %s Description %s  Quantite %s  PrixMin %s  PrixNormal %s ", produit.getId(), produit.getDescription(),produit.getQttEnStock(),produit.getPrixMin(),produit.getPrixUnitaire()));
        }
    }

    @Override
    public void afficherlesEntree(Entree[] entrees) {
        System.out.println("La liste des Entrees  :");
        for (int i = 0; i < entrees.length; i++) {
            Entree entree = entrees[i];
            System.out.println(String.format("> %s %s %s %s", entree.getId(), entree.getDateEntree(), entree.getQttEntree(),entree.getProduit()));
        }

    }

    @Override
    public void ajouterProduit() {
        DataSource dataSource = new MysqlDataSource();
        ProduitRepository produitRepository = new jdbcBaseProduitRepository(dataSource);
        Scanner sc=new Scanner(System.in);
        Produit produit=new Produit();
        System.out.println("entrer la description");
        produit.setDescription(sc.next());
        System.out.println("entre la quantiter");
        produit.setQttEnStock(sc.nextInt());
        System.out.println("prix minimum");
        produit.setPrixMin(sc.nextInt());
        System.out.println("prix Unitaire");
        produit.setPrixUnitaire(sc.nextInt());
        produitRepository.add(produit);

    }

    @Override
    public void ajouterEntre() {

    }

    @Override
    public void afficherOptionInconnue() {
        System.out.println("Choix inconnu");
    }
}
