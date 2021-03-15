package sn.sarr.service;

import sn.sarr.domaine.Entree;
import sn.sarr.domaine.Produit;

public interface DisplayService {
    void afficherBienvenu();

    void afficherMenuPrincipal();

    void afficherListeProduit(Produit[] produits);

    void afficherlesEntree(Entree[] entrees);

    void ajouterProduit();

    void ajouterEntre();

    void afficherOptionInconnue();
}
