package com.usuarios.api.dto;

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
public class CreateUsuariosRequestDTO {

    @NotBlank
    @NotNull
    public String nome;
    public String email;
    @NotNull
    public int id_cargo;
}
