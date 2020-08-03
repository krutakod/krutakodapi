package krutakod.company.krutakodserver.rest;


import krutakod.company.krutakodserver.model.Lesson;
import krutakod.company.krutakodserver.model.LitLesson;
import krutakod.company.krutakodserver.repository.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user/lesson")
public class LessonController {
    private final LessonRepo lessonRepo;

    @Autowired
    public LessonController(LessonRepo lessonRepo) {
        this.lessonRepo = lessonRepo;
    }

    //извлечение всех уроков
    @GetMapping
    public List<Lesson> list(@RequestHeader Map<String, String> headers) {
        if (headers.get("key").equals("cfylfkm12")) return lessonRepo.findAll();
        else return new ArrayList<Lesson>();
    }

    //извлечение урока по его коду
    @GetMapping("codeless/{codeLess}")
    public Lesson getLessByCodeLess(@PathVariable("codeLess")String codeLess,
                                    @RequestHeader Map<String, String> headers){
        if (headers.get("key").equals("cfylfkm12")) return lessonRepo.getByCodeLess(codeLess);
        else return new Lesson();
    }

    //извлечение урока по его теме
    @GetMapping("codetheme/{codeTheme}")
    public Lesson getLessByCodeTheme(@PathVariable("codeTheme")String codeTheme,
                                     @RequestHeader Map<String, String> headers){
        if (headers.get("key").equals("cfylfkm12")) return lessonRepo.getByCodeTheme(codeTheme);
        else return new Lesson();
    }

    //извлечение урока по его заголовку
    @GetMapping("head/{head}")
    public Lesson getLessByHead(@PathVariable("head")String head,
                                @RequestHeader Map<String, String> headers){
        if (headers.get("key").equals("cfylfkm12")) return lessonRepo.getByHead(head);
        else return new Lesson();
    }

    //извлечение урока по его id
    @GetMapping("id/{id}")
    public Lesson getLessByHead(@PathVariable("id")Long id,
                                @RequestHeader Map<String, String> headers){
        if (headers.get("key").equals("cfylfkm12")) return lessonRepo.getById(id);
        else return new Lesson();
    }

//    @GetMapping("{id}")
//    public Lesson getOne(@PathVariable("id") Lesson lesson) {
//        return lesson;
//    }

//    @GetMapping("imgfile/{filename}")
//    public Map<String,Object> getImg(@PathVariable("filename")String filename, Map<String,Object> model){
//        model.put("filename","C:/Users/asdur/Desktop/sweater-JPA_Postgres/src/main/resources/uploads/test_img.jpg");
//        System.out.println(uploadPath+filename);
//        return model;
//    }

//    //создание нового урока
//    @PostMapping("/add")
//    public Lesson create(@RequestBody Lesson lesson) {
//        return lessonRepo.save(lesson);
//    }
//
//    //редактирование урока по его id
//    @PutMapping("update/{id}")
//    public Lesson update(@PathVariable("id") Long id, @RequestBody Lesson lesson) {
//
//        Lesson lessonFromDB = lessonRepo.getById(id);
//        BeanUtils.copyProperties(lesson,lessonFromDB,"id");
//
//        return lessonRepo.save(lessonFromDB);
//    }
//
//    //редактирование урока по его коду
//    @PutMapping("update/{codeLess}")
//    public Lesson updateFromCodeNew(@PathVariable("codeLess") String head, @RequestBody Lesson lesson) {
//
//        Lesson lessonFromDB = lessonRepo.getByCodeLess(head);
//        BeanUtils.copyProperties(lesson,lessonFromDB,"id");
//
//        return lessonRepo.save(lessonFromDB);
//    }
//
//    //редактирование урока по его заголовку
//    @PutMapping("update/{head}")
//    public Lesson updateFromHeadNew(@PathVariable("head") String head, @RequestBody Lesson lesson) {
//
//        Lesson lessonFromDB = lessonRepo.getByCodeLess(head);
//        BeanUtils.copyProperties(lesson,lessonFromDB,"id");
//
//        return lessonRepo.save(lessonFromDB);
//    }
//
//    @DeleteMapping("delete/{id}")
//    public void deleteFromId(@PathVariable("id") Long id) {
//        lessonRepo.delete(lessonRepo.getById(id));
//    }
//
//    //удаление урока по её коду
//    @DeleteMapping("delete/{codeNew}")
//    public void deleteFromCodeLesson(@PathVariable("codeNew") String codeLesson) {
//        lessonRepo.delete(lessonRepo.getByCodeLess(codeLesson));
//    }
//    //удаление урока по её заголовку
//    @DeleteMapping("delete/{head}")
//    public void deleteFromHeadLesson(@PathVariable("head") String head) {
//        lessonRepo.delete(lessonRepo.getByHead(head));
//    }
}



