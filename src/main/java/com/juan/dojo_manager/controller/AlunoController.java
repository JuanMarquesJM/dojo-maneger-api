package com.juan.dojo_manager.controller;

import com.juan.dojo_manager.dto.AlunoRequest;
import com.juan.dojo_manager.dto.AlunoResponse;
import com.juan.dojo_manager.service.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
@AllArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoResponse cadastrarAluno(@RequestBody AlunoRequest alunoRequest) {
        return alunoService.cadastrarAluno(alunoRequest);
    }

    @GetMapping
    public Page<AlunoResponse> listarAlunos(Pageable pageable) {
        return alunoService.listarAlunos(pageable);
    }

    @GetMapping("/{id}")
    public AlunoResponse buscarAlunoPorId(@PathVariable Long id) {
        return alunoService.buscarAlunoPorId(id);
    }

    @PutMapping("/{id}")
    public AlunoResponse atualizarAluno(@PathVariable Long id, @RequestBody AlunoRequest alunoRequest) {
        return alunoService.atualizarAluno(id, alunoRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
    }
}
