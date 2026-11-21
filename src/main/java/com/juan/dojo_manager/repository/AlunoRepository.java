package com.juan.dojo_manager.repository;

import com.juan.dojo_manager.models.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {
    boolean existsByEmail(String email);
}
