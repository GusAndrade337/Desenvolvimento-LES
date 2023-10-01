package com.chamados.api.repository;

import com.chamados.api.entity.ChamadosEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadosRepository extends JpaRepository<ChamadosEntity, Integer> {
    Page<ChamadosEntity> findAll(Pageable paginacao);
}
