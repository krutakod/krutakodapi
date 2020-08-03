package krutakod.company.krutakodserver.model;

import javax.persistence.*;

@Entity
public class Solution {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "code_solution")
    private String codeSolution;
    @Column(name = "head")
    private String head;
    @Column(name = "text")
    private String text;

    public Solution() {
    }

    public Solution(String codeSolution, String head, String text) {
        this.codeSolution = codeSolution;
        this.head = head;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeSolution() {
        return codeSolution;
    }

    public void setCodeSolution(String codeSolution) {
        this.codeSolution = codeSolution;
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
        return "Solution{" +
                "id=" + id +
                ", codeSolution='" + codeSolution + '\'' +
                ", head='" + head + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
