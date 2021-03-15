package sn.sarr.repository.jdbc;

import sn.sarr.domaine.Commande;
import sn.sarr.repository.CommandeRepository;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.List;

public class jdbcBaseCommandeRepository implements CommandeRepository {
    private MysqlDataSource db=new MysqlDataSource();
    private ResultSet rs;
    private int ok;
    @Override
    public int add(Commande commande) {
        String sql="INSERT INTO Commande VALUES (NULL,?,?,?,?)";
        try {
            db.initPrepar(sql);
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
            db.getPstm().setString(1,sdf.format(commande.getDateCommande()));
            db.getPstm().setBoolean(2,commande.isEtat());
            db.getPstm().setString(3,commande.getNumero());
            db.getPstm().setInt(4,commande.getClient().getId());
            ok =db.executMaj();
            db.closeConnection();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public Commande find(Commande commande) {
        return null;
    }

    @Override
    public Commande findByville(String numero) {
        return null;
    }

    @Override
    public List<Commande> findAll() {
        return null;
    }

    @Override
    public int update(Commande commande) {
        return 0;
    }

    @Override
    public int deleate(Long id) {
        return 0;
    }
}
