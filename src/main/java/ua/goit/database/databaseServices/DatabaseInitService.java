package ua.goit.database.databaseServices;

import ua.goit.database.Database;
import ua.goit.utils.ReadFile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args)  {
        String fileName = "./sql/init_db.sql";
        ReadFile readFile = new ReadFile();
        String contents = readFile.readUsingFiles(fileName);

        Connection connection = Database.getInstance().getConnection();
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(contents);
        } catch (Exception ex){
            ex.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
