package krutakod.company.krutakodserver.repository;


import krutakod.company.krutakodserver.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Lesson, String> {
    Lesson getByCodeLess(String codeLess);
}
