package krutakod.company.krutakodserver.model;

import javax.persistence.*;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "code_less")
    private String codeLess;
    @Column(name = "code_theme")
    private String codeTheme;
    @Column(name = "head")
    private String head;
    @Column(name = "text")
    private String text;



    public Lesson() {
    }

    public Lesson(String code_less, String code_theme, String head, String text) {
        this.codeLess = code_less;
        this.codeTheme = code_theme;
        this.head = head;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCodeLess() {
        return codeLess;
    }

    public void setCodeLess(String codeLess) {
        this.codeLess = codeLess;
    }

    public String getCodeTheme() {
        return codeTheme;
    }

    public void setCodeTheme(String codeTheme) {
        this.codeTheme = codeTheme;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", codeLess='" + codeLess + '\'' +
                ", codeTheme='" + codeTheme + '\'' +
                ", head='" + head + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
