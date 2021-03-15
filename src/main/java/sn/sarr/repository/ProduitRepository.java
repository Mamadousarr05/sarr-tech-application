package sn.sarr.repository;

import sn.sarr.domaine.Produit;

import java.rmi.RemoteException;
import java.util.List;

public interface ProduitRepository {
    public Produit add(Produit produit) ;
    public Produit find(Produit produit) ;
    public Produit findDescript(String description);
    public Produit findByid(int id) ;
    public Produit findByqttt(int qttEnStock) ;

    public List<Produit> findAll() ;
    public int update(Produit produit) ;
    public int deleate(Long id);
}
