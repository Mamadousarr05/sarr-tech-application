package sn.sarr.repository.jdbc;

import java.sql.*;

public class MysqlDataSource implements sn.sarr.repository.jdbc.DataSource {
    //pour la connexion
    //private Connection cnx;
    //pour les resultats de type SELECT
    private ResultSet rs;
    //pour les requetes preparer
    private PreparedStatement pstm;
    //pour les requetes de type Mis a jour MAJ(INSERT,UPDATE,DELET)
    private  int ok;

    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "";
    public static final String NOM_BASE = "on_sarrtest_jdbc";

    public static final String IP = "localhost";
    public static final String PORT = "3306";

    public Connection createConnection(){
        try {
            Class c = Class.forName("com.mysql.cj.jdbc.Driver");
            Driver pilote = (Driver) c.newInstance();
            // enregistrement du pilote auprès du DriverManager
            DriverManager.registerDriver(pilote);
            // Protocole de connexion
            String protocole = "jdbc:mysql:";
            // Adresse IP de l’hôte de la base et port
            String ip = IP;  // dépend du contexte
            String port = PORT;  // port MySQL par défaut
            // Nom de la base ;
            String nomBase = NOM_BASE;  // dépend du contexte
            // Chaîne de connexion
            String chaineDeConnexion = protocole + "//" + ip + ":" + port + "/" + nomBase;
            // Identifiants de connexion et mot de passe
            String dbUser = DB_USER;  // dépend du contexte
            String dbPassword = DB_PASSWORD;  // dépend du contexte
            // Connexion
            return DriverManager.getConnection(chaineDeConnexion, dbUser, dbPassword);
        }
        catch (Exception ex){
            System.err.println("Une erreur est survenue lors de la création de la connexion: ");
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public void initPrepar(String sql){
        try {

            createConnection();
            pstm = createConnection().prepareStatement(sql);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public ResultSet executeSelect(){
        try {
            createConnection();
            rs =pstm.executeQuery();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  rs;
    }
    public int executMaj(){
        try {
            ok=pstm.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }
    public void closeConnection(){
        try {
            if(createConnection() !=null)
                createConnection().close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public PreparedStatement getPstm() {
        return pstm;
    }


}
