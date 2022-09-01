package kg.megacom.university.controllers;

import kg.megacom.university.models.Student;
import kg.megacom.university.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final StudentService studentService;

    public HomeController(StudentService studentService) {
        this.studentService = studentService;
    }
    //вывод списка студентов
    @GetMapping("/")
    public String mainPage(){
        return "home";
    }

    //вывод списка студентов
    @GetMapping("/main")
    public String homePage(Model model){
        Iterable<Student> students = studentService.findAll();
        model.addAttribute("title", "home page");
        model.addAttribute("student", students);
        return "main";
    }
    //Добавление студента
    @PostMapping("/addStudent")
    public  String addStudent(@RequestParam String name,
                              @RequestParam String sureName,
                              @RequestParam String studentGroup){
        studentService.addStudent(name,sureName,studentGroup);
        return "redirect:/main";
    }

}
