package krutakod.company.krutakodserver.repository;

import krutakod.company.krutakodserver.model.LitLesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LitLessonRepo extends JpaRepository<LitLesson, Long> {
    LitLesson getByCodeLess(String codeLess);
    LitLesson getByCodeTheme(String codeTheme);
    LitLesson getByHead(String head);
    LitLesson getById(Long id);
    List<LitLesson> getAllByCodeTheme(String codeTheme);
}


