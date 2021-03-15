package sn.sarr.domaine;

import java.util.Date;

public class Facture {
    private  int id;
    private Date dateFacture;
    private double montant;
    private String numero;
    private Client client;
    private Commande commande;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Facture(int id, Date dateFacture, double montant, String numero, Client client, Commande commande) {
        this.id = id;
        this.dateFacture = dateFacture;
        this.montant = montant;
        this.numero = numero;
        this.client = client;
        this.commande = commande;
    }
}
