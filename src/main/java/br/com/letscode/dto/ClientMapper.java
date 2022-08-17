package br.com.letscode.dto;

import br.com.letscode.model.Categoria;
import br.com.letscode.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface ClientMapper {

    ClientDto toClientDto(Client client);
    Client toClientEntity(ClientDto dto);

    Client updateClientEntityFromDto(ClientDto dto, @MappingTarget Client client);

    //@Mapping(target = "clients", ignore = true )
    CategoriaDto toCategoriaDto(Categoria categoria);
    Categoria toCategoriaEntity(CategoriaDto dto);

    default List<ClientDto> toClientDtoList(List<Client> clients){
        return clients.stream()
                .map(
                        (client) -> {
                            ClientDto clientDto = toClientDto(client);
                            clientDto.setCategoria(toCategoriaDto(client.categoria));
                            return  clientDto;
                        }
                )
                .collect(Collectors.toList());
    }
}
