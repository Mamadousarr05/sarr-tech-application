package sn.sarr.domaine;

public class DetailCommande {
    private int id;
    private  int qttCommandee;
    private Produit produit;
    private Commande commande;
    private double montant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQttCommandee() {
        return qttCommandee;
    }

    public void setQttCommandee(int qttCommandee) {
        this.qttCommandee = qttCommandee;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public DetailCommande(int id, int qttCommandee, Produit produit, Commande commande, double montant) {
        this.id = id;
        this.qttCommandee = qttCommandee;
        this.produit = produit;
        this.commande = commande;
        this.montant = montant;
    }
}
