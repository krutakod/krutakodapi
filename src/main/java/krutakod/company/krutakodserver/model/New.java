package krutakod.company.krutakodserver.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class New {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "text")
    private String text;
    @Column(name="img_path")
    private String imgPath;
    @Column(name="type")
    private String type;


}
