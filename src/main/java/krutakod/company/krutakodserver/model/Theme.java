package krutakod.company.krutakodserver.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "theme")
@Data
public class Theme {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "code_theme")
    private String codeTheme;
    @Column(name = "head")
    private String head;
    @Column(name = "pic")
    private String pic;


}
