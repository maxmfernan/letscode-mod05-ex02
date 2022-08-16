package br.com.letscode.dao;

import br.com.letscode.model.Client;
import br.com.letscode.utils.NamedClientQuery;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class ClientDao {

    @PersistenceContext
    EntityManager em;

    public List<Client> getAllClients() {
        String namedQuery = NamedClientQuery.GET_ALL_CLIENTS.getNamedQuery();
        TypedQuery<Client> query = em.createNamedQuery(namedQuery, Client.class);
        try{
            return query.getResultList();
        }catch ( NoResultException ex ){
            return new ArrayList<>();
        }catch ( PersistenceException ex){
            throw new RuntimeException(ex);
        }

    }

    @Transactional
    public void updateClientById(Long id, Client client){
        Client oldClient = em.find(Client.class, id);
        em.merge(client);

    }

    @Transactional
    public Client createClient(Client client) {
//        em.persist(client);
//        return client;

    }
}
