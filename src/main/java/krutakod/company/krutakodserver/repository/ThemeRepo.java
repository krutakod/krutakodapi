package krutakod.company.krutakodserver.repository;

import krutakod.company.krutakodserver.model.New;
import krutakod.company.krutakodserver.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThemeRepo extends JpaRepository<Theme, Long> {
    Theme getByCodeTheme(String codeTheme);
    Theme getByHead(String head);
    Theme getById(Long id);
}
