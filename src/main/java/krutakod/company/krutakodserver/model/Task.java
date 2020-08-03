package krutakod.company.krutakodserver.model;

import javax.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "code_task")
    private String codeTask;
    @Column(name = "head")
    private String head;
    @Column(name = "text")
    private String text;

    public Task() {
    }

    public Task(String codeTask, String head, String text) {
        this.codeTask = codeTask;
        this.head = head;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeTask() {
        return codeTask;
    }

    public void setCodeTask(String codeTask) {
        this.codeTask = codeTask;
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
        return "Task{" +
                "id=" + id +
                ", codeTask='" + codeTask + '\'' +
                ", head='" + head + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
