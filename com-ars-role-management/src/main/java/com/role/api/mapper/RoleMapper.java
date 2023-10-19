package com.role.api.mapper;

import com.role.api.dto.RetrieveRoleRequestDTO;
import com.role.api.entity.RoleEntity;
import com.role.api.dto.CreateRoleRequestDTO;
import com.role.api.dto.CreateRoleResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RoleMapper {

    public RetrieveRoleRequestDTO toResponseGet(RoleEntity entity) {

        if (Objects.isNull(entity)) return null;

        var response =
                RetrieveRoleRequestDTO.builder()
                        .id(entity.getId())
                        .nome(entity.getNome())
                        .permissao(entity.getPermissao())
                        .build();
        return response;
    }

    public Page<RetrieveRoleRequestDTO> toResponseGetPageable(
            Page<RoleEntity> entityPage) {

        if (Objects.isNull(entityPage)) return null;

        return entityPage.map(this::toResponseGet);
    }

    public CreateRoleResponseDTO toResponsePost(RoleEntity entity) {

        if (Objects.isNull(entity)) return null;

        var response = CreateRoleResponseDTO.builder().id(entity.getId()).build();

        return response;
    }

    public RoleEntity toEntity(CreateRoleRequestDTO request) {
        if (Objects.isNull(request)) {
            return null;
        } else {
            return RoleEntity.builder()
                    .nome(request.getNome())
                    .permissao(request.getPermissao())
                    .build();
        }
    }
}
