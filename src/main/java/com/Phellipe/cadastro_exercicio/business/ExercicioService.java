package com.Phellipe.cadastro_exercicio.business;

import com.Phellipe.cadastro_exercicio.exception.ExercicioNotFoundException;
import com.Phellipe.cadastro_exercicio.infrastructure.entitys.Exercicio;
import com.Phellipe.cadastro_exercicio.infrastructure.repository.ExercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {

    private final ExercicioRepository repository;

    public ExercicioService(ExercicioRepository repository) {
        this.repository = repository;
    }

    public void criarExercicio(Exercicio exercicio) {
        repository.save(exercicio);
    }

    public Exercicio buscarExercicioPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ExercicioNotFoundException("Exercício não encontrado.")
        );
    }

    public Exercicio buscarExercicioPorNome(String nome) {
        return repository.findByNome(nome).orElseThrow(
                () -> new ExercicioNotFoundException("Exercício não encontrado.")
        );
    }
    public List<Exercicio> buscarExercicioPorGrupoMuscular(String grupoMuscular) {
        return repository.findByGrupoMuscular(grupoMuscular);
    }

    public void deletarExercicioPorId(Long id) {
        if (!repository.existsById(id)) {
            throw new ExercicioNotFoundException("Exercicio não encontrado.");
        }
        repository.deleteById(id);
    };

    public void atualizarExercicioPorId(Long id, Exercicio exercicio) {
        Exercicio exercicioEntity = buscarExercicioPorId(id);

        if (exercicio.getNome() != null) exercicioEntity.setNome(exercicio.getNome());
        if (exercicio.getGrupoMuscular() != null) exercicioEntity.setGrupoMuscular(exercicio.getGrupoMuscular());
        if (exercicio.getSinergistas() != null && !exercicio.getSinergistas().isEmpty()) {
            exercicioEntity.setSinergistas(exercicio.getSinergistas());
        }

        repository.save(exercicioEntity);
    }

}
