package sn.sarr.domaine;

import java.util.Date;

public class Entree {
    private int id;
    private Date dateEntree;
    private int qttEntree;
    public Produit produit;

    public int getId() {
        return id;
    }

    public Entree() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public int getQttEntree() {
        return qttEntree;
    }

    public void setQttEntree(int qttEntree) {
        this.qttEntree = qttEntree;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Entree(int id, Date dateEntree, int qttEntree, Produit produit) {
        this.id = id;
        this.dateEntree = dateEntree;
        this.qttEntree = qttEntree;
        this.produit = produit;
    }
}
