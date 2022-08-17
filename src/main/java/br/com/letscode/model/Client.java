package br.com.letscode.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Client extends PanacheEntity {

    public String name;

    public Long age;

    public String vat;

    public String email;

    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "categoria_id")
    public Categoria categoria;


}
