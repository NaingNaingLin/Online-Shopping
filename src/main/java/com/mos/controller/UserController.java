package com.mos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mos.domain.User;
import com.mos.service.AccountService;
import com.mos.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private AccountService accountService;
	// @Autowired
	// private BCryptPasswordEncoder passwordEncoder;
	//@GetMapping("/user")
	/*@RequestMapping(value="/user" ,method = RequestMethod.GET)
	public ModelAndView addUser(Model model) {
		ModelAndView modelandview = new ModelAndView();
		model.addAttribute("user", new User());
		model.addAttribute("account", new Account());
		modelandview.setViewName("admin/views/userform");
		return modelandview;
	}
	//@PostMapping("/user")
	@RequestMapping(value="user",method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") User user,
								@ModelAttribute("user") Account account) {
		ModelAndView modelandview = new ModelAndView();
		userService.createUser(user);
		accountService.createAccount(account);
		modelandview.setViewName("admin/views/saveuser");
		return modelandview;
	}
	@RequestMapping("/user/userlist")
	public ModelAndView viewUserList() {
		ModelAndView modelandview = new ModelAndView();
		List<User> list=userService.findAll();
		
		return modelandview;
	}*/
	@RequestMapping(path = "users" , method = RequestMethod.GET)
	public String createUser(Model model) {
		User user=new User();
		model.addAttribute("users",user);
		return "userform";
	}
	@RequestMapping(path="users", method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("users")User user) {
		userService.createUser(user);
		return "redirect:/saveuser";
	}
	@RequestMapping(path = "userlist", method = RequestMethod.GET)
	public String userList(Model model) {
		model.addAttribute("users", userService.findAllUser());
		return "saveuser";
	}
	 @RequestMapping(path = "userform/edit/{id}", method = RequestMethod.GET)
	    public String editProduct(Model model, @PathVariable(value = "id") Integer userId) {
	        model.addAttribute("users", userService.findOneUser(userId));
	        return "userfrom";
	    }

	    @RequestMapping(path = "userform/delete/{id}", method = RequestMethod.GET)
	    public String deleteProduct(@PathVariable(name = "id") Integer userId) {
	       userService.deleteUser(userId);
	        return "redirect:/saveuser";
	    }

	
	
}
