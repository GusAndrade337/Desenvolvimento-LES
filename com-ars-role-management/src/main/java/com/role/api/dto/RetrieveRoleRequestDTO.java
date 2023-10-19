package com.role.api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RetrieveRoleRequestDTO {

    public int id;
    public String nome;
    public String permissao;

}
