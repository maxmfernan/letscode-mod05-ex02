package br.com.letscode.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
//@Table(name = "CATEGORIA")
public class Categoria extends PanacheEntity {
    public String name;
    public String code;

//    @OneToMany(
//            fetch = FetchType.LAZY,
//            mappedBy = "categoria",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
    @OneToMany(
            mappedBy="categoria",
            cascade= CascadeType.ALL,
            orphanRemoval=true
    )
    public List<Client> clients = new ArrayList<>();

    public static Optional<Categoria> findByCode(String code){
        return find("code", code).firstResultOptional();
    }
}
