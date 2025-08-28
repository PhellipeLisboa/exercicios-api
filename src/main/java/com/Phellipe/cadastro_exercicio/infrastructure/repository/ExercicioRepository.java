package com.Phellipe.cadastro_exercicio.infrastructure.repository;

import com.Phellipe.cadastro_exercicio.infrastructure.entitys.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    Optional<Exercicio> findByNome(String nome);

    List<Exercicio> findByGrupoMuscular(String grupoMuscular);

}
