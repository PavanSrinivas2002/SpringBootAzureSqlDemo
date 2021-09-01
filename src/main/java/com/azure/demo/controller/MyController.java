package com.azure.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.demo.dao.StudentDao;
import com.azure.demo.model.Student;

@RestController
public class MyController {

@Autowired
StudentDao dao;

@RequestMapping(path="/check")
public String check(){
	return "Hello There this is my new commit";
}
@RequestMapping(path="/students",produces= {"application/json"})
public List<Student> allstudents(){
	List<Student> students=dao.findAll();
	return students;
}

@GetMapping(path="/student/{id}",produces= {"application/json"})
public Optional<Student> getstudent(@PathVariable("id") int id) {
	Optional<Student> s=dao.findById(id);
	return s;
}

@PostMapping(path="/addstudent",consumes= {"application/json"})
public String addstudent(@RequestBody Student s) {
	dao.save(s);
	return "Student added";
}


 @DeleteMapping("/deletestudent/{id}")
public String deletestudent(@PathVariable("id") int id) {
	
	dao.deleteById(id);
	return "Student deleted";
}


@PutMapping("/updatestudent")
public String updatestudent(@RequestBody Student s) {
	dao.save(s);
	return "Student Updated";
}
}
