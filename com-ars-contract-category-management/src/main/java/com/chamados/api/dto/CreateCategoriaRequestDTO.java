package com.chamados.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoriaRequestDTO {

    @NotBlank
    @NotNull
    public String nome;
    public String descricao;
    @NotNull
    public String validade;
    @NotNull
    public int workBasketId;
}
