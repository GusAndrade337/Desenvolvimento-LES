package com.role.api.repository;

import com.role.api.entity.RoleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    Page<RoleEntity> findAll(Pageable paginacao);
}
