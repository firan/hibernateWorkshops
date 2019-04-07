package com.example.productdata;

import com.example.productdata.Entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTest {

    @Autowired
    private Environment env;

    @Test
    public void testJDBCConnectionSelect() throws SQLException {
        HashMap<String, Product> products = new HashMap<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1. Get a connection to database
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "junior" , "programmer");
            connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), "junior" , "programmer");

            System.out.println("Database connection successful!\n");

            // 2. Create a statement
            statement = connection.createStatement();

            // 3. Execute SQL query
            resultSet = statement.executeQuery("select * from product");

            // 4. Process the result set
            while (resultSet.next()) {
                products.put(
                        resultSet.getString("name"),
                        new Product(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("description"),
                                resultSet.getDouble("price")
                        )
                );
            }

            System.out.println(products.values());
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }

    @Test
    public void testJDBCConnectionUpdate() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            // 1. Get a connection to database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "junior" , "programmer");

            System.out.println("Database connection successful!\n");

            // 2. Create a statement
            statement = connection.createStatement();

            String sql = "INSERT INTO product (id, name, description, price) VALUES (154, 'lenovo', 'laptop', 10000.00)";
            // 3. Execute SQL update
            int updateCount = statement.executeUpdate(sql);

            System.out.println(updateCount);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }

    @Test
    public void testJDBCConnectionUpdateWithPreparedStatement() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            // 1. Get a connection to database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "junior" , "programmer");

            System.out.println("Database connection successful!\n");

            // 2. Create a statement
            String updateSQL = "INSERT INTO product (id, name, description, price) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
            preparedStatement.setInt(1, 1001);
            preparedStatement.setString(2, "Samsung Galaxy");
            preparedStatement.setString(3, "Flag Smartphone");
            preparedStatement.setDouble(4, 4000.0);

            // 3. Execute SQL update
            int updateCount = preparedStatement.executeUpdate();

            System.out.println(updateCount);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}