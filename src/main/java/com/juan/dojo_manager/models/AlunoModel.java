package com.juan.dojo_manager.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "alunos")
public class AlunoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "sexo", length = 1)
    private String sexo;
    private String telefone;
    private String celular;
    private String email;
    private String observacao;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;

    @Column(name = "estado", length = 2)
    private String estado;
    private String cep;

    @Column(name = "criado_em")
    private LocalDate criadoEm;

    @Column(name = "atualizado_em")
    private LocalDate atualizadoEm;

    @PrePersist
    public void prePersist() {
        criadoEm = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        atualizadoEm = LocalDate.now();
    }

}
