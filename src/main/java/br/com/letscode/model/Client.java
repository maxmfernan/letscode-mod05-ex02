package br.com.letscode.model;

import br.com.letscode.utils.NamedClientQuery;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "CLIENT")
@NamedNativeQueries(
        {
                @NamedNativeQuery(
                        name =  "GET_ALL_CLIENTS",
                        query = "SELECT * FROM CLIENT",
                        resultClass = Client.class
                )
        }
)
public class Client implements PanacheRepository<Client> {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(
        min = 5,
        max = 100,
        message = "O nome deve ter entre 5 e 100 caracteres."
    )
    private String name;


    @Min(
        value = 18,
        message = "A idade mínima é de 18 anos."
    )
    private Long age;

    @NotBlank
    @Pattern(
        regexp = "[A-Z]{2}\\d{9}",
        message = "O vat deve ter o seguinte padrão XX999999999"
    )
    private String vat;

    @NotBlank
    @Email(message = "O email deve ser um endereço válido.")
    private String Email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
