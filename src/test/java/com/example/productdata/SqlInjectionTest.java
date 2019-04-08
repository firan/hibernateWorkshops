package com.example.productdata;

import com.example.productdata.Entity.LicensePlate;
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
public class SqlInjectionTest {

    @Autowired
    private Environment env;

    @Test
    public void testSelect() throws SQLException {
        HashMap<String, LicensePlate> plates = new HashMap<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 1. Get a connection to database
            connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), "junior" , "programmer");

            System.out.println("Database connection successful!\n");

            // 2. Create a statement
            statement = connection.createStatement();

            // 3. Execute SQL query
            resultSet = statement.executeQuery("select * from licenseplate");

            // 4. Process the result set
            while (resultSet.next()) {
                plates.put(
                        resultSet.getString("id"),
                        new LicensePlate(
                                resultSet.getInt("id"),
                                resultSet.getString("code"),
                                resultSet.getInt("length")
                        )
                );
            }

            System.out.println(plates.values());
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
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
    public void testSelectWithInjection() throws SQLException {
        HashMap<String, LicensePlate> plates = new HashMap<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String inputText = "blabla' or 1=1 -- ";

        try {
            // 1. Get a connection to database
            connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), "junior" , "programmer");

            System.out.println("Database connection successful!\n");

            // 2. Create a statement
            statement = connection.createStatement();

            // 3. Execute SQL query
            resultSet = statement.executeQuery("select * from licenseplate where code='"+inputText+"'");

            // 4. Process the result set
            while (resultSet.next()) {
                plates.put(
                        resultSet.getString("id"),
                        new LicensePlate(
                                resultSet.getInt("id"),
                                resultSet.getString("code"),
                                resultSet.getInt("length")
                        )
                );
            }

            System.out.println(plates.values());
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
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
    public void testSelectWithoutInjection() throws SQLException {
        HashMap<String, LicensePlate> plates = new HashMap<>();
        Connection connection = null;
        ResultSet resultSet = null;
        String inputText = "blabla' or 1=1 -- ";

        try {
            // 1. Get a connection to database
            connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), "junior" , "programmer");

            System.out.println("Database connection successful!\n");

            // 2. Create a statement
            String selectSQL = "select * from licenseplate where code=?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, inputText);

            // 3. Execute SQL query
            resultSet = preparedStatement.executeQuery();

            // 4. Process the result set
            while (resultSet.next()) {
                plates.put(
                        resultSet.getString("id"),
                        new LicensePlate(
                                resultSet.getInt("id"),
                                resultSet.getString("code"),
                                resultSet.getInt("length")
                        )
                );
            }

            System.out.println(plates.values());
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }
}