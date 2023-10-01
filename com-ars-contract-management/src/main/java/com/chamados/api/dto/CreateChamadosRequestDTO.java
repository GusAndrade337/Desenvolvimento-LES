package com.chamados.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateChamadosRequestDTO {

    @NotBlank
    @NotNull
    public String titulo;
    public String descricao;
    @NotNull
    public int usuario;
    @NotNull
    public int categoriaChamado;
}
