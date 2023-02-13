package ua.goit.database.databaseServices;

import ua.goit.database.Database;
import ua.goit.utils.ReadFile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {
    public static void main(String[] args) {
        String fileName = "./sql/populate_db.sql";
        ReadFile readFile = new ReadFile();
        String contents = readFile.readUsingFiles(fileName);

        Database database = Database.getInstance();
        database.executeUpdate(contents);
        try {
            database.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
