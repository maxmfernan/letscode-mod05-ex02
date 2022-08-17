package br.com.letscode.dto;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;

public class ClientDto {

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
    private String email;

    private CategoriaDto categoria;

    public CategoriaDto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDto categoria) {
        this.categoria = categoria;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }


    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

}
