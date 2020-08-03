package krutakod.company.krutakodserver.repository;

import krutakod.company.krutakodserver.model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionRepo extends JpaRepository<Solution, Long> {
    Solution getByCodeSolution(String codeLess);
    Solution getByHead(String head);
    Solution getById(Long id);
}
