package com.chamados.api.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "fluxo_de_trabalho")
public class FlowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fluxo_de_trabalho")
    private int flowId;
    @Column(name = "id_estado_origem")
    private int id_origin;

    @Column(name = "id_estado_destino")
    private int id_destination;

    @Column(name = "id_categoria_de_chamado")
    private int id;

    public FlowEntity(FlowEntity flowEntity) {
        flowEntity.id = this.id;
        flowEntity.flowId = this.flowId;
        flowEntity.id_origin = this.id_origin;
        flowEntity.id_destination = this.id_destination;



    }
}
