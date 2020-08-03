package krutakod.company.krutakodserver.repository;


import krutakod.company.krutakodserver.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
    Task getByCodeTask(String codeLess);
    Task getByHead(String head);
    Task getById(Long id);
}
