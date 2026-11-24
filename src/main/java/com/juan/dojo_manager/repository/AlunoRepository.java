package com.juan.dojo_manager.repository;

import com.juan.dojo_manager.models.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AlunoRepository extends JpaRepository<AlunoModel, Long>, JpaSpecificationExecutor<AlunoModel> {
    boolean existsByEmail(String email);
}
