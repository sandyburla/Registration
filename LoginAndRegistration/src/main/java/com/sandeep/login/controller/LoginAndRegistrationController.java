package com.sandeep.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sandeep.login.model.Register;
import com.sandeep.login.repository.LoginAndRegisterDao;
import com.sandeep.login.service.LoginAndRegisterService;


@Controller
@RequestMapping
public class LoginAndRegistrationController {
	

	@Autowired
	LoginAndRegisterService loginAndRegisterService;
	
	@Autowired
	LoginAndRegisterDao loginAndRegisterDao;
	
	@Autowired 
	BCryptPasswordEncoder bCryptPasswordEncoder ;
	
	@PostMapping (value = "/register")
	public String createUser(@ModelAttribute Register reg) {
		System.out.println("req===>"+reg);
		reg.setPassword(bCryptPasswordEncoder.encode(reg.getPassword()));
		loginAndRegisterService.createUser(reg);
        return "welcome";
	}
//	@RequestMapping( value = "/home")
//	public ModelAndView hello(){
//		System.out.println("home");
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("registration");
//		return mav;
//	}
	@RequestMapping("/login")
    public ModelAndView login(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
    }
	@RequestMapping("/registration")
    public ModelAndView register(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("registration");
		return mav;
    }
	
	@RequestMapping("/showAll")
	public ModelAndView  getAll(ModelAndView model) {
		List<Register> listEmp = loginAndRegisterService.getAll();
		model.addObject("listEmp", listEmp);
		model.setViewName("index");
		return model;
	} 
	@RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") int id){
		ModelAndView model = new ModelAndView("edit_user");
		Register register = loginAndRegisterService.getid(id);
		System.out.println(register);
		model.addObject("register", register);
		return model;
	}
	@RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable(name = "id") int id){
		loginAndRegisterDao.deleteById(id);
		ModelAndView model = new ModelAndView("delete_user");
		return model;
		
	}

}
