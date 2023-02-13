package ua.goit.database;

import ua.goit.prefs.Prefs;

import java.io.IOException;
import java.sql.*;


public class Database {
    private static final Database INSTANCE = new Database();
    private Connection connection;
    private Database() {
        try{
            String url = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL);
            connection = DriverManager.getConnection(url, "sa", "");
         } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() throws IOException, SQLException {
        connection.close();
    }

    public int executeUpdate(String sql){
        try (Statement st = connection.createStatement()) {
            return st.executeUpdate(sql);
        } catch (Exception ex){
            ex.printStackTrace();
            return -1;
        }

    }

}
