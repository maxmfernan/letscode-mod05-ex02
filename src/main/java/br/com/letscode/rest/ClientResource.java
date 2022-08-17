package br.com.letscode.rest;

import br.com.letscode.dto.ClientDto;
import br.com.letscode.model.Client;
import br.com.letscode.service.ClientService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("client")
@ApplicationScoped
public class ClientResource {

    @Inject
    ClientService clientService;

    @GET
    @Path("/list")
    public List<ClientDto> getAllClients(){
        return clientService.getAllClients();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ClientDto createClient(@Valid ClientDto clientDto){
        return clientService.createClient(clientDto);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ClientDto updateClient(@PathParam("id") Long id, @Valid ClientDto clientDto){
        return clientService.updateClient(id, clientDto);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteClient(@PathParam("id") Long id){
        return clientService.deleteClient(id);
    }

}
