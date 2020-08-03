package krutakod.company.krutakodserver.repository;

import krutakod.company.krutakodserver.model.New;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepo extends JpaRepository<New, Long> {
//    New getByCodeNew(String codeNew);
//    New getByHead(String head);
    New getById(Long id);
}
