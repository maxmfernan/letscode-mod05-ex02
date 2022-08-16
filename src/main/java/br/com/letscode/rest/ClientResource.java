package br.com.letscode.rest;

import br.com.letscode.model.Client;
import br.com.letscode.service.ClientService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("client")
public class ClientResource {

    @Inject
    ClientService clientService;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void updateClientById(final @PathParam("id") Long id, Client client){
        clientService.updateClientById(id, client);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Client createClient(Client client){
        return clientService.createClient(client);
    }

    @DELETE
    @Path("/{id}")
    public void deleteClientById(final @PathParam("id") int id){

    }
}
