package br.com.letscode.dto;

import br.com.letscode.model.Categoria;
import br.com.letscode.model.Client;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "cdi")
public interface CategoriaMapper {

    //@Mapping(target = "clients", ignore=true)
    CategoriaDto toCategoriaDto(Categoria categoria);

    //@Mapping(target = "clients", ignore = true)
    Categoria toCategoriaEntity(CategoriaDto dto);

    Categoria updateCategoriaEntityFromDto(CategoriaDto dto, @MappingTarget Categoria categoria);

    //Specific to client
//    ClientDto toClientDto(Client client);
//    Client toClientEntity(ClientDto dto);

    default List<CategoriaDto> toCategoriaDtoList(List<Categoria> categorias){
        return categorias.stream()
                .map(
                        (categoria) -> {
                            CategoriaDto categoriaDto = toCategoriaDto(categoria);
//                            categoriaDto.setClients(
//                                    categoria.clients.stream()
//                                        .map( (client) -> toClientDto(client))
//                                        .collect(Collectors.toList())
//                            );
                            return categoriaDto;
                        }
                )
                .collect(Collectors.toList());
    }
}
