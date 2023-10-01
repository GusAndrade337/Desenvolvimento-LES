package com.chamados.api.mapper;

import com.chamados.api.dto.CreateChamadosRequestDTO;
import com.chamados.api.dto.CreateChamadosResponseDTO;
import com.chamados.api.entity.ChamadosEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-01T10:04:50-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2.1 (Oracle Corporation)"
)
public class ChamadosMapperImpl implements ChamadosMapper {

    @Override
    public CreateChamadosResponseDTO toCreateChamadosResponseDTO(ChamadosEntity input) {
        if ( input == null ) {
            return null;
        }

        CreateChamadosResponseDTO createChamadosResponseDTO = new CreateChamadosResponseDTO();

        return createChamadosResponseDTO;
    }

    @Override
    public ChamadosEntity toChamadosEntity(CreateChamadosRequestDTO input) {
        if ( input == null ) {
            return null;
        }

        ChamadosEntity chamadosEntity = null;

        ChamadosEntity chamadosEntity1 = new ChamadosEntity( chamadosEntity );

        chamadosEntity1.titulo = input.titulo;
        chamadosEntity1.descricao = input.descricao;
        chamadosEntity1.usuario = input.usuario;
        chamadosEntity1.categoriaChamado = input.categoriaChamado;

        return chamadosEntity1;
    }
}
