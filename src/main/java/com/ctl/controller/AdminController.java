package com.ctl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ctl.model.Fabricante;
import com.ctl.model.Historia;
import com.ctl.model.User;
import com.ctl.repository.UserRepository;
import com.ctl.util.AdvancedSearchUtil;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
    private AdvancedSearchUtil search;

    @GetMapping
    public String list(Model model) {
        model = search.build(model);
        model.addAttribute("user", new User());

        return "admin/index";
    }
    
    @RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("admin/registration");
		return modelAndView;
	}
	
    @GetMapping("/register")
    public String registration(Model model) {
        model = search.build(model);
        model.addAttribute("user", new User());

        return "admin/register";
    }
    
    @GetMapping("/users")
    public String listUsers(Model model) {
        model = search.build(model);
        model.addAttribute("user", new User());

        return "admin/users";
    }

}


