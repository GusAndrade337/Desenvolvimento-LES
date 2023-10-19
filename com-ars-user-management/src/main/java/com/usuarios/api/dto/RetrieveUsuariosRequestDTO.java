package com.usuarios.api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RetrieveUsuariosRequestDTO {

    public int id;
    public String nome;
    public String email;
    public int id_cargo;

}
