package sn.sarr.repository.jdbc;

import sn.sarr.domaine.Client;
import sn.sarr.domaine.Entree;
import sn.sarr.domaine.Produit;
import sn.sarr.domaine.TypeClient;
import sn.sarr.repository.EntreeRepository;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class jdbcBaseEntreeRepository implements EntreeRepository {
    private MysqlDataSource db=new MysqlDataSource();
    private ResultSet rs;
    private int ok;
    @Override
    public int add(Entree entree) {
        String sql="INSERT INTO Entree VALUES (NULL,?,?,?,?)";
        try {
            db.initPrepar(sql);
             SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
            db.getPstm().setString(1,sdf.format(entree.getDateEntree()));
            db.getPstm().setInt(2,entree.getQttEntree());
            db.getPstm().setInt(4,entree.getProduit().getId());
            ok =db.executMaj();
            db.closeConnection();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public Entree find(Entree entree) {
        return null;
    }

    @Override
    public Entree findByville(float qttEntree) {
        return null;
    }

    @Override
    public List<Entree> findAll() {
        List<Entree> entrees =new ArrayList<Entree>();
        String sql="SELECT * FROM Entree";
        try {
            db.initPrepar(sql);
            rs =db.executeSelect();
            while (rs.next()){
                Entree entree=new Entree();
                entree.setId(rs.getInt(1));
                SimpleDateFormat sdf =new SimpleDateFormat("yyy-MM-dd");
                entree.setDateEntree(sdf.parse(rs.getString(2)));
                entree.setQttEntree(rs.getInt(3));
                entree.setProduit((Produit) rs.getObject(5));
                entrees.add(entree);
                db.closeConnection();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return entrees;
    }

    @Override
    public int update(Entree entree) {
        return 0;
    }

    @Override
    public int deleate(Long id) {
        return 0;
    }
}
