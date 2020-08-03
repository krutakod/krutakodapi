package krutakod.company.krutakodserver.repository;

import krutakod.company.krutakodserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
