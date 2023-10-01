package com.chamados.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "CHAMADO")
public class ChamadosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CHAMADO")
    private int id;
    @Column(name = "TITULO")
    public String titulo;
    @Column(name = "DESCRIÇÃO")
    public String descricao;
    @Column(name = "DATA_CRIAÇÃO")

    public Date dataCriacao;
    @Column(name = "DATA_ATUALIZAÇÃO")

    public Date  dataAtualizacao;
    @Column(name = "ID_USUÁRIO")

    public int usuario;
    @Column(name ="ID_CATEGORIA_DE_CHAMADO" )

    public int categoriaChamado;

    public ChamadosEntity(ChamadosEntity chamadosEntity) {
        chamadosEntity.id = this.id;
        chamadosEntity.titulo = this.titulo;
        chamadosEntity.descricao = this.descricao;
        chamadosEntity.dataAtualizacao = this.dataAtualizacao;
        chamadosEntity.dataCriacao = this.dataCriacao;
        chamadosEntity.usuario = this.usuario;
        chamadosEntity.categoriaChamado = this.categoriaChamado;


    }
}
