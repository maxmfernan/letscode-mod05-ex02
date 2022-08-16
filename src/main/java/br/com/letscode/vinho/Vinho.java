package br.com.letscode.vinho;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vinho extends PanacheEntity {

//    @Id
    @GeneratedValue
    public  Long id;

    public String name;

}
