package com.mos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	// @Autowired
	// private BCryptPasswordEncoder passwordEncoder;
	// @GetMapping("/user")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView addUser(Model model) {
		ModelAndView modelandview = new ModelAndView();
		User user = new User();
		user.setAccountId((new Account()));
		model.addAttribute("user", user);
		Account account = new Account();
		model.addAttribute("account", account);

		List<User> userList = new ArrayList<>();
		userList = userService.findAllUser();

		modelandview.addObject("saveuser", userList);
		modelandview.setViewName("admin/views/user/userform");
		return modelandview;
	}

	// @PostMapping("/user")
	@RequestMapping(value = "user", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") User user) {
		ModelAndView modelandview = new ModelAndView();
		userService.createUser(user);

		List<User> userList = new ArrayList<>();
		userList = userService.findAllUser();

		modelandview.addObject("saveuser", userList);
		modelandview.setViewName("admin/views/user/saveuser");
		return modelandview;
	}

	@RequestMapping(path = "userform/edit/{id}", method = RequestMethod.GET)
	public String editUser(@PathVariable("userId") Integer userId, Model model) {

		model.addAttribute("updatedUser", userService.findByUserId(userId));

		return "admin/views/user/edituser";
	}

	@RequestMapping(path = "userform/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editUser(@PathVariable("userId") Integer userId,
			@ModelAttribute("updatedUser") @Valid User updatedUser) {

		User existedUser = userService.findByUserId(userId);
		existedUser.setUserCode(updatedUser.getUserCode());
		existedUser.setFirstName(updatedUser.getFirstName());
		existedUser.setLastName(updatedUser.getLastName());
		existedUser.setDob(updatedUser.getDob());
		existedUser.setNrc(updatedUser.getNrc());
		existedUser.setAddress(updatedUser.getAddress());
		existedUser.setPhoneNo(updatedUser.getPhoneNo());
		existedUser.setUserCode(updatedUser.getUserCode());
		existedUser.setUserCode(updatedUser.getUserCode());

		//userService.editUser(userId);

		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("redirect:/list");
		return modelandview;
	}

	@RequestMapping(path = "userform/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable("userId") Integer userId) {

		ModelAndView modelandview = new ModelAndView();

		userService.deleteUser(userId);

		modelandview.setViewName("redirect:/saveuser");

		return modelandview;
	}

	/*
	 * @RequestMapping(path = "user" , method = RequestMethod.GET) public String
	 * createUser(Model model) { User user=new User();
	 * model.addAttribute("user",user); return "userform"; }
	 * 
	 * @RequestMapping(path="user", method=RequestMethod.POST) public String
	 * saveUser(@ModelAttribute("user")User user) { userService.createUser(user);
	 * return "redirect:/saveuser"; }
	 * 
	 * @RequestMapping(path = "userlist", method = RequestMethod.GET) public String
	 * userList(Model model) { model.addAttribute("users",
	 * userService.findAllUser()); return "saveuser"; }
	 * 
	 * @RequestMapping(path = "userform/edit/{id}", method = RequestMethod.GET)
	 * public String editProduct(Model model, @PathVariable(value = "id") Integer
	 * userId) { model.addAttribute("users", userService.findOneUser(userId));
	 * return "userfrom"; }
	 * 
	 * @RequestMapping(path = "userform/delete/{id}", method = RequestMethod.GET)
	 * public String deleteProduct(@PathVariable(name = "id") Integer userId) {
	 * userService.deleteUser(userId); return "redirect:/saveuser"; }
	 * 
	 * 
	 */
}
