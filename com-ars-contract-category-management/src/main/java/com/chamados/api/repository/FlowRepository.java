package com.chamados.api.repository;

import com.chamados.api.entity.CategoriaEntity;
import com.chamados.api.entity.FlowEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowRepository extends JpaRepository<FlowEntity, Integer> {
    Page<FlowEntity> findAll(Pageable paginacao);
}
