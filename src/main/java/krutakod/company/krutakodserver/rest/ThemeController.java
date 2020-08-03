package krutakod.company.krutakodserver.rest;


import krutakod.company.krutakodserver.model.Theme;
import krutakod.company.krutakodserver.repository.ThemeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user/theme")
public class ThemeController {
    private final ThemeRepo themeRepo;

    @Autowired
    public ThemeController(ThemeRepo themeRepo) {
        this.themeRepo = themeRepo;
    }

    //извлечение всех тем
    @GetMapping
    public List<Theme> list(@RequestHeader Map<String, String> headers) {
        if (headers.get("key").equals("cfylfkm12")) return themeRepo.findAll();
        return new ArrayList<Theme>();
    }

}
