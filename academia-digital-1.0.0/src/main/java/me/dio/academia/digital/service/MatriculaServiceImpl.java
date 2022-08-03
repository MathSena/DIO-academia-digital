package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
        matricula.setAluno(aluno);

        return matriculaRepository.save(matricula);

    }

    @Override
    public Matricula get(Long id) {
        return matriculaRepository.findById(id).get();
    }

    public List<Matricula> getAll() {
        return matriculaRepository.findAll();
    }

    @Override
    public void delete(Long id) {

    }
}
