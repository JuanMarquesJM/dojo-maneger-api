package com.juan.dojo_manager.specification;

import com.juan.dojo_manager.dto.AlunoFiltroRequest;
import com.juan.dojo_manager.models.AlunoModel;
import org.springframework.data.jpa.domain.Specification;

public class AlunoSpecification {

    public static Specification<AlunoModel> comFiltro(AlunoFiltroRequest filtro) {
        return Specification
                .where(nomeContem(filtro.nome()))
                .and(emailContem(filtro.email()))
                .and(celularContem(filtro.celular()))
                .and(cidadeContem(filtro.cidade()))
                .and(estadoIgual(filtro.estado()));
    }

    private static Specification<AlunoModel> nomeContem(String nome) {
        return (root, query, cb) -> {
            if (nome == null || nome.isBlank()) {
                return null;
            }
            return cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
        };
    }

    private static Specification<AlunoModel> emailContem(String email) {
        return (root, query, cb) -> {
            if (email == null || email.isBlank()) {
                return null;
            }
            return cb.like(cb.lower(root.get("email")), "%" + email.toLowerCase() + "%");
        };
    }

    private static Specification<AlunoModel> celularContem(String celular) {
        return (root, query, cb) -> {
            if (celular == null || celular.isBlank()) {
                return null;
            }
            return cb.like(cb.lower(root.get("celular")), "%" + celular.toLowerCase() + "%");
        };
    }

    private static Specification<AlunoModel> cidadeContem(String cidade) {
        return (root, query, cb) -> {
            if (cidade == null || cidade.isBlank()) {
                return null;
            }
            return cb.like(cb.lower(root.get("cidade")), "%" + cidade.toLowerCase() + "%");
        };
    }
    private static Specification<AlunoModel> estadoIgual(String estado) {
        return (root, query, cb) -> {
            if (estado == null || estado.isBlank()) {
                return null;
            }
            return cb.equal(cb.upper(root.get("estado")), estado.toUpperCase());
        };
    }
}