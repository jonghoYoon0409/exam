package com.hk.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.board.command.LoginCommand;


@Controller
public class HomeController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("loginCommand", new LoginCommand());
		return "index";
	}
	
}
