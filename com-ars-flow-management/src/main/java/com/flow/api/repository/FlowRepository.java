package com.flow.api.repository;

import com.flow.api.entity.FlowEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowRepository extends JpaRepository<FlowEntity, Integer> {
    Page<FlowEntity> findAll(Pageable paginacao);
}
