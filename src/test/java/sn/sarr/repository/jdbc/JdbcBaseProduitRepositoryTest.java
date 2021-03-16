package sn.sarr.repository.jdbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sn.sarr.domaine.Produit;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class JdbcBaseProduitRepositoryTest {
    private jdbcBaseProduitRepository jdbcBaseProduitRepository;

    @BeforeEach
    void setUp() throws SQLException {
        System.out.println("Dans la méthode setup");
        //Arrange
        DataSource dataSource = new MockDatasource();
        jdbcBaseProduitRepository = new jdbcBaseProduitRepository(dataSource);
    }

    @Test
    void getProduits(){
        System.out.println("Dans la méthode get produit");
        //Act
        Produit[] produits = jdbcBaseProduitRepository.findAll().toArray(new Produit[0]);
        //Assert
        assertEquals(4, produits.length, "le nombre de produit doit être 4");
    }

    @Test
    void getProduitsWhenExceptionOccured(){
        System.out.println("Dans la méthode getproduit when exception occured");
        DataSource dataSource = mock(DataSource.class);
        when(dataSource.createConnection()).thenThrow(new RuntimeException("Base de données non disponible"));
        jdbcBaseProduitRepository = new jdbcBaseProduitRepository(dataSource);
        Produit[] produits = jdbcBaseProduitRepository.findAll().toArray(new Produit[0]);
        assertEquals(4, produits.length, "le nombre de produits doit être 0");
    }
//
    @Test
    void getByIdShouldReturnProduitsWhenAvailable(){
        Produit produit = jdbcBaseProduitRepository.findByid(1);
        assertNotNull(produit);
        //assertEquals(1, produit.getId());
       // assertEquals("", produit.getDescription());
        //assertEquals( "",produit.getQttEnStock());
       // assertEquals("", produit.getPrixMin());
       // assertEquals("", produit.getPrixUnitaire());
    }
//
    @Test
    void getByIdShouldReturnProduitWhenAvailableNotTrivial() throws SQLException {
        DataSource dataSource = mock(DataSource.class);
        Connection connection = mock(Connection.class);

        when(dataSource.createConnection()).thenReturn(connection);
        Statement statement = mock(Statement.class);
        when(connection.createStatement()).thenReturn(statement);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        ResultSet resultSet2 = mock(ResultSet.class);
        when(preparedStatement.executeQuery()).thenReturn(resultSet2);
        when(resultSet2.getInt(anyString())).thenReturn(5);
        when(resultSet2.getString(anyString())).thenReturn("aaaaa");

        jdbcBaseProduitRepository = new jdbcBaseProduitRepository(dataSource);

        Produit produit = jdbcBaseProduitRepository.findByid(2);
        assertNotNull(produit);
        //assertEquals(2, produit.getId());
        //assertEquals("", produit.getPrixMin());
       // assertEquals("", produit.getPrixUnitaire());
       // assertEquals("aaaaa", produit.getDescription());

}
}
