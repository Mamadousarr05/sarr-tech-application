package sn.sarr.repository;

import sn.sarr.domaine.Client;

import java.util.List;

public interface ClientRepository {
    public int add(Client client) ;
    public Client find(Client client) ;
    public Client findBycni(String identification);
    public List<Client> findAll() ;
    public int update(Client client) ;
    public int deleate(Long id) ;

}
