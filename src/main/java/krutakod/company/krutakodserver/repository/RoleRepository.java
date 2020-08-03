package krutakod.company.krutakodserver.repository;

import krutakod.company.krutakodserver.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
