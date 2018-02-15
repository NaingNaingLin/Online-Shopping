package com.mos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mos.domain.Account;
import com.mos.domain.User;
import com.mos.service.AccountService;
import com.mos.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private AccountService accountService;

	@GetMapping("/user")
	public ModelAndView addUser(Model model) {

		ModelAndView modelandview = new ModelAndView();

		model.addAttribute("user", new User());
		model.addAttribute("account", new Account());
		modelandview.setViewName("admin/views/user");
		return modelandview;
	}

	@PostMapping("/user")
	public ModelAndView addUser(@ModelAttribute("user") User user, @ModelAttribute("account") Account account) {

		ModelAndView modelandview = new ModelAndView();
		userService.createUser(user);
		accountService.createAccount(account);
		modelandview.setViewName("admin/views/saveuser");
		return modelandview;

	}

}
