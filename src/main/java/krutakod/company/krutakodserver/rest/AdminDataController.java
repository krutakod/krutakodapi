package krutakod.company.krutakodserver.rest;


import krutakod.company.krutakodserver.model.*;
import krutakod.company.krutakodserver.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/data")
public class AdminDataController {
    private final LessonRepo lessonRepo;
    private final LitLessonRepo litlessonRepo;
    private final NewRepo newRepo;
    private final SolutionRepo solutionRepo;
    private final TaskRepo task;
    private final ThemeRepo themeRepo;

    public AdminDataController(LessonRepo lessonRepo, LitLessonRepo litlessonRepo, NewRepo newRepo, SolutionRepo solutionRepo, TaskRepo task, ThemeRepo themeRepo) {
        this.lessonRepo = lessonRepo;
        this.litlessonRepo = litlessonRepo;
        this.newRepo = newRepo;
        this.solutionRepo = solutionRepo;
        this.task = task;
        this.themeRepo = themeRepo;
    }

    //создание нового урока
    @PostMapping("lesson/add")
    public Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonRepo.save(lesson);
    }

    //редактирование урока по его id
    @PutMapping("lesson/update/id/{id}")
    public Lesson update(@PathVariable("id") Long id, @RequestBody Lesson lesson) {

        Lesson lessonFromDB = lessonRepo.getById(id);
        BeanUtils.copyProperties(lesson,lessonFromDB,"id");

        return lessonRepo.save(lessonFromDB);
    }

    //редактирование урока по его коду
    @PutMapping("lesson/update/codeless/{codeLess}")
    public Lesson updateFromCodeNew(@PathVariable("codeLess") String head, @RequestBody Lesson lesson) {

        Lesson lessonFromDB = lessonRepo.getByCodeLess(head);
        BeanUtils.copyProperties(lesson,lessonFromDB,"id");

        return lessonRepo.save(lessonFromDB);
    }

    //редактирование урока по его заголовку
    @PutMapping("lesson/update/head/{head}")
    public Lesson updateFromHeadNew(@PathVariable("head") String head, @RequestBody Lesson lesson) {

        Lesson lessonFromDB = lessonRepo.getByCodeLess(head);
        BeanUtils.copyProperties(lesson,lessonFromDB,"id");

        return lessonRepo.save(lessonFromDB);
    }


    @DeleteMapping("lesson/delete/id/{id}")
    public void deleteFromId(@PathVariable("id") Long id) {
        lessonRepo.delete(lessonRepo.getById(id));
    }

    //удаление урока по её коду
    @DeleteMapping("lesson/delete/codenew/{codeNew}")
    public void deleteFromCodeLesson(@PathVariable("codeNew") String codeLesson) {
        lessonRepo.delete(lessonRepo.getByCodeLess(codeLesson));
    }
    //удаление урока по её заголовку
    @DeleteMapping("lesson/delete/head/{head}")
    public void deleteFromHeadLesson(@PathVariable("head") String head) {
        lessonRepo.delete(lessonRepo.getByHead(head));
    }

    //создание нового урока
    @PostMapping("litlesson/add")
    public LitLesson createLitLesson(@RequestBody LitLesson lesson) {
        return litlessonRepo.save(lesson);
    }

    //редактирование урока по его id
    @PutMapping("litlesson/update/id/{id}")
    public LitLesson updateLitLesson(@PathVariable("id") Long id, @RequestBody LitLesson lesson) {

        LitLesson lessonFromDB = litlessonRepo.getById(id);
        BeanUtils.copyProperties(lesson,lessonFromDB,"id");
""
        return litlessonRepo.save(lessonFromDB);
    }

    //редактирование урока по его коду
    @PutMapping("litlesson/update/codeless/{codeLess}")
    public LitLesson updateFromCodeLitLesson(@PathVariable("codeLess") String head, @RequestBody LitLesson lesson) {

        LitLesson lessonFromDB = litlessonRepo.getByCodeLess(head);
        BeanUtils.copyProperties(lesson,lessonFromDB,"id");

        return litlessonRepo.save(lessonFromDB);
    }

    //редактирование урока по его заголовку
    @PutMapping("litlesson/update/head/{head}")
    public LitLesson updateFromHeadLitLesson(@PathVariable("head") String head, @RequestBody LitLesson lesson) {

        LitLesson lessonFromDB = litlessonRepo.getByCodeLess(head);
        BeanUtils.copyProperties(lesson,lessonFromDB,"id");

        return litlessonRepo.save(lessonFromDB);
    }

    @DeleteMapping("litlesson/delete/id/{id}")
    public void deleteFromIdLitLesson(@PathVariable("id") Long id) {
        litlessonRepo.delete(litlessonRepo.getById(id));
    }

    //удаление урока по её коду
    @DeleteMapping("litlesson/delete/codenew/{codeNew}")
    public void deleteFromCodeLitLesson(@PathVariable("codeNew") String codeLesson) {
        litlessonRepo.delete(litlessonRepo.getByCodeLess(codeLesson));
    }
    //удаление урока по её заголовку
    @DeleteMapping("litlesson/delete/head/{head}")
    public void deleteFromHeadLitLesson(@PathVariable("head") String head) {
        litlessonRepo.delete(litlessonRepo.getByHead(head));
    }

    //создание новой новости
    @PostMapping("new/add")
    public New createNew(@RequestBody New neW) {
        return newRepo.save(neW);
    }

    //редактирование новости по её id
    @PutMapping("new/update/id/{id}")
    public New updateFromIdNew(@PathVariable("id") Long id, @RequestBody New neW) {

        New newFromDB = newRepo.getById(id);
        BeanUtils.copyProperties(neW,newFromDB,"id");

        return newRepo.save(newFromDB);
    }

