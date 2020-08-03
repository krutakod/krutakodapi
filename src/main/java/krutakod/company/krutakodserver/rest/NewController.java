package krutakod.company.krutakodserver.rest;


import krutakod.company.krutakodserver.model.New;
import krutakod.company.krutakodserver.repository.NewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user/new")
public class NewController {
    private final NewRepo newRepo;

    @Autowired
    public NewController(NewRepo newRepo){
        this.newRepo=newRepo;
    }

    @GetMapping
    public List<New> list(@RequestHeader Map<String, String> headers){
        if (headers.get("key").equals("cfylfkm12")) return newRepo.findAll();
        else return new ArrayList<New>();
    }
//
//    //извлечение новости по её коду
//    @GetMapping("codenew/{codeNew}")
//    public New getNewByCodeNew(@PathVariable("codeNew")String codeNew,
//                               @RequestHeader Map<String, String> headers){
//        if (headers.get("key").equals("cfylfkm12")) return newRepo.getByCodeNew(codeNew);
//        else return new New();
//    }
//
//    //извлечение новости по её заголовку
//    @GetMapping("head/{head}")
//    public New getNewByHead(@PathVariable("head")String head,
//                            @RequestHeader Map<String, String> headers){
//        if (headers.get("key").equals("cfylfkm12")) return newRepo.getByHead(head);
//        else return new New();
//    }
//    //извлечение новости по её id
//    @GetMapping("id/{id}")
//    public New getLessByHead(@PathVariable("id")Long id,
//                            @RequestHeader Map<String, String> headers){
//        if (headers.get("key").equals("cfylfkm12")) return newRepo.getById(id);
//        else return new New();
//    }

//    //создание новой новости
//    @PostMapping("/add")
//    public New create(@RequestBody New neW) {
//        return newRepo.save(neW);
//    }
//
//    //редактирование новости по её id
//    @PutMapping("update/{id}")
//    public New updateFromId(@PathVariable("id") Long id, @RequestBody New neW) {
//
//        New newFromDB = newRepo.getById(id);
//        BeanUtils.copyProperties(neW,newFromDB,"id");
//
//        return newRepo.save(newFromDB);
//    }
//
//    //редактирование новости по её коду
//    @PutMapping("update/{codeNew}")
//    public New updateFromCodeNew(@PathVariable("codeNew") String codeNew, @RequestBody New neW) {
//
//        New newFromDB = newRepo.getByCodeNew(codeNew);
//        BeanUtils.copyProperties(neW,newFromDB,"id");
//
//        return newRepo.save(newFromDB);
//    }
//
//    //редактирование новости по её заголовку
//    @PutMapping("update/{head}")
//    public New updateFromHeadNew(@PathVariable("head") String head, @RequestBody New neW) {
//
//        New newFromDB = newRepo.getByHead(head);
//        BeanUtils.copyProperties(neW,newFromDB,"id");
//
//        return newRepo.save(newFromDB);
//    }
//
//    //удаление новости по id
//    @DeleteMapping("delete/{id}")
//    public void deleteFromId(@PathVariable("id") Long id) {
//        newRepo.delete(newRepo.getById(id));
//    }
//
//    //удаление новости по её коду
//    @DeleteMapping("delete/{codeNew}")
//    public void deleteFromCodeNew(@PathVariable("codeNew") String codeNew) {
//        newRepo.delete(newRepo.getByCodeNew(codeNew));
//    }
//    //удаление новости по её заголовку
//    @DeleteMapping("delete/{head}")
//    public void deleteFromHeadNew(@PathVariable("head") String head) {
//        newRepo.delete(newRepo.getByHead(head));
//    }
}
