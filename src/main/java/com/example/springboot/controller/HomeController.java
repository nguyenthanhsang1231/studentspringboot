package com.example.springboot.controller;

import com.example.springboot.model.Student;
import com.example.springboot.repository.ClassRepository;
import com.example.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/students")
public class HomeController {
    @Autowired
    ClassRepository classRepository;
    @Autowired
    StudentRepository studentRepository;
    @GetMapping
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("list", studentRepository.findAll());
        return modelAndView;
    }
    @GetMapping("/add")
    public ModelAndView addGet() {
        ModelAndView modelAndView = new ModelAndView("/add");
        modelAndView.addObject("std", new Student());
        modelAndView.addObject("cls", classRepository.findAll());
        return modelAndView;
    }
    @PostMapping("/add")
    public String addPost(Student student) {
        studentRepository.save(student);
        return "redirect:/students";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editGet(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("stdedit", studentRepository.findById(id).get());
        modelAndView.addObject("clsed", classRepository.findAll());
        return modelAndView;
    }
    @GetMapping("/search")
    public ModelAndView search(@RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("list", studentRepository.findAllByClasssNameContaining(name));
        return modelAndView;
    }
}
