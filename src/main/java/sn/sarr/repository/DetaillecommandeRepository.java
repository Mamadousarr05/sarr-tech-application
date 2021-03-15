package sn.sarr.repository;

import sn.sarr.domaine.Commande;
import sn.sarr.domaine.DetailCommande;

import java.rmi.RemoteException;
import java.util.List;

public interface DetaillecommandeRepository {
    public int add(DetailCommande detailCommande);
    public DetailCommande find(Commande commande);
    public DetailCommande findByville(String qttCommende) ;
    public List<DetailCommande> findAll() ;
    public List<DetailCommande> findtout() ;
    public int update(DetailCommande detailCommande) ;
    public int deleate(Long id) ;

}
