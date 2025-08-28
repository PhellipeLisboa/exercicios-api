package com.Phellipe.cadastro_exercicio.controller;

import com.Phellipe.cadastro_exercicio.business.ExercicioService;
import com.Phellipe.cadastro_exercicio.infrastructure.entitys.Exercicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
@RequiredArgsConstructor
public class ExercicioController {

    private final ExercicioService exercicioService;

    @PostMapping
    public ResponseEntity<Void> criarExercicio(@RequestBody Exercicio exercicio) {
        exercicioService.criarExercicio(exercicio);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Exercicio> buscarExercicioPorId(@PathVariable Long id) {
        return ResponseEntity.ok(exercicioService.buscarExercicioPorId(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Exercicio> buscarExercicioPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(exercicioService.buscarExercicioPorNome(nome));
    }

    @GetMapping("/grupo-muscular/{grupoMuscular}")
    public ResponseEntity<List<Exercicio>> buscarExercicioPorGrupoMuscular(@PathVariable String grupoMuscular) {
        return ResponseEntity.ok(exercicioService.buscarExercicioPorGrupoMuscular(grupoMuscular));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarExercicioPorId(@PathVariable Long id) {
        exercicioService.deletarExercicioPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarExercicioPorId(@PathVariable Long id,
                                                        @RequestBody Exercicio exercicio) {
        exercicioService.atualizarExercicioPorId(id, exercicio);
        return ResponseEntity.ok().build();
    }

}
