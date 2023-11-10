package com.chamados.api.repository;

import com.chamados.api.entity.CategoriaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {
    Page<CategoriaEntity> findAll(Pageable paginacao);
}
