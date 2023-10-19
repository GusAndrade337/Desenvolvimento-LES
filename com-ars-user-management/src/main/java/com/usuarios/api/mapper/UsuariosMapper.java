package com.usuarios.api.mapper;

import com.usuarios.api.dto.CreateUsuariosRequestDTO;
import com.usuarios.api.dto.CreateUsuariosResponseDTO;
import com.usuarios.api.dto.RetrieveUsuariosRequestDTO;
import com.usuarios.api.entity.UsuariosEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsuariosMapper {

    public RetrieveUsuariosRequestDTO toResponseGet(UsuariosEntity entity) {

        if (Objects.isNull(entity)) return null;

        var response =
                RetrieveUsuariosRequestDTO.builder()
                        .id(entity.getId())
                        .nome(entity.getNome())
                        .email(entity.getEmail())
                        .id_cargo(entity.getId_cargo())
                        .build();
        return response;
    }

    public Page<RetrieveUsuariosRequestDTO> toResponseGetPageable(
            Page<UsuariosEntity> entityPage) {

        if (Objects.isNull(entityPage)) return null;

        return entityPage.map(this::toResponseGet);
    }

    public CreateUsuariosResponseDTO toResponsePost(UsuariosEntity entity) {

        if (Objects.isNull(entity)) return null;

        var response = CreateUsuariosResponseDTO.builder().id(entity.getId()).build();

        return response;
    }

    public UsuariosEntity toEntity(CreateUsuariosRequestDTO request) {
        if (Objects.isNull(request)) {
            return null;
        } else {
            return UsuariosEntity.builder()
                    .nome(request.getNome())
                    .email(request.getEmail())
                    .id_cargo(request.getId_cargo())
                    .build();
        }
    }
}
