package com.juan.dojo_manager.service;

import com.juan.dojo_manager.dto.AlunoFiltroRequest;
import com.juan.dojo_manager.dto.AlunoRequest;
import com.juan.dojo_manager.dto.AlunoResponse;
import com.juan.dojo_manager.exception.RegraNegocioExceprion;
import com.juan.dojo_manager.models.AlunoModel;
import com.juan.dojo_manager.repository.AlunoRepository;
import com.juan.dojo_manager.specification.AlunoSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlunoService {

    public final AlunoRepository alunoRepository;

    public AlunoResponse cadastrarAluno(AlunoRequest alunoRequest) {
        if (alunoRequest.email() != null && alunoRepository.existsByEmail(alunoRequest.email())){
            throw  new RegraNegocioExceprion(("Email já cadastrado"));

        }

        AlunoModel aluno = alunoRequest.toModel();
        AlunoModel alunoSalvo = alunoRepository.save(aluno);
        return AlunoResponse.fromModel(alunoSalvo);
    }

    public Page<AlunoResponse> listarAlunos(AlunoFiltroRequest filtro, Pageable pageable) {
        return alunoRepository.findAll(AlunoSpecification.comFiltro(filtro),
                pageable).map(AlunoResponse::fromModel);
    }

    public AlunoResponse buscarAlunoPorId(Long id) {
        AlunoModel aluno = buscarAlunoModelPorId(id);
        return AlunoResponse.fromModel(aluno);
    }

    public AlunoResponse atualizarAluno(Long id, AlunoRequest alunoRequest) {
        AlunoModel aluno = buscarAlunoModelPorId(id);
        alunoRequest.preencher(aluno);
        AlunoModel alunoAtualizado = alunoRepository.save(aluno);
        return AlunoResponse.fromModel(alunoAtualizado);
    }

    public void deletarAluno(Long id) {
        AlunoModel aluno = buscarAlunoModelPorId(id);
        alunoRepository.delete(aluno);
    }

    private AlunoModel buscarAlunoModelPorId(Long id) {
        return alunoRepository.findById(id).orElseThrow(() -> new RegraNegocioExceprion("Aluno não encontrado"));
    }
}