//    //редактирование новости по её коду
//    @PutMapping("new/update/codenew/{codeNew}")
//    public New updateFromCodeNew(@PathVariable("codeNew") String codeNew, @RequestBody New neW) {
//
//        New newFromDB = newRepo.getByCodeNew(codeNew);
//        BeanUtils.copyProperties(neW,newFromDB,"id");
//
//        return newRepo.save(newFromDB);
//    }
//
//    //редактирование новости по её заголовку
//    @PutMapping("new/update/head/{head}")
//    public New updateFromHeadNew(@PathVariable("head") String head, @RequestBody New neW) {
//
//        New newFromDB = newRepo.getByHead(head);
//        BeanUtils.copyProperties(neW,newFromDB,"id");
//
//        return newRepo.save(newFromDB);
//    }

    //удаление новости по id
    @DeleteMapping("new/delete/id/{id}")
    public void deleteFromIdNew(@PathVariable("id") Long id) {
        newRepo.delete(newRepo.getById(id));
    }

//    //удаление новости по её коду
//    @DeleteMapping("new/delete/codenew/{codeNew}")
//    public void deleteFromCodeNew(@PathVariable("codeNew") String codeNew) {
//        newRepo.delete(newRepo.getByCodeNew(codeNew));
//    }
    //удаление новости по её заголовку
