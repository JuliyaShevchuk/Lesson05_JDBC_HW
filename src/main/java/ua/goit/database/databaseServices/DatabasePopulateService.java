package ua.goit.database.databaseServices;

import ua.goit.database.Database;
import ua.goit.utils.ReadFile;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Connection connection = Database.getInstance().getConnection();
        createClientNames(connection);
        createProjectNames(connection);
        createWorkerNames(connection);
        createProjectWorker(connection);

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void createClientNames(Connection connection){
        String clientQuery = "INSERT INTO client (name) VALUES(?)";

        String[] clientNames = {"Client1","Client2", "Client3","Client4","Client5"};

        try (PreparedStatement st = connection.prepareStatement(clientQuery)) {
            for(String name: clientNames) {
                st.setString(1, name);
                st.addBatch();
            }
            st.executeBatch();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void createProjectNames(Connection connection) {
        String projectQuery = "INSERT INTO project(name, client_id, start_date, finish_date) VALUES(?,?,?,?)";
        String[][] projectNames = {{"Project1", "2", "2022-12-01", "2023-12-01"},
                {"Project2", "2", "2022-11-11", "2023-05-01"},
                {"Project3", "1", "2020-01-01", "2024-12-01"},
                {"Project4", "3", "2020-01-01", "2024-12-01"},
                {"Project5", "3", "2022-06-01", "2025-06-01"},
                {"Project6", "4", "2020-07-12", "2022-05-01"},
                {"Project7", "1", "2022-08-01", "2022-12-31"},
                {"Project8", "4", "2023-01-01", "2023-12-31"},
                {"Project9", "5", "2021-12-01", "2023-04-01"},
                {"Project10", "4", "2022-07-01", "2025-01-01"},
                {"Project11", "2", "2022-01-01", "2023-01-01"}};

        try (PreparedStatement st = connection.prepareStatement(projectQuery)) {
            for (String[] project : projectNames) {
                st.setString(1, project[0]);
                st.setString(2, project[1]);
                st.setString(3, project[2]);
                st.setString(4, project[3]);
                st.addBatch();
               }
            st.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createWorkerNames(Connection connection) {
        String workerQuery = "INSERT INTO worker(name, birthday, level, salary) VALUES(?,?,?,?)";
        String[][] workerNames = {{"Worker1","1973-08-01","Senior","11000"},
                {"Worker2","1978-12-11","Senior","11000"},
                {"Worker3","1985-05-10","Middle","7000"},
                {"Worker4","1988-06-03","Trainee","600"},
                {"Worker5","1986-10-13","Trainee","500"},
                {"Worker6","1980-03-15","Junior","1000"},
                {"Worker7","1982-11-30","Junior","1500"},
                {"Worker8","1988-09-05","Middle","4500"},
                {"Worker9","1979-10-04","Middle","3500"},
                {"Worker10","1973-08-01","Middle","6000"}};

        try (PreparedStatement st = connection.prepareStatement(workerQuery)) {
            for (String[] project : workerNames) {
                st.setString(1, project[0]);
                st.setString(2, project[1]);
                st.setString(3, project[2]);
                st.setString(4, project[3]);
                st.addBatch();
            }
            st.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createProjectWorker(Connection connection) {
        String projectWorkerQuery = "INSERT INTO project_worker (project_id, worker_id) VALUES(?,?)";
        int[][] projectWorkerNames={{1,1},
                                    {1,3},
                                    {1,6},
                                    {2,2},
                                    {2,8},
                                    {3,2},
                                    {3,9},
                                    {3,4},
                                    {3,7},
                                    {4,1},
                                    {4,10},
                                    {5,2},
                                    {6,2},
                                    {6,9},
                                    {6,7},
                                    {7,1},
                                    {7,3},
                                    {7,5},
                                    {8,1},
                                    {8,8},
                                    {9,3},
                                    {9,10},
                                    {9,7},
                                    {10,10},
                                    {10,6},
                                    {10,5},
                                    {10,4},
                                    {10,1},
                                    {11,3}};
        try (PreparedStatement st = connection.prepareStatement(projectWorkerQuery)) {
            for (int[] projectWorker : projectWorkerNames) {
                st.setString(1, String.valueOf(projectWorker[0]));
                st.setString(2, String.valueOf(projectWorker[1]));

                st.addBatch();
            }
            st.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}