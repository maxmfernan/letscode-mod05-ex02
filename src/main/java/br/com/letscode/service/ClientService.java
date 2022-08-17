package br.com.letscode.service;

import br.com.letscode.dto.CategoriaDto;
import br.com.letscode.dto.CategoriaMapper;
import br.com.letscode.dto.ClientDto;
import br.com.letscode.dto.ClientMapper;
import br.com.letscode.model.Categoria;
import br.com.letscode.model.Client;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClientService {

    @Inject
    ClientMapper clientMapper;
    @Inject
    CategoriaMapper categoriaMapper;

    @Inject
    CategoriaService categoriaService;

    public List<ClientDto> getAllClients(){
        System.out.println(clientMapper.toClientDtoList(Client.findAll().list()).toString());
        return clientMapper.toClientDtoList(Client.findAll().list());
    }


    @Transactional
    public ClientDto updateClient(Long id, ClientDto clientDto){
        Optional<Client> optionalClient = Client.findByIdOptional(id);

        if( !optionalClient.isPresent()  ){
            throw new WebApplicationException("Cliente com o id " + id + " não exite.", 404);
        }

        Categoria categoria = categoriaService.sync(clientDto.getCategoria());

        Client clientEntity = optionalClient.get();
        //clientEntity.categoria = categoria;
        clientEntity = clientMapper.updateClientEntityFromDto(clientDto, clientEntity);
        clientEntity.categoria = categoria;
        clientEntity.persist();

        return clientMapper.toClientDto(clientEntity);




//        //Has client
//        //update clientEntity
//        Client clientEntity = clientMapper.updateClientEntityFromDto(clientDto, oldCltEntity);
//
//        //Category context
//        //Get old category
//        Categoria oldCatEntity = Categoria.findByCode(clientDto.getCategoria().getCode());
//
//        //Test if category exist
//        Categoria categoryEntity;
//        if( oldCatEntity == null){
//            categoryEntity = categoriaMapper.toCategoriaEntity(clientDto.getCategoria());
//            //Persist new category because the old one didn't exist
//            categoryEntity.persist();
//
//        }else{
//            categoryEntity = categoriaMapper.updateCategoriaEntityFromDto(clientDto.getCategoria(), oldCatEntity);
//            //update category in db
//            categoryEntity.persistAndFlush();
//        }
//
//        //Associate entity with category
//        clientEntity.categoria = categoryEntity;
//
//        //update entity
//
//        return clientMapper.toClientDto(clientEntity);



    }

    @Transactional
    public ClientDto createClient(ClientDto clientDto){
        Client entity = clientMapper.toClientEntity(clientDto);
        Categoria categoria = categoriaMapper.toCategoriaEntity(clientDto.getCategoria());

        //Verifica se a categoria já existe
        Optional<Categoria> optionalCategoria = categoria.findByCode(categoria.code);

        if(  !optionalCategoria.isPresent() ){
            categoria.persist();
            entity.categoria = categoria;
        }
        else{
            entity.categoria = optionalCategoria.get();
        }


        entity.persist();


        if(entity.isPersistent()){
            Optional<Client> optionalClient = Client.findByIdOptional(entity.id);
            entity = optionalClient.orElseThrow(NotFoundException::new);
            return clientDto;
        }
        else{
            throw new PersistenceException();
        }
    }

    @Transactional
    public Response deleteClient(Long id){

        Boolean isEntityDeleted = Client.deleteById(id);

        if( !isEntityDeleted ){
            throw new WebApplicationException("Client com id " + id + " não existe.");
        }

        return Response.status(Response.Status.NO_CONTENT).build();
    }


}
