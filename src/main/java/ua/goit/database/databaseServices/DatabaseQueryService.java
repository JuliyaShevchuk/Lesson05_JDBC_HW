package ua.goit.database.databaseServices;

import ua.goit.database.Database;
import ua.goit.utils.ReadFile;
import ua.goit.model.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    Connection connect = Database.getInstance().getConnection();

    public List<YoungestOldestWorkers> youngestOldestWorkers(){

        String fileName = "./sql/find_youngest_oldest_workers.sql";
        String contents = new ReadFile().readUsingFiles(fileName);

        List<YoungestOldestWorkers> result = new ArrayList<>();
        try (Statement st = connect.createStatement()) {
            try (ResultSet rs = st.executeQuery(contents)) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    String birthday = rs.getString("birthday");
                    String type = rs.getString("type");
                    result.add(new YoungestOldestWorkers(name, birthday,type));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    public List<ProjectPrices> projectPrices(){
        String fileName = "./sql/print_project_prices.sql";
        String contents = new ReadFile().readUsingFiles(fileName);

        List<ProjectPrices> result = new ArrayList<>();
        try (Statement st = connect.createStatement()) {
            try (ResultSet rs = st.executeQuery(contents)) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    int suma = rs.getInt("suma");
                    result.add(new ProjectPrices(name, suma));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    public List<MaxSalaryWorker> maxSalaryWorker(){
        String fileName = "./sql/find_max_salary_worker.sql";
        String contents = new ReadFile().readUsingFiles(fileName);

        List<MaxSalaryWorker> result = new ArrayList<>();
         try (Statement st = connect.createStatement()) {
            try (ResultSet rs = st.executeQuery(contents)) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    int salary = rs.getInt("salary");
                    result.add(new MaxSalaryWorker(name, salary));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<LongerProjectCount> findLongerProject() {
        Connection connect = Database.getInstance().getConnection();

        String fileName = "./sql/find_longest_project.sql";
        String contents = new ReadFile().readUsingFiles(fileName);

        List<LongerProjectCount> result = new ArrayList<>();
        try (Statement st = connect.createStatement()) {
            try (ResultSet rs = st.executeQuery(contents)) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    int monthCount = rs.getInt("month_count");
                    result.add(new LongerProjectCount(name, monthCount));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connect.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;

    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        Connection connect = Database.getInstance().getConnection();

        String fileName = "./sql/find_max_projects_client.sql";
        String contents = new ReadFile().readUsingFiles(fileName);

        List<MaxProjectCountClient> result = new ArrayList<>();
        try (Statement st = connect.createStatement()) {
            try (ResultSet rs = st.executeQuery(contents)) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    int projectCount = rs.getInt("project_count");
                    result.add(new MaxProjectCountClient(name, projectCount));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connect.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;

    }

}
