package in.manoj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import in.manoj.binding.Student;
import in.manoj.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	public StudentService service;
	
	@GetMapping("/")
	public String loadIndexPage(Model model) {
		
		init (model);
		return "index";
		}
    
	private void init(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("courses", service.getCourses());
		model.addAttribute("prefTimings", service.getTimings());
	}
	
	@PostMapping("/save")
	public String handleSubmitBtn(Student s, Model model) {
		
		boolean isSaved = service.saveStudent(s);
		
		if(isSaved) {
		model.addAttribute("msg","Data Saved..");
		}
		init (model);
		return "index";
	}
	
}
