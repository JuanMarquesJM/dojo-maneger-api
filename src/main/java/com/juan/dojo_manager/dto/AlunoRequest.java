package com.juan.dojo_manager.dto;

import com.juan.dojo_manager.models.AlunoModel;

import java.time.LocalDate;

public record AlunoRequest(
        String nome,
        LocalDate dataNascimento,
        String sexo,
        String telefone,
        String celular,
        String email,
        String observacao,
        String endereco,
        String numero,
        String bairro,
        String complemento,
        String cidade,
        String estado,
        String cep
) {

    public AlunoModel toModel(){
        AlunoModel aluno = new AlunoModel();
        preencher(aluno);
        return aluno;
    }

    public void preencher(AlunoModel aluno){
        aluno.setNome(nome);
        aluno.setDataNascimento(dataNascimento);
        aluno.setSexo(sexo);
        aluno.setTelefone(telefone);
        aluno.setCelular(celular);
        aluno.setEmail(email);
        aluno.setObservacao(observacao);
        aluno.setEndereco(endereco);
        aluno.setNumero(numero);
        aluno.setBairro(bairro);
        aluno.setComplemento(complemento);
        aluno.setCidade(cidade);
        aluno.setEstado(estado);
        aluno.setCep(cep);
    }
}
