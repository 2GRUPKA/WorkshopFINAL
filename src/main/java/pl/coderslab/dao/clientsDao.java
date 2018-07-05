package pl.coderslab.dao;

import pl.coderslab.Classes.Clients;
import pl.coderslab.DbUtil;

import java.sql.*;
import java.util.ArrayList;

public class clientsDao extends Clients {

    public clientsDao() {
    }

    public clientsDao(String name, String lastName, Date birthDate) {
        super(name, lastName, birthDate);
    }


    public void deleteFromClients() {
        String sql = "DELETE FROM clients WHERE id=?";
        if (this.getId() != 0) {
            try {
                PreparedStatement stat = DbUtil.getConn().prepareStatement(sql);
                stat.setInt(1, this.getId());
                stat.executeUpdate();
                setId(0);
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }else {
            System.out.println("A client with the following id does not exist");
        }
    }

    public void saveClients() {
        if (this.getId()==0) {
            try {

                Connection conn = DbUtil.getConn();
                String Columns[] = {"id"};
                String query = "INSERT INTO clients(name,lastName,birthDate)VALUES(?,?,?)";
                PreparedStatement stat = DbUtil.getConn().prepareStatement(query, Columns);
                stat.setString(1, this.getName());
                stat.setString(2, this.getLastName());
                stat.setDate(3, this.getBirthDate());
                stat.executeUpdate();
                ResultSet rs = stat.getGeneratedKeys();
                if (rs.next()) {
                    this.setId(rs.getInt(1));
                }
            } catch (SQLException e) {
                System.out.println("Error could not save client");
            }
        }
    }

    public void editClients() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crm?useSSL=false,root,coderslab");
            Connection conn = DbUtil.getConn();
            String Columns[] = {"ID"};
            PreparedStatement stat = DbUtil.getConn().prepareStatement("UPDATE clients SET name = ?, lastName = ?, birthDate = ? WHERE id=?");
            stat.setString(1, getName());
            stat.setString(2, getLastName());
            stat.setDate(3, getBirthDate());
            stat.setInt(4, getId());
            stat.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error! Could not complete the edit request");
        }
    }

    public static ArrayList<clientsDao> loadAll() throws SQLException {
        String sql = "SELECT * FROM clients";
        PreparedStatement stmt = DbUtil.getConn().prepareStatement(sql);
        return getClientsFromStatement(stmt);
    }

    private static ArrayList<clientsDao> getClientsFromStatement(PreparedStatement stmt) {
        try {
            ArrayList<clientsDao> client = new ArrayList<clientsDao>();
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                clientsDao loadedClient = new clientsDao();
                loadedClient.setName(resultSet.getString("name"));
                loadedClient.setLastName(resultSet.getString("lastName"));
                loadedClient.setBirthDate(resultSet.getDate("birthDate"));
                client.add(loadedClient);
            }
            return client;
        } catch (SQLException e) {
            System.err.println("Error getting clients from the list!");
        }
        return null;
    }

    public static clientsDao loadbyId(int id) {
        try {
            String sql = "SELECT * FROM clients WHERE id=?";
            PreparedStatement stat = DbUtil.getConn().prepareStatement(sql);
            stat.setInt(1, id);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                clientsDao loadedClient = new clientsDao();
                loadedClient.setId(rs.getInt("id"));
                loadedClient.setName(rs.getString("name"));
                loadedClient.setLastName(rs.getString("lastName"));
                loadedClient.setBirthDate(rs.getDate("birthDate"));
                return loadedClient;
            }
        } catch (SQLException e) {
            System.out.println("Error loading clients!");
        }
        return null;
    }


}
