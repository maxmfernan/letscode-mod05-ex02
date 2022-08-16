package br.com.letscode.service;

import br.com.letscode.dao.ClientDao;
import br.com.letscode.model.Client;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class ClientService {

    @Inject
    ClientDao clientDao;

    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }

    public void updateClientById(Long id, Client client) {
        clientDao.updateClientById(id, client);
    }

    public Client createClient(Client client) {
        return clientDao.createClient(client);
    }
}
