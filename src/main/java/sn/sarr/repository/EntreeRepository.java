package sn.sarr.repository;

import sn.sarr.domaine.Entree;

import java.rmi.RemoteException;
import java.util.List;

public interface EntreeRepository {
    public int add(Entree entree) ;
    public Entree find(Entree entree) ;
    public Entree findByville(float qttEntree) ;
    public List<Entree> findAll() ;
    public int update(Entree entree);
    public int deleate(Long id) ;

}
