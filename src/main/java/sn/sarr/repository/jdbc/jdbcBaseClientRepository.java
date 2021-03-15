package sn.sarr.repository.jdbc;

import sn.sarr.domaine.Client;
import sn.sarr.domaine.TypeClient;
import sn.sarr.repository.ClientRepository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class jdbcBaseClientRepository implements ClientRepository {
    private MysqlDataSource db=new MysqlDataSource();
    private ResultSet rs;
    private int ok;
    @Override
    public int add(Client client) {
        String sql="INSERT INTO Client VALUES (NULL,?,?,?,?)";
        try {
            db.initPrepar(sql);
           // SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
            db.getPstm().setString(1, client.getAdresse());
            db.getPstm().setString(2,client.getIdentification());
            db.getPstm().setString(3,client.getNom());
            db.getPstm().setInt(4,client.getTypeClient().getId());
            ok =db.executMaj();
            db.closeConnection();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }

    @Override
    public Client find(Client client) {
        return null;
    }

    @Override
    public Client findBycni(String identification) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients =new ArrayList<Client>();
        String sql="SELECT * FROM Client";
        try {
            db.initPrepar(sql);
            rs =db.executeSelect();
            while (rs.next()){
                Client client=new Client();
                client.setId(rs.getInt(1));
                //SimpleDateFormat sdf =new SimpleDateFormat("yyy-MM-dd");
                client.setAdresse(rs.getString(2));
                client.setIdentification(rs.getString(3));
                client.setNom(rs.getString(4));
                client.setTypeClient((TypeClient) rs.getObject(5));
                clients.add(client);
                db.closeConnection();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return clients;
    }

    @Override
    public int update(Client client) {
        return ok;
    }

    @Override
    public int deleate(Long id) {
        return 0;
    }
}
