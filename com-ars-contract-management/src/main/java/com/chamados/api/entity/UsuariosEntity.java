package com.chamados.api.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usuário")
public class UsuariosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuário")
    private int id;
    @Column(name = "nome")
    public String nome;
    @Column(name = "email")
    public String email;
    @Column(name = "id_cargo")

    public int id_cargo;

    public UsuariosEntity(UsuariosEntity usuariosEntity) {
        usuariosEntity.id = this.id;
        usuariosEntity.nome = this.nome;
        usuariosEntity.email = this.email;
        usuariosEntity.id_cargo = this.id_cargo;


    }
}
