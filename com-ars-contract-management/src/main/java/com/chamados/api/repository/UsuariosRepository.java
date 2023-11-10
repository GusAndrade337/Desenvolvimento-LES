package com.chamados.api.repository;

import com.chamados.api.entity.UsuariosEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Integer> {
    Page<UsuariosEntity> findAll(Pageable paginacao);
}
