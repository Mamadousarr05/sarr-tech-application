package sn.sarr.repository.jdbc;

import sn.sarr.domaine.Produit;
import sn.sarr.repository.ProduitRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcBaseProduitRepository implements ProduitRepository {
    private MysqlDataSource db = new MysqlDataSource();
    private ResultSet rs;
    //private int ok;
    private final DataSource dataSource;

    public jdbcBaseProduitRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Produit add(Produit produit) {
        String sql = "INSERT INTO Produit VALUES (NULL,?,?,?,?)";
        try {
            db.initPrepar(sql);
            // SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
            db.getPstm().setString(1, produit.getDescription());
            db.getPstm().setInt(2, produit.getQttEnStock());
            db.getPstm().setInt(3, (int) produit.getPrixMin());
            db.getPstm().setInt(4, (int) produit.getPrixUnitaire());
            db.executMaj();
            db.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return produit;
    }

    @Override
    public Produit find(Produit produit) {
        return null;
    }

    @Override
    public Produit findDescript(String description) {
        return null;
    }

    @Override
    public Produit findByid(int id) {

            String query = "SELECT id, nom from prestation where id = ?";
            try {
                Connection connection = dataSource.createConnection();
                PreparedStatement statement = connection.prepareStatement(query);

                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                int retrievedId = rs.getInt("id");
                String retrievedDescription = rs.getString("description");
                int retrievedQtt = rs.getInt("qttEnStock");
                double retrievedPrixmin = rs.getDouble("prixMin");
                double retrievedPrixuni = rs.getDouble("prixUnitaire");
                Produit produit = new Produit(retrievedId, retrievedDescription,retrievedQtt,retrievedPrixmin,retrievedPrixuni);
                return produit ;
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
            return null;

    }

    @Override
    public Produit findByqttt(int qttEnStock) {
        return null;
    }

    @Override
    public List<Produit> findAll() {
        List<Produit> produits = new ArrayList<Produit>();
        String sql = "SELECT * FROM Produit";
        try {
            db.initPrepar(sql);
            rs = db.executeSelect();
            while (rs.next()) {
                Produit produit = new Produit();
                produit.setId(rs.getInt(1));
                produit.setDescription(rs.getString(2));
                produit.setQttEnStock(rs.getInt(3));
                produit.setPrixMin(rs.getDouble(4));
                produit.setPrixUnitaire(rs.getDouble(4));
                produits.add(produit);
                db.closeConnection();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return produits;
    }

    @Override
    public int update(Produit produit) {
        return 0;
    }

    @Override
    public int deleate(Long id) {
        return 0;
    }

    }





