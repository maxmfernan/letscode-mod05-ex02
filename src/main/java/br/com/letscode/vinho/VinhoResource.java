package br.com.letscode.vinho;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("vinho")
public class VinhoResource {

    @GET
    @Path("/{tipo}")
    public String parametros(
            @PathParam("tipo") String tipo,
            @QueryParam("casta") String casta
    ){
        return "Vinho do tipo " + tipo + " e da casta " + casta + ".";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Vinho create(Vinho vinho){
        vinho.persist();
        return vinho;
    }


}
