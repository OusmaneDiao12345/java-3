package repositories;

import entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientRepositoryBD {

    private final Connection connection;

    public ClientRepositoryBD() {
        this.connection = Database.getConnection();
    }

    public void save(Client client) {
        String sql = "INSERT INTO clients (surname, telephone, adresse) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, client.getSurname());
            stmt.setString(2, client.getTelephone());
            stmt.setString(3, client.getAdresse());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Le client est dans la base de donnée.");
            } else {
                System.out.println("Erreur lors de l'enregistrement du client.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur SQL: " + e.getMessage());
        }
    }
}
