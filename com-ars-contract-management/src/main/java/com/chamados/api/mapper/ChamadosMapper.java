package com.chamados.api.mapper;

import com.chamados.api.dto.CreateChamadosRequestDTO;
import com.chamados.api.dto.CreateChamadosResponseDTO;
import com.chamados.api.dto.RetrieveChamadosRequestDTO;
import com.chamados.api.entity.ChamadosEntity;
import com.chamados.api.entity.UsuariosEntity;
import com.chamados.api.repository.CategoriaRepository;
import com.chamados.api.repository.UsuariosRepository;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ChamadosMapper {

    @Autowired
    UsuariosRepository usuariosRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    public RetrieveChamadosRequestDTO toResponseGet(ChamadosEntity entity) {

        if (Objects.isNull(entity)) return null;

        var response =
                RetrieveChamadosRequestDTO.builder()
                        .id(entity.getId())
                        .titulo(entity.getTitulo())
                        .descricao(entity.getDescricao())
                        .usuario(usuariosRepository.findById(entity.getUsuario()).get().nome)
                        .categoriaChamado(categoriaRepository.findById(entity.getCategoriaChamado()).get().nome)
                        .build();
        return response;
    }

    public Page<RetrieveChamadosRequestDTO> toResponseGetPageable(
            Page<ChamadosEntity> entityPage) {

        if (Objects.isNull(entityPage)) return null;

        return entityPage.map(this::toResponseGet);
    }

    public CreateChamadosResponseDTO toResponsePost(ChamadosEntity entity) {

        if (Objects.isNull(entity)) return null;

        var response = CreateChamadosResponseDTO.builder().id(entity.getId()).build();

        return response;
    }

    public ChamadosEntity toEntity(CreateChamadosRequestDTO request) {
        if (Objects.isNull(request)) {
            return null;
        } else {
            return ChamadosEntity.builder()
                    .titulo(request.getTitulo())
                    .descricao(request.getDescricao())
                    .usuario(request.getUsuario())
                    .categoriaChamado(request.getCategoriaChamado())
                    .build();
        }
    }
}
