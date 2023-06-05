package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/")
public class UsersController {

	UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public String showAllUsers(ModelMap model) {
		model.addAttribute("users", userService.readAllUsers());
		return "users";
	}

	@GetMapping("/new")
	public String newUser(ModelMap model) {
		model.addAttribute("user", new User());
		return "new";
	}

	@PostMapping()
	public String create(@ModelAttribute("user") User user) {
		userService.create(user);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String update(ModelMap model, @PathVariable("id") long id) {
		model.addAttribute("user", userService.getUserById(id));
		return "edit";
	}

	@PatchMapping("/{id}")
	public String edit(@ModelAttribute("user") User user) {
		userService.update(user);
		return "redirect:/";
	}

	@GetMapping("/remove/{id}")
	public String remove(@PathVariable("id") long id) {
		userService.delete(id);
		return "redirect:/";
	}


}