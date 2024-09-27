package repositories;

import entities.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Client> getClientsWithAccounts() {
        List<Client> result = new ArrayList<>();
        for (Client client : clients) {
            if (client.getAccount() != null) {
                result.add(client);
            }
        }
        return result;
    }

    public List<Client> getClientsWithoutAccounts() {
        List<Client> result = new ArrayList<>();
        for (Client client : clients) {
            if (client.getAccount() == null) {
                result.add(client);
            }
        }
        return result;
    }

    public Client findClientByPhone(String phone) {
        for (Client client : clients) {
            if (client.getTelephone().equals(phone)) {
                return client;
            }
        }
        return null;
    }
}
