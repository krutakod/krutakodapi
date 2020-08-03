package krutakod.company.krutakodserver.repository;

import krutakod.company.krutakodserver.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepo extends JpaRepository<Lesson, Long> {
    Lesson getByCodeLess(String codeLess);
    Lesson getByCodeTheme(String codeTheme);
    Lesson getByHead(String head);
    Lesson getById(Long id);
}