//    @DeleteMapping("new/delete/head/{head}")
//    public void deleteFromHeadNew(@PathVariable("head") String head) {
//        newRepo.delete(newRepo.getByHead(head));
//    }

    //создание новой новости
    @PostMapping("solution/add")
    public Solution createSolution(@RequestBody Solution solution) {
        return solutionRepo.save(solution);
    }

    //редактирование новости по её id
    @PutMapping("solution/update/id/{id}")
    public Solution updateFromIdSolution(@PathVariable("id") Long id, @RequestBody Solution solution) {

        Solution solutionFromDB = solutionRepo.getById(id);
        BeanUtils.copyProperties(solution, solutionFromDB,"id");

        return solutionRepo.save(solutionFromDB);
    }

    //редактирование новости по её коду
    @PutMapping("solution/update/codesolution/{codeSolution}")
    public Solution updateFromCodeSolution(@PathVariable("codeSolution") String codeSolution, @RequestBody Solution solution) {

        Solution solutionFromDB = solutionRepo.getByCodeSolution(codeSolution);
        BeanUtils.copyProperties(solution,solutionFromDB,"id");

        return solutionRepo.save(solutionFromDB);
    }

    //редактирование новости по её заголовку
    @PutMapping("solution/update/head/{head}")
    public Solution updateFromHeadSolution(@PathVariable("head") String head, @RequestBody Solution solution) {

        Solution solutionFromDB = solutionRepo.getByHead(head);
        BeanUtils.copyProperties(solution,solutionFromDB,"id");

        return solutionRepo.save(solutionFromDB);
    }

    //удаление новости по id
    @DeleteMapping("solution/delete/id/{id}")
    public void deleteFromIdSolution(@PathVariable("id") Long id) {
        solutionRepo.delete(solutionRepo.getById(id));
    }

    //удаление новости по её коду
    @DeleteMapping("solution/delete/codesolution/{codeSolution}")
    public void deleteFromCodeSolution(@PathVariable("codeSolution") String codeSolution) {
        solutionRepo.delete(solutionRepo.getByCodeSolution(codeSolution));
    }
    //удаление новости по её заголовку
    @DeleteMapping("solution/delete/head/{head}")
    public void deleteFromHeadSolution(@PathVariable("head") String head) {
        solutionRepo.delete(solutionRepo.getByHead(head));
    }


    //создание новой новости
    @PostMapping("task/add")
    public Task createTask(@RequestBody Task newTask) {
        return task.save(newTask);
    }

    //редактирование новости по её id
    @PutMapping("task/update/id/{id}")
    public Task updateFromIdTask(@PathVariable("id") Long id, @RequestBody Task upTask) {

        Task taskFromDB = task.getById(id);
        BeanUtils.copyProperties(upTask,taskFromDB,"id");

        return task.save(taskFromDB);
    }

    //редактирование новости по её коду
    @PutMapping("task/update/codetask/{codeTask}")
    public Task updateFromCodeTask(@PathVariable("codeTask") String codeTask, @RequestBody Task neW) {

        Task taskFromDB = task.getByCodeTask(codeTask);
        BeanUtils.copyProperties(neW,taskFromDB,"id");

        return task.save(taskFromDB);
    }

    //редактирование новости по её заголовку
    @PutMapping("task/update/head/{head}")
    public Task updateFromHeadTask(@PathVariable("head") String head, @RequestBody Task neW) {

        Task newFromDB = task.getByHead(head);
        BeanUtils.copyProperties(neW,newFromDB,"id");

        return task.save(newFromDB);
    }

    //удаление новости по id
    @DeleteMapping("task/delete/id/{id}")
    public void deleteFromTask(@PathVariable("id") Long id) {
        task.delete(task.getById(id));
    }

    //удаление новости по её коду
    @DeleteMapping("task/delete/codetask/{codeTask}")
    public void deleteFromCodeTask(@PathVariable("codeTask") String codeTask) {
        task.delete(task.getByCodeTask(codeTask));
    }
    //удаление новости по её заголовку
    @DeleteMapping("task/delete/head/{head}")
    public void deleteFromHeadTask(@PathVariable("head") String head) {
        task.delete(task.getByHead(head));
    }

    //создание новой темы
    @PostMapping("theme/add")
    public Theme createTheme(@RequestBody Theme theme) {
        return themeRepo.save(theme);
    }

    //редактирование темы по её id
    @PutMapping("theme/update/id/{id}")
    public Theme updateFromIdTheme(@PathVariable("id") Long id, @RequestBody Task upTheme) {

        Theme themeFromDB = themeRepo.getById(id);
        BeanUtils.copyProperties(upTheme,themeFromDB,"id");

        return themeRepo.save(themeFromDB);
    }

    //редактирование темы по её коду
    @PutMapping("theme/update/codetheme/{codeTheme}")
    public Theme updateFromCodeTask(@PathVariable("codeTheme") String codeTheme, @RequestBody Theme newTheme) {

        Theme themeFromDB = themeRepo.getByCodeTheme(codeTheme);
        BeanUtils.copyProperties(newTheme,themeFromDB,"id");

        return themeRepo.save(themeFromDB);
    }

    //редактирование темы по её заголовку
    @PutMapping("theme/update/head/{head}")
    public Theme updateFromHeadTask(@PathVariable("head") String head, @RequestBody Theme newTheme) {

        Theme themeFromDB = themeRepo.getByHead(head);
        BeanUtils.copyProperties(newTheme,themeFromDB,"id");

        return themeRepo.save(themeFromDB);
    }

    //удаление темы по id
    @DeleteMapping("theme/delete/id/{id}")
    public void deleteFromTheme(@PathVariable("id") Long id) {
        themeRepo.delete(themeRepo.getById(id));
    }

    //удаление темы по её коду
    @DeleteMapping("theme/delete/codetheme/{codeTheme}")
    public void deleteFromCodeTheme(@PathVariable("codeTheme") String codeTheme) {
        themeRepo.delete(themeRepo.getByCodeTheme(codeTheme));
    }
    //удаление темы по её заголовку
    @DeleteMapping("theme/delete/head/{head}")
    public void deleteFromHeadTheme(@PathVariable("head") String head) {
        themeRepo.delete(themeRepo.getByHead(head));
    }



}
