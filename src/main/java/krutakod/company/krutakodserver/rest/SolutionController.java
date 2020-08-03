package krutakod.company.krutakodserver.rest;

import krutakod.company.krutakodserver.model.Solution;
import krutakod.company.krutakodserver.repository.SolutionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user/solution")
public class SolutionController {
    private final SolutionRepo solutionRepo;

    @Autowired
    public SolutionController(SolutionRepo solutionRepo){
        this.solutionRepo =solutionRepo;
    }

    @GetMapping
    public List<Solution> list(@RequestHeader Map<String, String> headers){
        if (headers.get("key").equals("cfylfkm12")) return solutionRepo.findAll();
        else return new ArrayList<Solution>();
    }
    //извлечение новости по её коду
    @GetMapping("codesolution/{codeSolution}")
    public Solution getNewByCodeNew(@PathVariable("codeSolution")String codeSolution,@RequestHeader Map<String, String> headers){
        if (headers.get("key").equals("cfylfkm12")) return solutionRepo.getByCodeSolution(codeSolution);
        else return new Solution();
    }

    //извлечение новости по её заголовку
    @GetMapping("head/{head}")
    public Solution getNewByHead(@PathVariable("head")String head,@RequestHeader Map<String, String> headers){
        if (headers.get("key").equals("cfylfkm12")) return solutionRepo.getByHead(head);
        else return new Solution();
    }
    //извлечение новости по её id
    @GetMapping("id/{id}")
    public Solution getLessByHead(@PathVariable("id")Long id,@RequestHeader Map<String, String> headers){
        if (headers.get("key").equals("cfylfkm12")) return solutionRepo.getById(id);
        else return new Solution();
    }

//    //создание новой новости
//    @PostMapping("/add")
//    public Solution create(@RequestBody Solution solution) {
//        return solutionRepo.save(solution);
//    }
//
//    //редактирование новости по её id
//    @PutMapping("update/{id}")
//    public Solution updateFromId(@PathVariable("id") Long id, @RequestBody Solution solution) {
//
//        Solution solutionFromDB = solutionRepo.getById(id);
//        BeanUtils.copyProperties(solution, solutionFromDB,"id");
//
//        return solutionRepo.save(solutionFromDB);
//    }
//
//    //редактирование новости по её коду
//    @PutMapping("update/{codeSolution}")
//    public Solution updateFromCodeNew(@PathVariable("codeSolution") String codeSolution, @RequestBody Solution solution) {
//
//        Solution solutionFromDB = solutionRepo.getByCodeSolution(codeSolution);
//        BeanUtils.copyProperties(solution,solutionFromDB,"id");
//
//        return solutionRepo.save(solutionFromDB);
//    }
//
//    //редактирование новости по её заголовку
//    @PutMapping("update/{head}")
//    public Solution updateFromHeadNew(@PathVariable("head") String head, @RequestBody Solution solution) {
//
//        Solution solutionFromDB = solutionRepo.getByHead(head);
//        BeanUtils.copyProperties(solution,solutionFromDB,"id");
//
//        return solutionRepo.save(solutionFromDB);
//    }
//
//    //удаление новости по id
//    @DeleteMapping("delete/{id}")
//    public void deleteFromId(@PathVariable("id") Long id) {
//        solutionRepo.delete(solutionRepo.getById(id));
//    }
//
//    //удаление новости по её коду
//    @DeleteMapping("delete/{codeSolution}")
//    public void deleteFromCodeNew(@PathVariable("codeSolution") String codeSolution) {
//        solutionRepo.delete(solutionRepo.getByCodeSolution(codeSolution));
//    }
//    //удаление новости по её заголовку
//    @DeleteMapping("delete/{head}")
//    public void deleteFromHeadNew(@PathVariable("head") String head) {
//        solutionRepo.delete(solutionRepo.getByHead(head));
//    }
}
