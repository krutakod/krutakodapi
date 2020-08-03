package krutakod.company.krutakodserver.rest;

import krutakod.company.krutakodserver.model.Task;
import krutakod.company.krutakodserver.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user/task")
public class TaskController {
    private final TaskRepo task;

    @Autowired
    public TaskController(TaskRepo task){
        this.task=task;
    }

    @GetMapping
    public List<Task> list(@RequestHeader Map<String, String> headers){
        if (headers.get("key").equals("cfylfkm12")) return task.findAll();
        else return new ArrayList<Task>();
    }

    //извлечение новости по её коду
    @GetMapping("codetask/{codeTask}")
    public Task getNewByCodeNew(@PathVariable("codeTask")String codeTask, @RequestHeader Map<String, String> headers){
        if (headers.get("key").equals("cfylfkm12")){
            return task.getByCodeTask(codeTask);
        } else return new Task();

    }

    //извлечение новости по её заголовку
    @GetMapping("head/{head}")
    public Task getNewByHead(@PathVariable("head")String head,@RequestHeader Map<String, String> headers){
        if (headers.get("key").equals("cfylfkm12")) return task.getByHead(head);
        else return new Task();
    }
    //извлечение новости по её id
    @GetMapping("id/{id}")
    public Task getLessByHead(@PathVariable("id")Long id,@RequestHeader Map<String, String> headers){
        if (headers.get("key").equals("cfylfkm12")) return task.getById(id);
        else return new Task();
    }

//    //создание новой новости
//    @PostMapping("/add")
//    public Task create(@RequestBody Task newTask) {
//        return task.save(newTask);
//    }
//
//    //редактирование новости по её id
//    @PutMapping("update/{id}")
//    public Task updateFromId(@PathVariable("id") Long id, @RequestBody Task upTask) {
//
//        Task taskFromDB = task.getById(id);
//        BeanUtils.copyProperties(upTask,taskFromDB,"id");
//
//        return task.save(taskFromDB);
//    }
//
//    //редактирование новости по её коду
//    @PutMapping("update/{codeTask}")
//    public Task updateFromCodeNew(@PathVariable("codeTask") String codeTask, @RequestBody Task neW) {
//
//        Task taskFromDB = task.getByCodeTask(codeTask);
//        BeanUtils.copyProperties(neW,taskFromDB,"id");
//
//        return task.save(taskFromDB);
//    }
//
//    //редактирование новости по её заголовку
//    @PutMapping("update/{head}")
//    public Task updateFromHeadNew(@PathVariable("head") String head, @RequestBody Task neW) {
//
//        Task newFromDB = task.getByHead(head);
//        BeanUtils.copyProperties(neW,newFromDB,"id");
//
//        return task.save(newFromDB);
//    }
//
//    //удаление новости по id
//    @DeleteMapping("delete/{id}")
//    public void deleteFromId(@PathVariable("id") Long id) {
//        task.delete(task.getById(id));
//    }
//
//    //удаление новости по её коду
//    @DeleteMapping("delete/{codeTask}")
//    public void deleteFromCodeNew(@PathVariable("codeTask") String codeTask) {
//        task.delete(task.getByCodeTask(codeTask));
//    }
//    //удаление новости по её заголовку
//    @DeleteMapping("delete/{head}")
//    public void deleteFromHeadNew(@PathVariable("head") String head) {
//        task.delete(task.getByHead(head));
//    }
}
