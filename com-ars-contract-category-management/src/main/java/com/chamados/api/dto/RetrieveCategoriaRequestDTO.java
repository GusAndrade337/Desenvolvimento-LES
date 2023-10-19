package com.chamados.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RetrieveCategoriaRequestDTO {

    public int id;

    public String nome;
    public String descricao;
    public String validade;
    public int workBasketId;
}
