package sn.sarr.repository;

import sn.sarr.domaine.Commande;

import java.rmi.RemoteException;
import java.util.List;

public interface CommandeRepository {
    public int add(Commande commande) ;
    public Commande find(Commande commande);
    public Commande findByville(String numero) ;
    public List<Commande> findAll() ;
    public int update(Commande commande) ;
    public int deleate(Long id) ;

}
