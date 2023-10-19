package com.workbasket.api.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cesto_de_trabalho")
public class WorkbasketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cesto_de_trabalho")
    private int id;
    @Column(name = "nome")
    public String nome;
    @Column(name = "descrição")
    public String descricao;


    public WorkbasketEntity(WorkbasketEntity workbasketEntity) {
        workbasketEntity.id = this.id;
        workbasketEntity.nome = this.nome;
        workbasketEntity.descricao = this.descricao;


    }
}
