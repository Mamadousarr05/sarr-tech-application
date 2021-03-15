package sn.sarr.repository;

import sn.sarr.domaine.Facture;

import java.rmi.RemoteException;
import java.util.List;

public interface FactureRepository {
    public int add(Facture facture) ;
    public Facture find(Facture facture) ;
    public Facture findByville(String numero) ;
    public List<Facture> findAll() ;
    public int update(Facture facture);
    public int deleate(Long id) ;

}
