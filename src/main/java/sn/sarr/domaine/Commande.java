package sn.sarr.domaine;

import java.util.Date;

public class Commande {
    private int id;
    private Date dateCommande;
    private boolean etat;
    private String numero;
    private Client client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
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

    public Commande(int id, Date dateCommande, boolean etat, String numero, Client client) {
        this.id = id;
        this.dateCommande = dateCommande;
        this.etat = etat;
        this.numero = numero;
        this.client = client;
    }
}
