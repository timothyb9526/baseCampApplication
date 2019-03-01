package io.thgroupproject.basecampnomination.controllers;

import io.thgroupproject.basecampnomination.modal.Student;
import io.thgroupproject.basecampnomination.repositories.PostgresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/")

public class LandingController {

    PostgresRepository studentRepository;

    @Autowired
    public LandingController(PostgresRepository repository) {
        studentRepository = repository;

    }


    @GetMapping("/2")
    public String next() {
        return "studentQuestions";

    }

    @PostMapping("/2")
    public String index(Student student) {
        studentRepository.saveStudent(student);
        return "studentQuestions";
    }

    @GetMapping("/{uuid}")
    public String student(Model model, @PathVariable(value = "uuid") UUID uuid) {
        Optional<Student> student = studentRepository.findById(uuid);

        if (student.isPresent()) {
            model.addAttribute("student", student.get());
            return "student";
        } else {
            return "students";
        }

    }

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students";
    }

    @GetMapping("/thankYou")
    public String thankYou() {
        return "thankYou";
    }

    @GetMapping("/")
    public String home(){
        return "Home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }




}
