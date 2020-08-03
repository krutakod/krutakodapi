package krutakod.company.krutakodserver.rest;

import krutakod.company.krutakodserver.model.LitLesson;
import krutakod.company.krutakodserver.repository.LitLessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user/litlesson")
public class LitLessonController {
    private final LitLessonRepo lessonRepo;

    @Autowired
    public LitLessonController(LitLessonRepo LessonRepo) {
        this.lessonRepo = LessonRepo;
    }

    //извлечение всех уроков
    @GetMapping
    public List<LitLesson> list(@RequestHeader Map<String, String> headers) {
        if (headers.get("key").equals("cfylfkm12")) {
            List<LitLesson> all = lessonRepo.findAll();
            Collections.reverse(all);
            return all;
        }
        else return new ArrayList<LitLesson>();
    }

    //извлечение урока по его коду
    @GetMapping("codeless/{codeLess}")
    public LitLesson getLessByCodeLess(@PathVariable("codeLess")String codeLess,
                                       @RequestHeader Map<String, String> headers){
        if (headers.get("key").equals("cfylfkm12")) return lessonRepo.getByCodeLess(codeLess);
        else return new LitLesson();
    }

    //извлечение урока по его теме
    @GetMapping("codetheme/{codeTheme}")
    public LitLesson getLessByCodeTheme(@PathVariable("codeTheme")String codeTheme,
                                        @RequestHeader Map<String, String> headers){
        if (headers.get("key").equals("cfylfkm12")) return lessonRepo.getByCodeTheme(codeTheme);
        else return new LitLesson();
    }

    //извлечение урока по его заголовку
    @GetMapping("head/{head}")
    public LitLesson getLessByHead(@PathVariable("head")String head,
                                   @RequestHeader Map<String, String> headers){
        if (headers.get("key").equals("cfylfkm12")) return lessonRepo.getByHead(head);
        else return new LitLesson();
    }

    //извлечение урока по его id
    @GetMapping("id/{id}")
    public LitLesson getLessByHead(@PathVariable("id")Long id,
                                   @RequestHeader Map<String, String> headers){
        if (headers.get("key").equals("cfylfkm12")) return lessonRepo.getById(id);
        else return new LitLesson();
    }

    @GetMapping("all/codetheme/{codeTheme}")
    public List<LitLesson> getAllLessByCodeTheme(@PathVariable("codeTheme")String codeTheme,
                                                 @RequestHeader Map<String, String> headers){
        if (headers.get("key").equals("cfylfkm12")) return lessonRepo.getAllByCodeTheme(codeTheme);
        else return new ArrayList<LitLesson>();
    }
//    //создание нового урока
//    @PostMapping("/add")
//    public LitLesson create(@RequestBody LitLesson lesson) {
//        return lessonRepo.save(lesson);
//    }
//
//    //редактирование урока по его id
//    @PutMapping("update/{id}")
//    public LitLesson update(@PathVariable("id") Long id, @RequestBody LitLesson lesson) {
//
//        LitLesson lessonFromDB = lessonRepo.getById(id);
//        BeanUtils.copyProperties(lesson,lessonFromDB,"id");
//
//        return lessonRepo.save(lessonFromDB);
//    }
//
//    //редактирование урока по его коду
//    @PutMapping("update/{codeLess}")
//    public LitLesson updateFromCodeNew(@PathVariable("codeLess") String head, @RequestBody LitLesson lesson) {
//
//        LitLesson lessonFromDB = lessonRepo.getByCodeLess(head);
//        BeanUtils.copyProperties(lesson,lessonFromDB,"id");
//
//        return lessonRepo.save(lessonFromDB);
//    }
//
//    //редактирование урока по его заголовку
//    @PutMapping("update/{head}")
//    public LitLesson updateFromHeadNew(@PathVariable("head") String head, @RequestBody LitLesson lesson) {
//
//        LitLesson lessonFromDB = lessonRepo.getByCodeLess(head);
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
