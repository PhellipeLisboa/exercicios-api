package com.Phellipe.cadastro_exercicio.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "exercicios")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(nullable = false)
    private String grupoMuscular;

    //Column(nullable = false)
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "exercicio_sinergistas",
            joinColumns = @JoinColumn(name = "exercicio_id")
    )
    @Column(name = "sinergista", nullable = false)
    private List<String> sinergistas = new ArrayList<>();

}
