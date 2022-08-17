package br.com.letscode.service;

import br.com.letscode.dto.CategoriaDto;
import br.com.letscode.dto.CategoriaMapper;
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
public class CategoriaService {

    @Inject
    CategoriaMapper categoriaMapper;

    @Transactional
    public CategoriaDto createCategoria(CategoriaDto categoriaDto){
        Categoria categoriaEntity = categoriaMapper.toCategoriaEntity(categoriaDto);
        Categoria.persist(categoriaEntity);

        if (categoriaEntity.isPersistent()) {
            Optional<Categoria> optCaterogia = Categoria.findByIdOptional(categoriaEntity.id);
            categoriaEntity = optCaterogia.orElseThrow(NotFoundException::new);
            return categoriaMapper.toCategoriaDto(categoriaEntity);
        }else {
            throw new PersistenceException();
        }
    }

    public List<CategoriaDto> getAllCategorias(){
        return categoriaMapper.toCategoriaDtoList(Categoria.findAll().list());
    }

    @Transactional
    public Response deleteCategoriaById(Long id){
        Boolean isEntityDeleted = Categoria.deleteById(id);

        if( !isEntityDeleted ){
            throw new WebApplicationException("Categoria de id " + id + " não existe.", Response.Status.NOT_FOUND);
        }

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @Transactional
    public CategoriaDto updateCategoria(Long id, CategoriaDto categoriaDto){
        Categoria entity = Categoria.findById(id);

        if( entity == null){
            throw new WebApplicationException("A categoria de id " + id + "não existe.", Response.Status.NOT_FOUND);
        }

        categoriaMapper.updateCategoriaEntityFromDto(categoriaDto, entity);

        return categoriaMapper.toCategoriaDto(entity);
    }

    @Transactional
    public Categoria sync(CategoriaDto categoriaDto){
        Optional<Categoria> optionalCatEntity = Categoria.findByCode(categoriaDto.getCode());

        Categoria categoriaEntity = null;
        if( !optionalCatEntity.isPresent() ){
            categoriaEntity = categoriaMapper.toCategoriaEntity(categoriaDto);
        }else {
            categoriaEntity = categoriaMapper.updateCategoriaEntityFromDto(categoriaDto, optionalCatEntity.get());
        }

        categoriaEntity.persist();

        return categoriaEntity;
    }




}
