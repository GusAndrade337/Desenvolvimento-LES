package com.chamados.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RetrieveChamadosRequestDTO {

    public int id;


    public String titulo;
    public String descricao;
    public int usuario;
    public int categoriaChamado;
}
