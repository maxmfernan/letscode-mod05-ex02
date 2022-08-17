package br.com.letscode.rest;

import br.com.letscode.dto.CategoriaDto;
import br.com.letscode.service.CategoriaService;
import br.com.letscode.service.ClientService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/categoria")
@ApplicationScoped
public class CategoriaResource {

    @Inject
    CategoriaService categoriaService;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoriaDto> getAllCategorias(){
        return categoriaService.getAllCategorias();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriaDto updateCategoria(@PathParam("id") Long id, @Valid CategoriaDto categoriaDto){
        return categoriaService.updateCategoria(id, categoriaDto);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriaDto createCategoria(@Valid CategoriaDto categoriaDto){
        return categoriaService.createCategoria(categoriaDto);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCategoria(@PathParam("id") Long id){
        return categoriaService.deleteCategoriaById(id);
    }

}
