package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DBemulation {
    public static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/";
    public static final String USER = "root";
    public static final String PASSWORD = "pass123";

    private DBemulation() {

    }

    protected static void createTest() {

        try(Connection conn = DriverManager.getConnection(CONNECTION_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement()) {
            String query = "CREATE DATABASE IF NOT EXISTS accounts;";
            try{stmt.executeUpdate(query);}catch(Exception e) {
                //
            }

            query = "USE accounts;";
            try{stmt.executeUpdate(query);}catch(Exception e) {
                //
            }

            query = "CREATE TABLE IF NOT EXISTS account(id int PRIMARY KEY, balance int, version int);";
            try{stmt.executeUpdate(query);}catch(Exception e) {
                //
            }

            query = """
                    INSERT INTO account (id, balance, version)
                    SELECT * FROM (SELECT 1, 500, 0) AS tmp
                    WHERE NOT EXISTS (
                        SELECT id FROM account WHERE id = 1
                    ) LIMIT 1;""";
            stmt.executeUpdate(query);

            secondDb();
        }catch( SQLException e ){
            //
        }


    }

    private static void secondDb(){
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", USER, PASSWORD);
            Statement stmt = conn.createStatement()) {
            String query = "CREATE DATABASE IF NOT EXISTS movies;";
            try{stmt.executeUpdate(query);}catch(Exception e) {
                //
            }

            query = "USE movies;";
            try{stmt.executeUpdate(query);}catch(Exception e) {
                //
            }

            query = "CREATE TABLE IF NOT EXISTS movie(id int PRIMARY KEY, name varchar(255), version int);";
            try{stmt.executeUpdate(query);}catch(Exception e) {
                //
            }

            query = """
                    INSERT INTO movie (id, name, version)
                    SELECT * FROM (SELECT 1, "test", 0) AS tmp
                    WHERE NOT EXISTS (
                        SELECT id FROM movie WHERE id = 1
                    ) LIMIT 1;""";
            stmt.executeUpdate(query);


        }catch( SQLException e ){
            //
        }
    }
}
