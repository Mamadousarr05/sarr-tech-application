package sn.sarr.domaine;

public class Produit {
    private  int id;
    private  String description;
    private int qttEnStock;
    private double prixMin;
    private double prixUnitaire;

    public int getId() {
        return id;
    }

    public Produit() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQttEnStock() {
        return qttEnStock;
    }

    public void setQttEnStock(int qttEnStock) {
        this.qttEnStock = qttEnStock;
    }

    public double getPrixMin() {
        return prixMin;
    }

    public void setPrixMin(double prixMin) {
        this.prixMin = prixMin;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Produit(int id, String description, int qttEnStock, double prixMin, double prixUnitaire) {
        this.id = id;
        this.description = description;
        this.qttEnStock = qttEnStock;
        this.prixMin = prixMin;
        this.prixUnitaire = prixUnitaire;
    }
}
