package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.StudentDAO;


@Controller
public class SiatController {

	@RequestMapping(value="postProcess.do", method=RequestMethod.POST)
	public ModelAndView m3(@RequestParam("name") String name){
		ModelAndView mv = new ModelAndView();
		
		if(name.length()>0) {
			mv.addObject("name", StudentDAO.getStudent(name).getName());
			mv.addObject("age", StudentDAO.getStudent(name).getAge());
			mv.addObject("key", StudentDAO.getStudent(name).getKeyword());
			mv.addObject("img", StudentDAO.getStudent(name).getImg());
		}	
		mv.setViewName("bridge");
		return mv;
	}
	


	
}



