package krutakod.company.krutakodserver.model;

import javax.persistence.*;

@Entity
public class LitLesson {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name = "code_less")
    private String codeLess;
    @Column(name = "code_theme")
    private String codeTheme;
    @Column(name = "head")
    private String head;
    @Column(name = "pic")
    private String pic;



    public LitLesson() {
    }

    public LitLesson(String codeLess, String codeTheme, String head, String pic) {
        this.codeLess = codeLess;
        this.codeTheme = codeTheme;
        this.head = head;
        this.pic = pic;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "LitLesson{" +
                "id=" + id +
                ", codeLess='" + codeLess + '\'' +
                ", codeTheme='" + codeTheme + '\'' +
                ", head='" + head + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
