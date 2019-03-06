package io.thgroupproject.basecampnomination.controllers;

import io.thgroupproject.basecampnomination.modal.Student;
import io.thgroupproject.basecampnomination.modal.UEstudents;
import io.thgroupproject.basecampnomination.repositories.UEstudentRepository;
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
    UEstudentRepository UErepository;


    @Autowired
    public LandingController(PostgresRepository repository, UEstudentRepository uerepository){
        studentRepository = repository;
        UErepository = uerepository;


    }


    @GetMapping("/2")
    public String next() {
        return "EligiblityQ";

    }

    @PostMapping("/2")
    public String index() {
        return "studentQuestions";
    }

    @GetMapping("/{uuid}")
    public String student(Model model, @PathVariable(value = "uuid") UUID uuid) {
        Optional<Student> student = studentRepository.findById(uuid);


        if (student.isPresent()) {
            model.addAttribute("student", student.get());
            model.addAttribute("students", studentRepository.findAll());
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
    @PostMapping("/thankYou")
    public String thankU(Student student) {
        studentRepository.saveStudent(student);

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



    @GetMapping("/applicant/{uuid}")
    public String applicant(Model model, @PathVariable(value = "uuid") UUID uuid) {
        Optional<UEstudents> applicant = UErepository.findById(uuid);


        if (applicant.isPresent()) {
            model.addAttribute("uestudent", applicant.get());
            return "UEstudent";
        } else {
            return "UEstudent";
        }

    }

    @GetMapping("/noneligible")
    public String eligibility(Model model) {
        model.addAttribute("uestudents", UErepository.findAll());
        return "UEstudents";
    }

    @GetMapping("/end")
    public String thanksU(){
        return "thankYou";
    }

    @PostMapping("/end")
    public String thanks(UEstudents uestudents){
        UErepository.saveStudent(uestudents);
        return "thankYou";
    }


}
