package com.role.api.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cargos")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo")
    private int id;
    @Column(name = "nome")
    public String nome;
    @Column(name = "permissão_adminstrativa")
    public String permissao;


    public RoleEntity(RoleEntity roleEntity) {
        roleEntity.id = this.id;
        roleEntity.nome = this.nome;
        roleEntity.permissao = this.permissao;


    }
}
