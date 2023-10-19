package com.chamados.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "categoria_de_chamado")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria_de_chamado")
    private int id;
    @Column(name = "nome")
    public String nome;
    @Column(name = "descrição")
    public String descricao;
    @Column(name = "validade")
    public String validade;
    @Column(name = "id_cesto_de_trabalho")

    public int  workBasketId;

    public CategoriaEntity(CategoriaEntity categoriaEntity) {
        categoriaEntity.id = this.id;
        categoriaEntity.nome = this.nome;
        categoriaEntity.descricao = this.descricao;
        categoriaEntity.validade = this.validade;
        categoriaEntity.workBasketId = this.workBasketId;

    }
}
