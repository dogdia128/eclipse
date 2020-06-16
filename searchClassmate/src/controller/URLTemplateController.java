package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.StudentDAO;

@Controller
public class URLTemplateController {
	@RequestMapping("{name}")
	public String m1(@PathVariable String name) {
		System.out.println(name);
		return "index";
	}
	
	
	@RequestMapping("search/{name}")
	public ModelAndView m2(@PathVariable String name) {
ModelAndView mv = new ModelAndView();
		
		if(name.length()>0) {
			mv.addObject("name", StudentDAO.getStudent(name).getName());
			mv.addObject("age", StudentDAO.getStudent(name).getAge());
			mv.addObject("key", StudentDAO.getStudent(name).getKeyword());
			mv.addObject("img", StudentDAO.getStudent(name).getImg());
		}	
		mv.setViewName("view");
		return mv;
	}
	
	

	
}
