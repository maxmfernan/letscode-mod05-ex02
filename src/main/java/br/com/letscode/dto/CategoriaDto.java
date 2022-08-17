package br.com.letscode.dto;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDto {

    @NotBlank
    @Size(
            min = 5,
            max = 100,
            message = "O nome deve ter entre ${min} e ${max} caracteres."
    )
    private String name;

    @NotBlank
    @Pattern(
            regexp = "\\d{1,9}",
            message = "Só é permitido um código numérico de até 9 caracteres."
    )
    private String code;

//    private List<ClientDto> clients = new ArrayList<>();
//
//    public List<ClientDto> getClients() {
//        return clients;
//    }
//
//    public void setClients(List<ClientDto> clients) {
//        this.clients = clients;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
