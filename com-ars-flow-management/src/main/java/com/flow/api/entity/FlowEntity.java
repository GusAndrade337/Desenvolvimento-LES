package com.flow.api.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "estados_de_trabalho")
public class FlowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private int id;
    @Column(name = "nome")
    public String nome;
    @Column(name = "descrição")
    public String descricao;


    public FlowEntity(FlowEntity flowEntity) {
        flowEntity.id = this.id;
        flowEntity.nome = this.nome;
        flowEntity.descricao = this.descricao;


    }
}
