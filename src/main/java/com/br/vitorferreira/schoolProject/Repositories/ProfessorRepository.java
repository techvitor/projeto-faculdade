package com.br.vitorferreira.schoolProject.Repositories;

import com.br.vitorferreira.schoolProject.Model.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<ProfessorModel, Long> {
}
