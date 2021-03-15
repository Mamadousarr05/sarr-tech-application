package sn.sarr.repository.jdbc;

import sn.sarr.domaine.Facture;
import sn.sarr.repository.FactureRepository;

import java.sql.ResultSet;
import java.util.List;

public class jdbcBaseFactureRepository implements FactureRepository {
    private MysqlDataSource db=new MysqlDataSource();
    private ResultSet rs;
    private int ok;
    @Override
    public int add(Facture facture) {
        return ok;
    }

    @Override
    public Facture find(Facture facture) {
        return null;
    }

    @Override
    public Facture findByville(String numero) {
        return null;
    }

    @Override
    public List<Facture> findAll() {
        return null;
    }

    @Override
    public int update(Facture facture) {
        return 0;
    }

    @Override
    public int deleate(Long id) {
        return 0;
    }
}
