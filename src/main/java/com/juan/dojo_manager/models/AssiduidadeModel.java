package com.juan.dojo_manager.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assiduidade")
public class AssiduidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_entrada")
    private LocalDate dataEntrada;

    @Column(name = "data_saida")
    private LocalDate dataSaida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matricula_id")
    private MatriculaModel matricula;

    @PrePersist
    public void prePersistir() {
        if (dataEntrada == null) {
            dataEntrada = LocalDate.now();
        }
    }
}
